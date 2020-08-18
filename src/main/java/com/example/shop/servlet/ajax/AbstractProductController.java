package com.example.shop.servlet.ajax;


import com.example.shop.form.ProductForm;
import com.example.shop.model.ShoppingCart;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;
import com.example.shop.util.SessionUtils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class AbstractProductController extends AbstractController {

	private static final long serialVersionUID = -78844865518384763L;

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductForm form = createProductForm(req);
		ShoppingCart shoppingCart = getCurrentShoppingCart(req);
		processProductForm(form, shoppingCart, req, resp);
		if(!SessionUtils.isCurrentShoppingCartCreated(req)) {
			SessionUtils.setCurrentShoppingCart(req, shoppingCart);
		}
		sendResponse(shoppingCart, req, resp);
	}
	
	private ShoppingCart getCurrentShoppingCart(HttpServletRequest req) {
		ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req);
		if(shoppingCart == null) {
			shoppingCart = new ShoppingCart();
		}
		return shoppingCart;
	}

	protected abstract void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException;

	protected void sendResponse(ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JSONObject cardStatistics = new JSONObject();
		cardStatistics.put("totalCount", shoppingCart.getTotalCount());
		cardStatistics.put("totalCost", shoppingCart.getTotalCost());
		RoutingUtils.sendJSON(cardStatistics, req, resp);
	}
}
