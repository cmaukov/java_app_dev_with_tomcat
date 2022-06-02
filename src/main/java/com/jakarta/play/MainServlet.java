package com.jakarta.play;
/* demo
 * @created 05/30/2022
 * @author Konstantin Staykov
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "*.do", ""})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        String name = req.getParameter("name");
        if (name != null) {
            resp.getWriter().println(String.format("<name>Hello %s</name>", name));
        }else {
            resp.getWriter().println(String.format("<msg>Please enter your name</msg>"));
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        String name = req.getParameter("name");
        if (name != null && !name.equals("")) {
            resp.getWriter().println(String.format("<name>Hello %s</name>", name));
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
