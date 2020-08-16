package com.example.shop.service.impl;

import com.example.shop.entity.Account;
import com.example.shop.entity.Product;
import com.example.shop.exception.InternalServerErrorException;
import com.example.shop.form.ProductForm;
import com.example.shop.jdbc.JDBCUtils;
import com.example.shop.jdbc.ResultSetHandler;
import com.example.shop.jdbc.ResultSetHandlerFactory;
import com.example.shop.model.CurrentAccount;
import com.example.shop.model.ShoppingCart;
import com.example.shop.model.ShoppingCartItem;
import com.example.shop.model.SocialAccount;
import com.example.shop.service.OrderService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

class OrderServiceImpl implements OrderService {

    private static final ResultSetHandler<Product> productResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
    private static final ResultSetHandler<Account> accountResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.ACCOUNT_RESULT_SET_HANDLER);

    private final DataSource dataSource;

    public OrderServiceImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public String serializeShoppingCart(ShoppingCart shoppingCart) {
        StringBuilder res = new StringBuilder();
        for (ShoppingCartItem item : shoppingCart.getItems()) {
            res.append(item.getProduct().getId()).append("-").append(item.getCount()).append("|");
        }
        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    @Override
    public ShoppingCart deserializeShoppingCart(String string) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = string.split("\\|");
        for (String item : items) {
            try {
                String data[] = item.split("-");
                int idProduct = Integer.parseInt(data[0]);
                int count = Integer.parseInt(data[1]);
                addProductToShoppingCart(new ProductForm(idProduct, count), shoppingCart);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return shoppingCart.getItems().isEmpty() ? null : shoppingCart;
    }

    @Override
    public CurrentAccount authentificate(SocialAccount socialAccount) {
        try (Connection c = dataSource.getConnection()) {
            Account account = JDBCUtils.select(c, "select * from account where email=?", accountResultSetHandler, socialAccount.getEmail());
            if (account == null) {
                account = new Account(socialAccount.getName(), socialAccount.getEmail());
                account = JDBCUtils.insert(c, "insert into account values (nextval('account_seq'),?,?)", accountResultSetHandler, account.getName(), account.getEmail());
                c.commit();
            }
            return account;
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart) {
        try (Connection c = dataSource.getConnection()) {
            Product product = JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer and p.id=?", productResultSetHandler, productForm.getIdProduct());
            if(product == null) {
                throw new InternalServerErrorException("Продукт не неайден=" + productForm.getIdProduct());
            }
            shoppingCart.addProduct(product, productForm.getCount());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Запрос не был отправлен: " + e.getMessage(), e);
        }
    }

    @Override
    public void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart) {
        shoppingCart.removeProduct(form.getIdProduct(), form.getCount());
    }
}
