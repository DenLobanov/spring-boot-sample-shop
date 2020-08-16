package com.example.shop.servlet.page;

import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInController extends AbstractController {

	private static final long serialVersionUID = 3229349271283872673L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/my-orders", req, resp);
		} else {
			RoutingUtils.forwardToPage("sign-in.jsp", req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/my-orders", req, resp);
		} else {
			RoutingUtils.redirect(getSocialService().getAuthorizeUrl(), req, resp);
		}
	}
}
