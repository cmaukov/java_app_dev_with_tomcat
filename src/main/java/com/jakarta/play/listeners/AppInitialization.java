package com.jakarta.play.listeners;
/* demo
 * @created 06/04/2022
 * @author Konstantin Staykov
 */

import com.jakarta.play.blog.ApplicationSettings;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppInitialization implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var applicationSettings = new ApplicationSettings();
        sce.getServletContext().setAttribute("app", applicationSettings);
    }
}
