package top.cflwork.common;

import com.google.gson.JsonObject;
import com.qiniu.util.Json;
import com.xiaoleilu.hutool.json.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Component;
import top.cflwork.vo.SendVo;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

@Component
public class XmlSendUtil {

    public ResponseJson send(SendVo sendVo) {
        String result = null;
        String url = "http://";
        url += sendVo.getIp();
        if (sendVo.getPort() != null && !"".equals(sendVo.getPort())) {
            url += ":" + sendVo.getPort();
        }
        url += "/" + sendVo.getWsUrl();
        Object object = null;
        try {
            Call call;
            Service service = new Service();// 创建service对象
            call = (Call) service.createCall();
            call.setMaintainSession(true);
            call.setOperationName(new QName(sendVo.getWsNameSpace() == null ? url : sendVo.getWsNameSpace(), sendVo.getMethod()));// getByusername是服务端接口的方法名称url是接口地址
            try {
                call.setTargetEndpointAddress(new java.net.URL(url));
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
                return  new ResponseJson(false,"建立连接失败");
            }// 接口地址
//             call.getMessageContext().setUsername(sendVo.getName());//axis中的用户名。
//             call.getMessageContext().setPassword(sendVo.getPwd());//密码
            try {
                object = call.invoke(new Object[] { sendVo.getXmlParams() });
                result = object.toString();
                System.out.println(result);
                return  new ResponseJson(true,result);
            } catch (RemoteException e1) {
                e1.printStackTrace();
                return  new ResponseJson(false,"返回数据接口失败");
            }
        } catch (ServiceException e) {
            System.out.println("---------xml请求错误--------");
            e.printStackTrace();
            return  new ResponseJson(false,"连接失败");
        }
    }
}
