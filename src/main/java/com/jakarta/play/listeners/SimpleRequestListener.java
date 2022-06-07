package com.jakarta.play.listeners;
/* demo
 * @created 06/06/2022
 * @author Konstantin Staykov
 */

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application called from %s",sre.getServletRequest().getRemoteAddr()));
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application call ended from %s",sre.getServletRequest().getRemoteAddr()));
    }

}
