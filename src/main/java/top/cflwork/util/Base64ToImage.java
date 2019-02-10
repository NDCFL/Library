package top.cflwork.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class Base64ToImage {
    public static String imgUpload(String imgBase64Data){
        try {
            if(imgBase64Data == null || "".equals(imgBase64Data)){
                return  null;
            }
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            File uploadPathFile = new File(path.getAbsolutePath(),"static/img/upload/");
            if(!uploadPathFile.exists()) uploadPathFile.mkdirs();
            //创建父类文件
            if(!uploadPathFile.exists() && !uploadPathFile.isDirectory()){
                uploadPathFile.mkdirs();
            }
            File imgeFile = new File(uploadPathFile,new Date().getTime()+".jpg");
            if(!imgeFile.exists()){
                imgeFile.createNewFile();
            }
            //对base64进行解码
            byte[] result = decodeBase64(imgBase64Data);
            //使用Apache提供的工具类将图片写到指定路径下
            FileUtils.writeByteArrayToFile(imgeFile,result);
            String imgPath=uploadPathFile+"/"+imgeFile.getName();
            return imgPath;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }
    public static void base64ToFile(String base64)throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes1 = decoder.decodeBuffer(base64);
        OutputStream out=new FileOutputStream("d://a.jpg");
        out.write(bytes1);
        out.flush();
        out.close();
    }
}
