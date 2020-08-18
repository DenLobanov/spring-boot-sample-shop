package com.example.shop.service.impl;

import com.example.shop.entity.Category;
import com.example.shop.entity.Producer;
import com.example.shop.entity.Product;
import com.example.shop.form.SearchForm;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.repository.ProducerRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly=true)
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> listAllProducts(int page, int limit) {
		return productRepository.findAll(PageRequest.of(page - 1, limit)).getContent();
	}

	@Override
	public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
		return productRepository.findByCategoryUrl(categoryUrl, PageRequest.of(page - 1, limit));
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAll(Sort.by("id"));
	}

	@Override
	public List<Producer> listAllProducers() {
		return producerRepository.findAll(Sort.by("name"));
	}
	
	@Override
	public int countAllProducts() {
		return (int)productRepository.count();
	}
	
	@Override
	public int countProductsByCategory(String categoryUrl) {
		return productRepository.countByCategoryUrl(categoryUrl);
	}
	
	@Override
	public List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit) {
		return productRepository.listProductsBySearchForm(searchForm, PageRequest.of(page - 1, limit));
	}

	@Override
	public int countProductsBySearchForm(SearchForm searchForm) {
		return productRepository.countProductsBySearchForm(searchForm);
	}
}
