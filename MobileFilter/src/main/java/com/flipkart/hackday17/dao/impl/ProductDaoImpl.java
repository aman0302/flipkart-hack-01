package com.flipkart.hackday17.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.flipkart.hackday17.model.ProductDaoModel;
import com.flipkart.hackday17.model.ProductResponse;

public class ProductDaoImpl {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addProduct(ProductResponse product) {
		sessionFactory.getCurrentSession().persist(product);
	}

	public List<ProductDaoModel> getAllProducts() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ProductDaoModel.class);
		return criteria.list();
	}

	
}
