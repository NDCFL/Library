package top.cflwork.controller;

import com.xiaoleilu.hutool.http.HttpUtil;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import top.cflwork.util.JaXmlBeanUtil;
import top.cflwork.vo.xmlvo.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 青海 webservice 测试
 */
public class ProtocolSend {

	public static void main(String args[]) {
        //获取读者信息
//        geteRead();
        //图书检索
//        geteBook();
        //获取书目信息
//        geteBookList();
        //馆藏信息
//        geteGc();
        //获取借阅记录
//        getJy();
        //获取流通记录
//        getLtjl();
        //新书通报
//        getxstb();
//        排行榜
        getphb();
	}

	public static String geteRead(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/ReaderWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><userInfo><ip>192.168.1.107</ip><userid>wh</userid></userInfo><text><eventType>10020</eventType><cardno>QHL0000701</cardno><password>123456</password></text></root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        ReadRootVo readRootVo = JaXmlBeanUtil.converyToJavaBean(result, ReadRootVo.class);
        System.out.println("返回结果：" + readRootVo.getText().getEquipvalue());
        System.out.println("结束====================");
        return result;
    }

    public static String geteBook(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/AssetsWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text>" +
                "<eventType>10018</eventType>\n" +
                "    <pageNo>1</pageNo>\n" +
                "    <pageSize>20</pageSize>\n" +
                "    <select1>all</select1>\n" +
                "    <text1>经济管理</text1>\n" +
                "<occur1/>" +
                "</text></root>";
        System.out.println("开始===================="+xmlParams);
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        BookSearchRootVo searchRootVos = JaXmlBeanUtil.converyToJavaBean(result,BookSearchRootVo.class);
        System.out.println("返回结果：" + searchRootVos);
        System.out.println("结束====================");
        return result;
    }
    public static String geteBookList(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/BibliosWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text>\n" +
                "      <eventType>10013</eventType>\n" +
                "      <metaid>1000</metaid>\n" +
                "      <metatable>i_biblios</metatable>\n" +
                "      </text></root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        MetaTableRootVo metaTableRootVo = JaXmlBeanUtil.converyToJavaBean(result,MetaTableRootVo.class);
        System.out.println("返回结果：" + metaTableRootVo);
        System.out.println("结束====================");
        return result;
    }


    public static String geteGc(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/AssetsWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text>\n" +
                "        <eventType>10016</eventType>\n" +
                " <metaid>269511</metaid>\n" +
                " <metatable>i_biblios</metatable>\n" +
                " <pageNo>1</pageNo>\n" +
                " <pageSize>100</pageSize>\n" +
                " </text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        CollectionBookRootVo collectionBookRootVo = JaXmlBeanUtil.converyToJavaBean(result,CollectionBookRootVo.class);
        System.out.println("返回结果：" + collectionBookRootVo);
        System.out.println("结束====================");
        /**
         * <barcode><![CDATA[010501610]]></barcode>
         <callno><![CDATA[J218.2/77]]></callno>
         <regdate><![CDATA[2013-10-30]]></regdate>
         <retudate><![CDATA[2015-02-20]]></retudate>
         <status><![CDATA[普通借出]]></status>
         <metaid><![CDATA[269511]]></metaid>
         <metatable><![CDATA[i_biblios]]></metatable>
         <price><![CDATA[3800]]></price>
         <sublib><![CDATA[青海省图书馆]]></sublib>
         <local><![CDATA[一楼]]></local>
         <cursublib><![CDATA[青海省图书馆]]></cursublib>
         <curlocal><![CDATA[一楼]]></curlocal>
         */
        return result;
    }
    public static String getJy(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/ReaderWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text> \n" +
                "    <eventType>10015</eventType>  \n" +
                "    <cardno>QHL0000701</cardno> \n" +
                "  </text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        BorrowsRootVo borrowRootVo= JaXmlBeanUtil.converyToJavaBean(result,BorrowsRootVo.class);
        System.out.println("返回结果：" + borrowRootVo);
        System.out.println("结束====================");
        return result;
    }
    //根据读者证号查询读者历史流通记录
    public static String getLtjl(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/ReaderWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text> \n" +
                "    <eventType>10025</eventType>  \n" +
                "    <cardno>QHL0000701</cardno> " +
                "    <startDate>2016-01-01</startDate>  \n" +
                "    <endDate>2019-01-31</endDate>  \n" +
                "    <pageNo>1</pageNo>  \n" +
                "    <pageSize>20</pageSize>" +
                "  </text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        System.out.println(result);
        ReadBorrowRootVo readBorrowRootVo= JaXmlBeanUtil.converyToJavaBean(result,ReadBorrowRootVo.class);
        System.out.println("返回结果：" + readBorrowRootVo);
        System.out.println("结束====================");
        return result;
    }

