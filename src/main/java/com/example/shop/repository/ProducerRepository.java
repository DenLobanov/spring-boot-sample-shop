package com.example.shop.repository;

import com.example.shop.entity.Producer;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface ProducerRepository extends Repository<Producer, Integer> {
	
	List<Producer> findAll(Sort sort);
}
