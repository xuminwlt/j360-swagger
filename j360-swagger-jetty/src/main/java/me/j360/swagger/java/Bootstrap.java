package me.j360.swagger.java;

import lombok.extern.slf4j.Slf4j;
import me.j360.swagger.java.configuration.WebApplicationBootstrap;
import me.j360.swagger.java.configuration.WebApplicationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author: min_xu
 * @date: 2018/8/15 下午3:19
 * 说明：
 */

@Slf4j
public class Bootstrap {

    public static final int DEFAULT_PORT = 8080;
    public static final String DEFAULT_CONTEXT_PATH = "/";

    public static void main(String[] args) throws Exception {
        runJettyServer(DEFAULT_PORT, DEFAULT_CONTEXT_PATH);
    }

    public static void runJettyServer(int port, String contextPath) {
        Server server = createServer(port, contextPath);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error("Bootstrap start fail", e);
        } finally {
            try {
                server.stop();
            } catch (Exception e) {
                log.error("Bootstrap stop fail", e);
            }
        }
    }

    public static Server createServer(int port, String contextPath) {
        Server server = new Server();
        server.setStopAtShutdown(true);

        ServerConnector connector = new ServerConnector(server);
        // 设置服务端口
        connector.setPort(port);
        connector.setReuseAddress(false);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath(contextPath);
        server.setHandler(context);

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebApplicationConfiguration.class);
        context.addEventListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebApplicationBootstrap.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(mvcContext);
        context.addServlet(new ServletHolder(dispatcherServlet), "/*");

//        ServletContext servletContext = dispatcherServlet.getServletContext();
//        String activeProfile = System.getProperty("spring.profiles.active");
//        if (activeProfile == null) {
//            activeProfile = "dev"; // or whatever you want the default to be
//        }
//        servletContext.setInitParameter("spring.profiles.active", activeProfile);

        return server;
    }
}
