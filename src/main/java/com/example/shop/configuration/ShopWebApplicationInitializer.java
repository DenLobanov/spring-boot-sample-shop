package com.example.shop.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;


public class ShopWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(container);

		container.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		container.addListener(new ContextLoaderListener(ctx));
		container.addListener(new ShopApplicationListener());
	}

	private WebApplicationContext createWebApplicationContext(ServletContext container) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("com.example.shop.configuration");
		ctx.setServletContext(container);
		ctx.refresh();
		return ctx;
	}
}
