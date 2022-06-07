package com.jakarta.play.filters;
/* demo
 * @created 06/06/2022
 * @author Konstantin Staykov
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class LoggingFilter implements Filter {

    static Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        var wrapper = new LogRequestWrapper(req,logger);
        logger.debug(String.format("Request made to %s", req.getRequestURI()));
        chain.doFilter(wrapper, response);
    }


}
