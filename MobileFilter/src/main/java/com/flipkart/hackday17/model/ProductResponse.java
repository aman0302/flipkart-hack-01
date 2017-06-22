package com.flipkart.hackday17.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize()
public class ProductResponse {
	private String productId;
	private String name;
	private String imageUrl;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
