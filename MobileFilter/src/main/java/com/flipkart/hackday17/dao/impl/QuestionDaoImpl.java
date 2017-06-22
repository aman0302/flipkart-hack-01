package com.flipkart.hackday17.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.flipkart.hackday17.model.QuestionDaoModel;
import com.flipkart.hackday17.model.QuestionResponse;

public class QuestionDaoImpl {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public QuestionDaoModel getQuestion(int index) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(QuestionResponse.class);
		criteria.add(Restrictions.eq("id", index));
		return (QuestionDaoModel) criteria.uniqueResult();
	}
}
