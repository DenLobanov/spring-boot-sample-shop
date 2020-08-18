package com.example.shop.util;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


public class SpringUtils {

	public static <T> T getInstance(ServletContext servletContext, Class<T> instanceClass) {
		WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		return context.getBean(instanceClass);
	}
}
