package com.example.shop.servlet.page;


import com.example.shop.Constants;
import com.example.shop.entity.Order;
import com.example.shop.model.CurrentAccount;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/my-orders")
public class MyOrdersController extends AbstractController {

	private static final long serialVersionUID = 2282499575617571376L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CurrentAccount currentAccount = SessionUtils.getCurrentAccount(req);
		List<Order> orders = getOrderService().listMyOrders(currentAccount, 1, Constants.ORDERS_PER_PAGE);
		req.setAttribute("orders", orders);
		int orderCount = getOrderService().countMyOrders(currentAccount);
		req.setAttribute("pageCount", getPageCount(orderCount, Constants.ORDERS_PER_PAGE));
		RoutingUtils.forwardToPage("my-orders.jsp", req, resp);
	}
}
