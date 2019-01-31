package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Transient;
import java.util.Date;
import java.text.DateFormat;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import javax.xml.namespace.QName;
import java.lang.Integer;
import javax.xml.rpc.ParameterMode;
@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("index")
    public String index() throws Exception {
        return "/ueditor/index";
    }

    /**
     * 测试xml调用
     */

    public static void main(String[] args) {

        try {
            String endpoint = "http://localhost:8080/ca3/services/caSynrochnized?wsdl";
            // 直接引用远程的wsdl文件
            // 以下都是套路
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            call.setOperationName("addUser");// WSDL里面描述的接口名称
            call.addParameter("userName",
                    org.apache.axis.encoding.XMLType.XSD_DATE,
                    javax.xml.rpc.ParameterMode.IN);// 接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
            String temp = "测试人员";
            String result = (String) call.invoke(new Object[] { temp });
            // 给方法传递参数，并且调用方法
            System.out.println("result is " + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


}
