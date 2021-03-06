package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet", urlPatterns = {"/hello-servlet","/hello"})
@WebServlet(urlPatterns = {"/hello-servlet","/hello","*.do","/hi"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello !";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        response.getWriter().println("serverName: "+ request.getServerName());
        response.getWriter().println(request.getAuthType());
    }

    public void destroy() {
    }
}