package com.example.shop.servlet.ajax;


import com.example.shop.form.ProductForm;
import com.example.shop.model.ShoppingCart;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ajax/json/product/add")
public class AddProductController extends AbstractProductController {

	@Override
	protected void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		getOrderService().addProductToShoppingCart(form, shoppingCart);
		String cookieValue = getOrderService().serializeShoppingCart(shoppingCart);
		SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);
	}
}
