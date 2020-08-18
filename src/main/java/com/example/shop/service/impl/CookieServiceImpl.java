package com.example.shop.service.impl;


import com.example.shop.form.ProductForm;
import com.example.shop.model.ShoppingCartItem;
import com.example.shop.service.CookieService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class CookieServiceImpl implements CookieService {
	@Override
	public String createShoppingCartCookie(Collection<ShoppingCartItem> items) {
		StringBuilder res = new StringBuilder();
		for (ShoppingCartItem item : items) {
			res.append(item.getProduct().getId()).append("-").append(item.getCount()).append("|");
		}
		if (res.length() > 0) {
			res.deleteCharAt(res.length() - 1);
		}
		return res.toString();
	}
	@Override
	public List<ProductForm> parseShoppingCartCookie(String cookieValue) {
		List<ProductForm> products = new ArrayList<ProductForm>();
		String[] items = cookieValue.split("\\|");
		for (String item : items) {
			try {
				String data[] = item.split("-");
				int idProduct = Integer.parseInt(data[0]);
				int count = Integer.parseInt(data[1]);
				products.add(new ProductForm(idProduct, count));
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
}
