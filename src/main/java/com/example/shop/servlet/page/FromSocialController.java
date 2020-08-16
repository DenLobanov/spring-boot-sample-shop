package com.example.shop.servlet.page;



import com.example.shop.model.CurrentAccount;
import com.example.shop.model.SocialAccount;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/from-social")
public class FromSocialController extends AbstractController {

	private static final long serialVersionUID = 4671680632233405073L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		if (code != null) {
			SocialAccount socialAccount = getSocialService().getSocialAccount(code);
			CurrentAccount currentAccount = getOrderService().authentificate(socialAccount);
			SessionUtils.setCurrentAccount(req, currentAccount);
			RoutingUtils.redirect("/my-orders", req, resp);
		} else {
			RoutingUtils.redirect("/sign-in", req, resp);
		}
	}
}
