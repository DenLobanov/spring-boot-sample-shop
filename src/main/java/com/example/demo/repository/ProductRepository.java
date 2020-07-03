package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.sql.Timestamp;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByName(String name, Pageable pageable);

    Page<Product> findAllByCreatedAtBetween(Timestamp from, Timestamp to, Pageable pageable);
}
