package com.flipkart.hackday17.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.flipkart.hackday17.model.AnswerScoreDaoModel;

public class AnswerScoreDaoImpl {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<AnswerScoreDaoModel> getAnswers(List<String> answerIds) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AnswerScoreDaoModel.class);
		Criterion crietrion1 = Restrictions.eq("id", answerIds.get(0));
		Criterion crietrion2 = Restrictions.eq("id", answerIds.get(1));
		Criterion crietrion3 = Restrictions.eq("id", answerIds.get(2));
		Criterion crietrion4 = Restrictions.eq("id", answerIds.get(3));
		criteria.add(Restrictions.or(crietrion1, crietrion2, crietrion3, crietrion4));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public AnswerScoreDaoModel getAnswers(String answerId) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(AnswerScoreDaoModel.class);
		criteria.add(Restrictions.eq("id",answerId));
		return (AnswerScoreDaoModel)criteria.uniqueResult();
	}

}
