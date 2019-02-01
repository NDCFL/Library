package top.cflwork.common;

import org.springframework.context.annotation.Configuration;
import top.cflwork.util.Socketio;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Configuration
@WebListener
public class SocketioLisener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //启动Socketio服务
        Socketio socketio = new Socketio();
        socketio.startServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭Socketio服务
        Socketio socketio = new Socketio();
        socketio.stopSocketio();
    }

}