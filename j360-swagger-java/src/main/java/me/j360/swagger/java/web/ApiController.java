package me.j360.swagger.java.web;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: min_xu
 * @date: 2018/8/15 下午4:11
 * 说明：
 */
public class ApiController extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        PrintWriter out = response.getWriter();
        out.print("<h3>swagger test!</h3>");
    }

}