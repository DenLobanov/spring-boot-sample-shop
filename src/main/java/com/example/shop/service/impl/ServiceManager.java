package com.example.shop.service.impl;

import com.example.shop.service.OrderService;
import com.example.shop.service.ProductService;
import com.example.shop.service.SocialService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceManager {
    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (instance == null) {
            instance = new ServiceManager(context);
            context.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }
    public ProductService getProductService() {
        return productService;
    }
    public OrderService getOrderService() {
        return orderService;
    }
    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }
    public SocialService getSocialService() {
        return socialService;
    }
    public void close() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private final Properties applicationProperties = new Properties();
    private final BasicDataSource dataSource;
    private final ProductService productService;
    private final OrderService orderService;
    private final SocialService socialService;
    private ServiceManager(ServletContext context) {
        loadApplicationProperties();
        dataSource = createDataSource();
        productService = new ProductServiceImpl(dataSource);
        orderService = new OrderServiceImpl(dataSource);
        socialService = new FacebookSocialService(this);
    }

    private BasicDataSource createDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true);
        dataSource.setDriverClassName(getApplicationProperty("db.driver"));
        dataSource.setUrl(getApplicationProperty("db.url"));
        dataSource.setUsername(getApplicationProperty("db.username"));
        dataSource.setPassword(getApplicationProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
        return dataSource;
    }

    private void loadApplicationProperties(){
        try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            applicationProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
