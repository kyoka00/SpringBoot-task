package com.example.demo.entity;

public class Products {
	private Integer productId;
	private String productName;
	private Integer categoryId;
	private String categoryName;
	private Integer price;
	private String description;
	private String createdAt;
	private String updatedAt;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(Integer product_id) {
		this.productId = product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updated_at) {
		this.updatedAt = updated_at;
	}
	
	public Products() {
		
	}
	public Products(Integer productId, String productName, Integer categoryId, String categoryName, Integer price, String description) {
		setProductId(productId);
		setProductName(productName);
		setCategoryId(categoryId);
		setCategoryName(categoryName);
		setPrice(price);
		setDescription(description);
	}
	
}
