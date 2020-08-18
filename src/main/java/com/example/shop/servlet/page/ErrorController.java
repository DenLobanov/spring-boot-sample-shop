package com.example.shop.servlet.page;



import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/error")
public class ErrorController extends AbstractController {

	private static final long serialVersionUID = 662978508067097953L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("statusCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		RoutingUtils.forwardToPage("error.jsp", req, resp);
	}
}
