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
import java.util.Locale;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // To get the parameter name: http://localhost:8080/kon/params?name=bob
        String name = req.getParameter("name");// bob

        // Determine language to use
        Locale locale = req.getLocale();
        String languageTag = locale.toLanguageTag().substring(0, 2);

        String greeting;
        // using enhanced switch statement
        switch (languageTag) {
            case "fr" -> greeting = "Bonjour";
            case "de" -> greeting = "Guten Tag";
            default -> {
                greeting = "hello";
                languageTag = "en";
            }
        }
        resp.setHeader("Content-Language",languageTag);
        resp.getWriter().println(greeting + " " + name);// hello bob
    }
}
