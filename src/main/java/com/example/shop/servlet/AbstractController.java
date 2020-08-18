package com.example.shop.servlet;

import com.example.shop.form.ProductForm;
import com.example.shop.form.SearchForm;
import com.example.shop.service.OrderService;
import com.example.shop.service.ProductService;
import com.example.shop.service.SocialService;
import com.example.shop.util.SpringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 4306004119028562691L;
	private ProductService productService;
	private OrderService orderService;
	private SocialService socialService;

	@Override
	public final void init() throws ServletException {
		productService = SpringUtils.getInstance(getServletContext(), ProductService.class);
		orderService =  SpringUtils.getInstance(getServletContext(), OrderService.class);
		socialService = SpringUtils.getInstance(getServletContext(), SocialService.class);
	}

	public final ProductService getProductService() {
		return productService;
	}

	public final OrderService getOrderService() {
		return orderService;
	}
	
	public final SocialService getSocialService() {
		return socialService;
	}
	
	public final int getPageCount(int totalCount, int itemsPerPage) {
		int res = totalCount / itemsPerPage;
		if(res * itemsPerPage != totalCount) {
			res++;
		}
		return res;
	}
	
	public final int getPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			return 1;
		}
	}
	
	public final SearchForm createSearchForm(HttpServletRequest request) {
		return new SearchForm(
				request.getParameter("query"), 
				request.getParameterValues("category"), 
				request.getParameterValues("producer"));
	}
	
	public final ProductForm createProductForm(HttpServletRequest request) {
		return new ProductForm(
				Integer.parseInt(request.getParameter("idProduct")),
				Integer.parseInt(request.getParameter("count")));
	}
}
