package com.example.demo;
/* demo
 * @created 05/29/2022
 * @author Konstantin Staykov
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/params")
public class ParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // To get the parameter name: http://localhost:8080/kon/params?name=bob
        String name = req.getParameter("name");// bob
        resp.getWriter().println("Hello "+ name);// hello bob
    }
}
