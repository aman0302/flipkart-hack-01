package com.flipkart.hackday17.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.transaction.Transactional;

import com.flipkart.hackday17.dao.impl.AnswerScoreDaoImpl;
import com.flipkart.hackday17.dao.impl.ProductDaoImpl;
import com.flipkart.hackday17.model.AnswerScoreDaoModel;
import com.flipkart.hackday17.model.ProductDaoModel;
import com.flipkart.hackday17.model.ProductResponse;

public class ProductServiceImpl {

	public ProductDaoImpl productDaoImpl;

	public AnswerScoreDaoImpl answerDaoImpl;

	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	public void setAnswerDaoImpl(AnswerScoreDaoImpl answerDaoImpl) {
		this.answerDaoImpl = answerDaoImpl;
	}

	@Transactional
	public List<ProductDaoModel> getProducts(String answers) {

		List<ProductDaoModel> productDaoModel = productDaoImpl.getAllProducts();
		String answerIds[] = answers.split("|");
		for (int i = 0; i < answerIds.length; ++i) {
			processSingleAnswer(answerIds[i], productDaoModel);
		}
		// TODO compare to
		return productDaoModel;
	}

	public void processSingleAnswer(String answerId, List<ProductDaoModel> productDaoModel) {

		AnswerScoreDaoModel answerScoreDaoModel = answerDaoImpl.getAnswers(answerId);
		BigDecimal value = answerScoreDaoModel.getAnswerValue();
		String score = answerScoreDaoModel.getScore();
		String scores[] = score.split(",");

		for (ProductDaoModel daoModel : productDaoModel) {
			for (String attributeScore : scores) {
				String attScoreWeight[] = attributeScore.split(":");
				String colName = attScoreWeight[0];
				BigDecimal attWeight = new BigDecimal(attScoreWeight[1]);
				daoModel.setScore(daoModel.getScore().add(calculateScore(colName, attWeight, value, daoModel)));
			}
		}

	}

	private BigDecimal calculateScore(String colName, BigDecimal attWeight, BigDecimal attValue,
			ProductDaoModel daoModel) {
		BigDecimal val = new BigDecimal(0);
		if (colName.compareTo("ram") == 0) {
			val = daoModel.getRam();
		}
		return ((val.subtract(attValue)).abs()).multiply(attWeight);
	}

}
