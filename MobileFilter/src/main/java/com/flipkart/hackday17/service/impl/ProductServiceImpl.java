package com.flipkart.hackday17.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

		List<ProductDaoModel> productDaoModels = productDaoImpl.getAllProducts();
		String answerIds[] = answers.split(":");
		for (int i = 0; i < answerIds.length; ++i) {
			processSingleAnswer(answerIds[i], productDaoModels);
		}
		// sort
		Collections.sort(productDaoModels);
		
		//get top 10
		List<ProductDaoModel> response=new ArrayList<ProductDaoModel>();
		int counter=0;
		for(ProductDaoModel daoModel:productDaoModels){
			if(counter==10)
				break;
			response.add(daoModel);
		}
		return response;
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
