package com.example.shop.servlet.page;

import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/my-orders")
public class MyOrdersController extends AbstractController {
	private static final long serialVersionUID = -1782066337808445826L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("my-orders.jsp", req, resp);
	}
}
