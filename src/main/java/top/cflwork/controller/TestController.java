package top.cflwork.controller;

import com.xiaoleilu.hutool.json.JSONUtil;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.cflwork.util.JpushReceiver;
import top.cflwork.vo.jpush.Extras;
import top.cflwork.vo.jpush.JpushApp;
import top.cflwork.vo.jpush.Push;

import javax.annotation.Resource;

@Controller
@RequestMapping("test")
public class TestController {
    @Resource
    private JpushReceiver jpushReceiver;
    @RequestMapping("index")
    public String index() throws Exception {
        return "/ueditor/index";
    }
    @RequestMapping("page")
    public String page() throws Exception {
        return "/socketio";
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
    @RequestMapping("testUp")
    public void testSend(){
        Push push = null;
        push = Push.newBuilder(JpushApp.HOTEL)
                .setTag("111111")
                .setMessage(Push.Message.newBuilder().setMsgContent("test").setExtras(Extras.newBuilder().setType(Extras.SCHOOL_BROADCAST).setId("1").build()).build())
                .build();
        jpushReceiver.sendPush(JSONUtil.toJsonStr(push));
        System.out.println("消息推送=================");
    }

}
