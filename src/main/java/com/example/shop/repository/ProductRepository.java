package com.example.shop.repository;

import com.example.shop.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, SearchProductRepository {
	
	List<Product> findByCategoryUrl(String url, Pageable pageable);

	int countByCategoryUrl(String url);
	
	Product findById(int idProduct);
}
