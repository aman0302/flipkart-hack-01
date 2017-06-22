package com.flipkart.hackday17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flipkart.hackday17.model.Product;
import com.flipkart.hackday17.service.impl.ProductServiceImpl;

@Controller
public class ProductController {

	ProductServiceImpl productService;

	@Autowired
	public void setProductService(ProductServiceImpl productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET,produces = "application/json", headers="Accept=*/*")
	public @ResponseBody Product getProduct() {
		System.out.println("i am hre");
		Product s = new Product();
		productService.addProduct("1");
		s.setId("Sd");
		return s;

	}
}