    //新书通报
    public static String getxstb(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/AssetsWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text> \n" +
                "       <eventType>10003</eventType>\n" +
                "      <startDate>2018-01-03</startDate>\n" +
                "       <endDate>2019-02-03</endDate>\n" +
                "      <sublib>QHL</sublib>\n" +
                "      <pageNo>1</pageNo>  \n" +
                "      <pageSize>10</pageSize> </text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        NewBookRootVo newBookRootVo= JaXmlBeanUtil.converyToJavaBean(result,NewBookRootVo.class);
        System.out.println("返回结果：" + newBookRootVo);
        System.out.println("结束====================");
        return result;
    }

    public static String getphb(){
        String ip = "111.44.140.226";
        String port = "8083";
        String wsUrl = "DLibsAPI/services/AssetsWS";
        String wsNameSpace = "http://impl.server.axis2.dlibs.com";
        String method = "receive";
        String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><text> \n" +
                "       <eventType>10002</eventType>\n" +
                "      <sublib>QHL</sublib>  \n" +
                "    <time>201601</time>  \n" +
                "    <type>Month</type>  \n" +
                "    <pageNo>1</pageNo>  \n" +
                "    <pageSize>10</pageSize> " +
                "</text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        System.out.println("返回结果：" + result);
        System.out.println("结束====================");
        return result;
    }

    /**
	 * 
	 * 
	 * @param
	 * @return
	 * @param ip
	 * @param port
	 * @param wsUrl
	 * @param wsNameSpace
	 *            "http://client.axis2.cloud.dlibs.com";
	 *            这个命名空间是调用类的包名反过来，在前面加上http://即可
	 * @param method
	 * @param xmlParams
	 *            格式 "<root>" +
	 *            "<verification><name>admin</name><password>******</password></verification>"
	 *            + "<barcode>"+barcode+"</barcode>" +
	 *            "<equipno>"+querymodel+"</equipno>" +
	 *            "<cardno>"+cardno+"</cardno>" + "</root>";
	 *            root、verification(name、password)为定节点(节点名都得定义的一样)，其他可以自定义
	 * @return
	 */
	public static String send(String ip, String port, String wsUrl, String wsNameSpace, String method, String xmlParams) {
		String result = null;
		String url = "http://";
		url += ip;
		if (port != null && !"".equals(port)) {
			url += ":" + port;
		}
		url += "/" + wsUrl;
		Object object = null;
		try {
			Call call;

			Service service = new Service();// 创建service对象

			call = (Call) service.createCall();

			call.setMaintainSession(true);

			call.setOperationName(new QName(wsNameSpace == null ? url : wsNameSpace, method));// getByusername是服务端接口的方法名称url是接口地址
			try {
				call.setTargetEndpointAddress(new java.net.URL(url));
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}// 接口地址
			// call.getMessageContext().setUsername(name);//axis中的用户名。
			// call.getMessageContext().setPassword(pwd);//密码
			try {
				object = call.invoke(new Object[] { xmlParams });
				result = object.toString();
			} catch (RemoteException e1) {
				result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><code>2</code><reason>连接出现问题！请检查IP[" + ip
						+ "]与端口号！</reason></root>";
				e1.printStackTrace();
			}
		} catch (ServiceException e) {
			System.out.println("-----------------");
			e.printStackTrace();
		}
		return result;
	}

    public static String resultJson(String xml) {
        return HttpUtil.post("https://www.sojson.com/json/xml2json/execute.shtml","xml="+xml);

    }
}
