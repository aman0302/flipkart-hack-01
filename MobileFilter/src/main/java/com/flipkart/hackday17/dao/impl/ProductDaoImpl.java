package com.flipkart.hackday17.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.flipkart.hackday17.model.Product;

public class ProductDaoImpl {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().persist(product);
	}
}
