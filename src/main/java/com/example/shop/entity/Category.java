package com.example.shop.entity;


public class Category extends AbstractEntity<Integer> {
	private static final long serialVersionUID = -7331864534223196661L;
	private String name;
	private String url;
	private Integer productCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return String.format("Category [id=%s, name=%s, url=%s, productCount=%s]", getId(), name, url, productCount);
	}
}
