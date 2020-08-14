package com.example.shop.listener;

import com.example.shop.service.impl.ServiceManager;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ShopApplicationListener implements ServletContextListener {
    private ServiceManager serviceManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            serviceManager = ServiceManager.getInstance(sce.getServletContext());
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
    }
}
