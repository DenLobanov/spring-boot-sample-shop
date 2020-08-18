package com.example.shop.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -7888094538670939829L;
	@Id
	private Integer id;
	private String name;
	private String description;
	@Column(name = "image_link")
	private String imageLink;
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producer", nullable = false)
	private Producer producer;

	public Product() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category.getName();
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProducer() {
		return producer.getName();
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, description=%s, imageLink=%s, price=%s, category=%s, producer=%s]", getId(), name, description, imageLink, price, category, producer);
	}
}
