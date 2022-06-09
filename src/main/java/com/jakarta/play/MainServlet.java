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
            req.setAttribute("action", "login");
        }
        if (req.getRequestURI().endsWith("logout.do")) {
            var session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
        var dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("login.do")) {
            var userName = req.getParameter("username");
            var password = req.getParameter("password");

            if (userName.isEmpty() || !userName.equals(password)) {
                resp.sendRedirect(resp.encodeURL("showlogin.do"));
            } else {
                var user = new User(userName);
                var session = req.getSession(true);
                session.setAttribute("user", user);

                resp.sendRedirect(resp.encodeURL("home"));
            }
        }

    }

    private void setUpData(HttpServletRequest request, String type, String detail) {
        ApplicationSettings applicationSettings = (ApplicationSettings) getServletContext().getAttribute("app");
        var data = applicationSettings.setupData(type, detail);
        request.setAttribute("items", data);
    }

}
