package top.cflwork.controller;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import top.cflwork.util.JaXmlBeanUtil;
import top.cflwork.vo.xmlvo.ReadRootVo;
import top.cflwork.vo.xmlvo.ReadVo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * 青海 webservice 测试
 */
public class ProtocolSend {

	public static void main(String args[]) {
        //获取读者信息
        geteRead();
        //图书检索
//        geteBook();
        //获取书目信息
//        geteBookList();
        //馆藏信息
//        geteGc();
        //获取借阅记录
//        getJy();

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
                "    <text1>玄幻</text1>\n" +
                "<occur1/>" +
                "</text></root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        System.out.println("返回结果：" + result);
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
        System.out.println("返回结果：" + result);
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
                " <metaid>300</metaid>\n" +
                " <metatable>i_bbl_biblios</metatable>\n" +
                " <pageNo>1</pageNo>\n" +
                " <pageSize>100</pageSize>\n" +
                " </text>" +
                "</root>";
        System.out.println("开始====================");
        String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
        System.out.println("返回结果：" + result);
        System.out.println("结束====================");
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
}
