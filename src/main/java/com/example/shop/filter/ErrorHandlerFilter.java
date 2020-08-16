package com.example.shop.filter;

import com.example.shop.util.RoutingUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="ErrorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(req, resp);
        } catch (Throwable th) {
            String requestUrl = req.getRequestURI();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            RoutingUtils.forwardToPage("error.jsp", req, resp);
        }
    }
}
