package com.example.shop.servlet.page;


import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/shopping-cart")
public class ShowShoppingCartController extends AbstractController {

	private static final long serialVersionUID = -8440344454783229298L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentShoppingCartCreated(req)) {
			RoutingUtils.forwardToPage("shopping-cart.jsp", req, resp);
		} else {
			RoutingUtils.redirect("/products", req, resp);
		}
	}
}
