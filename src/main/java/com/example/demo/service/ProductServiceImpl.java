//package com.example.demo.service;
//
//import com.example.demo.model.Product;
//import com.example.demo.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.sql.Timestamp;
//import java.util.Optional;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    private ProductRepository productRepository;
//
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public Product fetchProductById(int id) {
//        Optional<Product> product = productRepository.findById(id);
//        return product.orElse(null);
//    }
//
//    @Override
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Page<Product> fetchProductsPaginated(int page, int size) {
//        return productRepository.findAll(PageRequest.of(page, size));
//    }
//
//    @Override
//    public Page<Product> fetchProductsByNamePaginated(String name, int page, int size) {
//        return productRepository.findAllByName(name, PageRequest.of(page, size));
//    }
//
//    @Override
//    public Page<Product> fetchProductsByCreatedAtBetweenPaginated(Timestamp from, Timestamp to, int page, int size) {
//        return productRepository.findAllByCreatedAtBetween(from, to, PageRequest.of(page, size));
//    }
//}
