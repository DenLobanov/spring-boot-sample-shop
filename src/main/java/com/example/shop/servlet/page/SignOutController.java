package com.example.shop.servlet.page;


import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/sign-out")
public class SignOutController extends AbstractController {

	private static final long serialVersionUID = -6480718664885786844L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		RoutingUtils.redirect("/products", req, resp);
	}
}
