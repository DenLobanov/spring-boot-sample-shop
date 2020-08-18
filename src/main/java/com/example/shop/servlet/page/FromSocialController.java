package com.example.shop.servlet.page;


import com.example.shop.Constants;
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
import java.net.URLDecoder;


@WebServlet("/from-social")
public class FromSocialController extends AbstractController {

	private static final long serialVersionUID = -1772851395128746364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		if (code != null) {
			SocialAccount socialAccount = getSocialService().getSocialAccount(code);
			CurrentAccount currentAccount = getOrderService().authentificate(socialAccount);
			SessionUtils.setCurrentAccount(req, currentAccount);
			redirectToSuccessPage(req, resp);
		} else {
			if(req.getSession().getAttribute(Constants.SUCCESS_REDIRECT_URL_AFTER_SIGNIN) != null){
				req.getSession().removeAttribute(Constants.SUCCESS_REDIRECT_URL_AFTER_SIGNIN);
			}
			RoutingUtils.redirect("/sign-in", req, resp);
		}
	}
	
	protected void redirectToSuccessPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String targetUrl = (String) req.getSession().getAttribute(Constants.SUCCESS_REDIRECT_URL_AFTER_SIGNIN);
		if (targetUrl != null) {
			req.getSession().removeAttribute(Constants.SUCCESS_REDIRECT_URL_AFTER_SIGNIN);
			RoutingUtils.redirect(URLDecoder.decode(targetUrl, "UTF-8"), req, resp);
		} else {
			RoutingUtils.redirect("/my-orders", req, resp);
		}
	}
}
