package com.example.shop.servlet.ajax;

import com.example.shop.Constants;
import com.example.shop.entity.Product;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/html/more/products")
public class AllProductsMoreController extends AbstractController {

    private static final long serialVersionUID = 6423160486480308462L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = getProductService().listAllProducts(getPage(req), Constants.MAX_PRODUCTS_PER_HTML_PAGE);
        req.setAttribute("products", products);
        RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
    }
}