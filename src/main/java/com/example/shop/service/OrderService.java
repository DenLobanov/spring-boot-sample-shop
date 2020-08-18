package com.example.shop.service;

import com.example.shop.entity.Order;
import com.example.shop.form.ProductForm;
import com.example.shop.model.CurrentAccount;
import com.example.shop.model.ShoppingCart;
import com.example.shop.model.SocialAccount;

import java.util.List;


public interface OrderService {

	void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);

	void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);

	String serializeShoppingCart(ShoppingCart shoppingCart);

	ShoppingCart deserializeShoppingCart(String string);

	CurrentAccount authentificate(SocialAccount socialAccount);

	long makeOrder(ShoppingCart shoppingCart, CurrentAccount currentAccount);

	Order findOrderById(long id, CurrentAccount currentAccount);

	List<Order> listMyOrders(CurrentAccount currentAccount, int page, int limit);

	int countMyOrders(CurrentAccount currentAccount);
}
