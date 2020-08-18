package com.example.shop.filter;

import com.example.shop.exception.*;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.UrlUtils;
import org.json.JSONObject;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;


@WebFilter(filterName = "ErrorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {
	private static final String INTERNAL_ERROR = "Internal error";

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(req, new ThrowExceptionInsteadOfSendErrorResponse(resp));
		} catch (Throwable th) {
			String requestUrl = req.getRequestURI();

			handleException(requestUrl, th, req, resp);
		}
	}

	private int getStatusCode(Throwable th) {
		if (th instanceof AbstractApplicationException) {
			return (((AbstractApplicationException) th).getCode());
		} else {
			return (HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private void handleException(String requestUrl, Throwable th, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int statusCode = getStatusCode(th);
		resp.setStatus(statusCode);
		if (UrlUtils.isAjaxJsonUrl(requestUrl)) {
			JSONObject json = new JSONObject();
			json.put("message", th instanceof ValidationException ? th.getMessage() : INTERNAL_ERROR);
			RoutingUtils.sendJSON(json, req, resp);
		} else if (UrlUtils.isAjaxHtmlUrl(requestUrl)) {
			RoutingUtils.sendHTMLFragment(INTERNAL_ERROR, req, resp);
		} else {
			req.setAttribute("statusCode", statusCode);
			RoutingUtils.forwardToPage("error.jsp", req, resp);
		}
	}

	private static class ThrowExceptionInsteadOfSendErrorResponse extends HttpServletResponseWrapper {
		public ThrowExceptionInsteadOfSendErrorResponse(HttpServletResponse response) {
			super(response);
		}

		@Override
		public void sendError(int sc) throws IOException {
			sendError(sc, INTERNAL_ERROR);
		}

		@Override
		public void sendError(int sc, String msg) throws IOException {
			switch (sc) {
				case 403: {
					throw new AccessDeniedException(msg);
				}
				case 404: {
					throw new ResourceNotFoundException(msg);
				}
				case 400: {
					throw new ValidationException(msg);
				}
				default:
					throw new InternalServerErrorException(msg);
				}
		}
	}
}
