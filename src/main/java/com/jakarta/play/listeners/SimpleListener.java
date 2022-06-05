package com.jakarta.play.listeners;
/* demo
 * @created 06/04/2022
 * @author Konstantin Staykov
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SimpleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Application Started");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("Application Now Ended");

    }
}
