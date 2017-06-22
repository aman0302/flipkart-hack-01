package com.flipkart.hackday17.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="product")
@JsonSerialize
public class ProductDaoModel implements Comparable<ProductDaoModel> {


	@Id
	@Column(name="product_id")
	private String productId;
	@Column(name="name")
	private String name;
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="ram")
	private BigDecimal ram;
	@Transient
	private BigDecimal score;
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
	public BigDecimal getRam() {
		return ram;
	}
	public void setRam(BigDecimal ram) {
		this.ram = ram;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public int compareTo(ProductDaoModel o) {
		if((this.score).compareTo(o.getScore())<0)
			return 1;
		if((this.score).compareTo(o.getScore())==0)
			return 0;
		return -1;
	}
	
	
}
