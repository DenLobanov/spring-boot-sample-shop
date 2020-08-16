package com.example.shop.listener;

import com.example.shop.Constants;
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
            sce.getServletContext().setAttribute(Constants.CATEGORY_LIST, serviceManager.getProductService().listAllCategories());
            sce.getServletContext().setAttribute(Constants.PRODUCER_LIST, serviceManager.getProductService().listAllProducers());
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
    }
}
