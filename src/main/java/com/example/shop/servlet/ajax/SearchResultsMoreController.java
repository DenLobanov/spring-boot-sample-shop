package com.example.shop.servlet.ajax;

import com.example.shop.Constants;
import com.example.shop.entity.Product;
import com.example.shop.form.SearchForm;
import com.example.shop.servlet.AbstractController;
import com.example.shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/html/more/search")
public class SearchResultsMoreController extends AbstractController {

	private static final long serialVersionUID = -8204826359649771067L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SearchForm searchForm = createSearchForm(req);
		List<Product> products = getProductService().listProductsBySearchForm(searchForm, getPage(req), Constants.MAX_PRODUCTS_PER_HTML_PAGE);
		req.setAttribute("products", products);
		RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
	}
}
