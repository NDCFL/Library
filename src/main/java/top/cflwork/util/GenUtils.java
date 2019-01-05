package top.cflwork.util;


import top.cflwork.config.Constant;
import top.cflwork.vo.ColumnVo;
import top.cflwork.vo.TableVo;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 */
public class GenUtils {


    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        //后端
        templates.add("templates/generator/vo.java.vm");
        templates.add("templates/generator/Dao.java.vm");
        templates.add("templates/generator/Mapper.xml.vm");
        templates.add("templates/generator/Service.java.vm");
        templates.add("templates/generator/ServiceImpl.java.vm");
        templates.add("templates/generator/Controller.java.vm");
        //bootstrap格式
        templates.add("templates/generator/page.html.vm");
        templates.add("templates/generator/js.js.vm");
        //layui 格式
        templates.add("templates/generator/list.html.vm");
        templates.add("templates/generator/add.html.vm");
        templates.add("templates/generator/edit.html.vm");
        templates.add("templates/generator/list.js.vm");
        templates.add("templates/generator/add.js.vm");
        templates.add("templates/generator/edit.js.vm");
        //sql 脚本
        templates.add("templates/generator/menu.sql.vm");

        return templates;
    }
    /**
     * 生成代码
     */

    public static void generatorCode(Map<String, String> table,List<Map<String, String>> columns, ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();
        //表信息
        TableVo tableVo = new TableVo();
        tableVo.setTableName(table.get("tableName"));
        tableVo.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableVo.getTableName(), config.getString("tablePrefix"), config.getString("autoRemovePre"));
        tableVo.setClassName(className);
        tableVo.setClassname(StringUtils.uncapitalize(className));
        //列信息
        List<ColumnVo> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnVo columnDO = new ColumnVo();
            columnDO.setColumnName(column.get("columnName"));
            columnDO.setDataType(column.get("dataType"));
            columnDO.setComments(column.get("columnComment"));
            columnDO.setExtra(column.get("extra"));
            //列名转换成Java属性名
            String attrName = columnToJava(columnDO.getColumnName());
            columnDO.setAttrName(attrName);
            columnDO.setAttrname(StringUtils.uncapitalize(attrName));
            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnDO.getDataType(), "unknowType");
            columnDO.setAttrType(attrType);
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableVo.getPk() == null) {
                tableVo.setPk(columnDO);
            }
            columsList.add(columnDO);
        }
        tableVo.setColumns(columsList);
        //没主键，则第一个字段为主键
        if (tableVo.getPk() == null) {
            tableVo.setPk(tableVo.getColumns().get(0));
        }
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        //封装模板数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("tableName", tableVo.getTableName());
        map.put("comments", tableVo.getComments());
        map.put("pk", tableVo.getPk());
        map.put("className", tableVo.getClassName());
        map.put("classname", tableVo.getClassname());
        map.put("pathName", config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1));
        map.put("columns", tableVo.getColumns());
        map.put("package", config.getString("package"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);
        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableVo.getClassname(), tableVo.getClassName(), config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1))));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new BDException("渲染模板失败，表名：" + tableVo.getTableName(), e);
            }
        }
    }


    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix, String autoRemovePre) {
        if (Constant.AUTO_REOMVE_PRE.equals(autoRemovePre)) {
            tableName = tableName.substring(tableName.indexOf("_") + 1);
        }
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }

        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new BDException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String classname, String className, String packageName) {
        String packagePath = File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }

        if (template.contains("vo.java.vm")) {
            return packagePath +"后端"+ File.separator + className + "Vo.java";
        }

        if (template.contains("Dao.java.vm")) {
            return packagePath +"后端"+ File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm")) {
            return packagePath +"后端"+ File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath +"后端"+ File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath +"后端"+ File.separator + className + "Controller.java";
        }

        if (template.contains("Mapper.xml.vm")) {
            return packagePath +"后端"+ File.separator + className + "Mapper.xml";
        }

        if (template.contains("page.html.vm")) {
            return packagePath +"前端"+ File.separator +"bootstrap"+ File.separator +classname+ File.separator + classname + ".html";
        }
        if (template.contains("js.js.vm")) {
            return packagePath +"前端"+ File.separator +"bootstrap"+ File.separator  +"js"+File.separator + classname + ".js";
        }

		if(template.contains("menu.sql.vm")){
			return packagePath +"sql"+ File.separator + classname+ "_menu.sql";
		}

        if (template.contains("list.html.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"html" +File.separator+ classname + ".html";
        }
        if (template.contains("add.html.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"html" +File.separator+ "add.html";
        }
        if (template.contains("edit.html.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"html" +File.separator + "edit.html";
        }

        if (template.contains("list.js.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"js" +File.separator+ classname + ".js";
        }
        if (template.contains("add.js.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"js" +File.separator+  classname +"add.js";
        }
        if (template.contains("edit.js.vm")) {
            return packagePath +"前端"+ File.separator +"layui"+ File.separator +"js" +File.separator + "edit.js";
        }
        return null;
    }
}
