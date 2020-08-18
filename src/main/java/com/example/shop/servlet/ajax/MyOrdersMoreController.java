package com.example.shop.servlet.ajax;


import com.example.shop.Constants;
import com.example.shop.entity.Order;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/ajax/html/more/my-orders")
public class MyOrdersMoreController extends AbstractController {

	private static final long serialVersionUID = -1025522978096365004L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> orders = getOrderService().listMyOrders(SessionUtils.getCurrentAccount(req), getPage(req), Constants.ORDERS_PER_PAGE);
		req.setAttribute("orders", orders);
		RoutingUtils.forwardToFragment("my-orders-tbody.jsp", req, resp);
	}
}
