package com.example.shop.filter;

import com.example.shop.Constants;
import com.example.shop.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName="SetCurrentRequestUrlFilter")
public class SetCurrentRequestUrlFilter extends AbstractFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setAttribute(Constants.CURRENT_REQUEST_URL, WebUtils.getCurrentRequestUrl(req));
		chain.doFilter(req, resp);
	}
}
