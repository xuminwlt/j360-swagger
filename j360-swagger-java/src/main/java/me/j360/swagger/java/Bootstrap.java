package me.j360.swagger.java;

import me.j360.swagger.java.web.ApiController;
import org.eclipse.jetty.server.Server;

/**
 * @author: min_xu
 * @date: 2018/8/15 下午3:19
 * 说明：
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new ApiController());
        server.start();
        server.join();
    }
}
