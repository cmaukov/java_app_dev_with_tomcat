package com.example.demo;
/* demo
 * @created 05/30/2022
 * @author Konstantin Staykov
 */

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filter_1 extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        out.println("Filter-1B");
        chain.doFilter(req, res); //call next resource
        out.println("Filter-1A");

    }
}
