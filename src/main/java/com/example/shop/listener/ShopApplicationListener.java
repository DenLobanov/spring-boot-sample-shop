package com.example.shop.listener;

import com.example.shop.Constants;
import com.example.shop.service.ProductService;
import com.example.shop.util.SpringUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ShopApplicationListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ProductService productService = SpringUtils.getInstance(sce.getServletContext(), ProductService.class);
			sce.getServletContext().setAttribute(Constants.CATEGORY_LIST, productService.listAllCategories());
			sce.getServletContext().setAttribute(Constants.PRODUCER_LIST, productService.listAllProducers());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Web application 'shop' destroyed");
	}
}
