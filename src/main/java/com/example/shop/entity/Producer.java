package com.example.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "producer")
public class Producer extends AbstractEntity<Integer> {

	private static final long serialVersionUID = 5548766603532018905L;
	@Id
	private Integer id;
	private String name;
	@Column(name = "product_count")
	private Integer productCount;

	public Producer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
}
