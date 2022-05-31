package com.example.demo;
/* demo
 * @created 05/29/2022
 * @author Konstantin Staykov
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/session_count")
public class Servlet_Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get reference to the servlet context
        HttpSession session = req.getSession();

        // initialize count variable to 1
        int tempCount = 1;

        // Get or create counter attribute
        Object att = session.getAttribute("counter");

        if (att != null) {
            AtomicInteger count = (AtomicInteger) att;
            tempCount = count.incrementAndGet();
        } else {
            AtomicInteger count = new AtomicInteger(1);
            session.setAttribute("counter", count);
        }

        // report the current count
        resp.getWriter().println("Session count = " + tempCount);


    }
}
