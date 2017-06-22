package com.flipkart.hackday17.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flipkart.hackday17.dao.impl.ProductDaoImpl;
import com.flipkart.hackday17.model.Product;

public class ProductServiceImpl {

	ProductDaoImpl productDaoImpl;
	
	
	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}
	
	@Transactional
	public void addProduct(String id){
		Product product=new  Product();
		product.setId(id);
		productDaoImpl.addProduct(product);
		
	}
}
