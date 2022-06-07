package com.jakarta.play;
/* demo
 * @created 05/30/2022
 * @author Konstantin Staykov
 */

import com.jakarta.play.blog.ApplicationSettings;
import com.jakarta.play.blog.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/home", "*.do", ""},initParams = {@WebInitParam(name = "productName",value = "My Super Product")})
@WebServlet(urlPatterns = {"/home", "*.do"}, name = "Main")
public class MainServlet extends HttpServlet {
    String product = "";

    @Override
    public void init() throws ServletException {
        product = getServletContext().getInitParameter("productName");

        if (product == null || product.isEmpty()) throw new ServletException("Unable to initialize");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUpData(req, ApplicationSettings.topic, ApplicationSettings.all);
        if (req.getRequestURI().endsWith("showlogin.do")) {
            var user = new User("Ivan Draganov");
            req.setAttribute("user", user);
        }
        var dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    private void setUpData(HttpServletRequest request, String type, String detail) {
        ApplicationSettings applicationSettings = (ApplicationSettings) getServletContext().getAttribute("app");
        var data = applicationSettings.setupData(type, detail);
        request.setAttribute("items", data);
    }

}
