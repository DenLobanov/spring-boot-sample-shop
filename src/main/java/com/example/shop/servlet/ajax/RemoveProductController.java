package com.example.shop.servlet.ajax;


import com.example.shop.form.ProductForm;
import com.example.shop.model.ShoppingCart;
import com.example.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/json/product/remove")
public class RemoveProductController extends AbstractProductController {
	private static final long serialVersionUID = -3046216247699203961L;

	@Override
	protected void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getOrderService().removeProductFromShoppingCart(form, shoppingCart);
		if (shoppingCart.getItems().isEmpty()) {
			SessionUtils.clearCurrentShoppingCart(req, resp);
		} else {
			String cookieValue = getOrderService().serializeShoppingCart(shoppingCart);
			SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);
		}
	}

}
