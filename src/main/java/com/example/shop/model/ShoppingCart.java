package com.example.shop.model;


import com.example.shop.Constants;
import com.example.shop.entity.Product;
import com.example.shop.exception.ValidationException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = -1067769252195567454L;
	private Map<Integer, ShoppingCartItem> products = new LinkedHashMap<>();
	private int totalCount = 0;
	private BigDecimal totalCost = BigDecimal.ZERO;

	public void addProduct(Optional<Product> product, int count) {
		validateShoppingCartSize(product.getId());
		ShoppingCartItem shoppingCartItem = products.get(product.getId());
		if (shoppingCartItem == null) {
			validateProductCount(count);
			shoppingCartItem = new ShoppingCartItem(product, count);
			products.put(product.getId(), shoppingCartItem);
		} else {
			validateProductCount(count + shoppingCartItem.getCount());
			shoppingCartItem.setCount(shoppingCartItem.getCount() + count);
		}
		refreshStatistics();
	}

	public void removeProduct(Integer idProduct, int count) {
		ShoppingCartItem shoppingCartItem = products.get(idProduct);
		if (shoppingCartItem != null) {
			if (shoppingCartItem.getCount() > count) {
				shoppingCartItem.setCount(shoppingCartItem.getCount() - count);
			} else {
				products.remove(idProduct);
			}
			refreshStatistics();
		}
	}

	public Collection<ShoppingCartItem> getItems() {
		return products.values();
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	private void validateProductCount(int count) {
		if(count > Constants.MAX_PRODUCT_COUNT_PER_SHOPPING_CART){
			throw new ValidationException("Limit for product count reached: count="+count);
		}
	}
	
	private void validateShoppingCartSize(int idProduct){
		if(products.size() > Constants.MAX_PRODUCTS_PER_SHOPPING_CART || 
				(products.size() == Constants.MAX_PRODUCTS_PER_SHOPPING_CART && !products.containsKey(idProduct))) {
			throw new ValidationException("Limit for ShoppingCart size reached: size="+products.size());
		}
	}

	private void refreshStatistics() {
		totalCount = 0;
		totalCost = BigDecimal.ZERO;
		for (ShoppingCartItem shoppingCartItem : getItems()) {
			totalCount += shoppingCartItem.getCount();
			totalCost = totalCost.add(shoppingCartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(shoppingCartItem.getCount())));
		}
	}

	@Override
	public String toString() {
		return String.format("ShoppingCart [products=%s, totalCount=%s, totalCost=%s]", products, totalCount, totalCost);
	}
}
