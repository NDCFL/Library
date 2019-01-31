package top.cflwork.controller;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * 青海 webservice 测试
 */
public class ProtocolSend {

	public static void main(String args[]) {
		String ip = "111.44.140.226";
		String port = "8083";
		String wsUrl = "DLibsAPI/services/ReaderWS";
		String wsNameSpace = "http://impl.server.axis2.dlibs.com";
		String method = "receive";
		String xmlParams = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><verification><authorizationCode><![CDATA[123456]]></authorizationCode><subCenterCode><![CDATA[QHL]]></subCenterCode></verification><userInfo><ip>192.168.1.107</ip><userid>wh</userid></userInfo><text><eventType>10020</eventType><cardno>QHL0000701</cardno><password>123456</password></text></root>";
		System.out.println("开始====================");
		String result = ProtocolSend.send(ip, port, wsUrl, wsNameSpace, method, xmlParams);
		System.out.println("返回结果：" + result);
		System.out.println("结束====================");
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
