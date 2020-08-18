package com.example.shop.repository;


import com.example.shop.entity.Product;
import com.example.shop.form.SearchForm;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface SearchProductRepository {

	List<Product> listProductsBySearchForm(SearchForm searchForm, Pageable pageable);

	int countProductsBySearchForm(SearchForm searchForm);
}
