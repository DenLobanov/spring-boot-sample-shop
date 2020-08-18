package com.example.shop.form;

public class ProductForm {
	private Integer idProduct;
	private Integer count;
	
	public ProductForm() {
		super();
	}
	public ProductForm(Integer idProduct, Integer count) {
		super();
		this.idProduct = idProduct;
		this.count = count;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("ProductForm [idProduct=%s, count=%s]", idProduct, count);
	}
}
