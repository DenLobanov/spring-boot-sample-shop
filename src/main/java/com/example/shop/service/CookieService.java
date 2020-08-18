package com.example.shop.service;


import com.example.shop.form.ProductForm;
import com.example.shop.model.ShoppingCartItem;

import java.util.Collection;
import java.util.List;


public interface CookieService {

	String createShoppingCartCookie(Collection<ShoppingCartItem> items);
	
	List<ProductForm> parseShoppingCartCookie(String cookieValue);
}
