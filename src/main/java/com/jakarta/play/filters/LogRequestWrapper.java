package com.jakarta.play.filters;
/* demo
 * @created 06/06/2022
 * @author Konstantin Staykov
 */

import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LogRequestWrapper extends HttpServletRequestWrapper {
    private Logger logger;
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public LogRequestWrapper(HttpServletRequest request, Logger logger) {
        super(request);
        this.logger = logger;
    }

    @Override
    public String getHeader(String name) {
        String header =  super.getHeader(name);
        logger.info("[getHeader] asked for: "+name+"; got "+ header);
        return header;
    }
}
