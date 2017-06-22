package com.flipkart.hackday17.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.flipkart.hackday17.dao.impl.AnswerScoreDaoImpl;
import com.flipkart.hackday17.dao.impl.QuestionDaoImpl;
import com.flipkart.hackday17.model.AnswerScoreDaoModel;
import com.flipkart.hackday17.model.QuestionDaoModel;
import com.flipkart.hackday17.model.QuestionResponse;

public class QuestionServiceImpl {
	 public QuestionDaoImpl questionDaoImpl;
	 
	 public AnswerScoreDaoImpl answerDaoImpl;

	public void setQuestionDaoImpl(QuestionDaoImpl questionDaoImpl) {
		this.questionDaoImpl = questionDaoImpl;
	}
	
	public void setAnswerDaoImpl(AnswerScoreDaoImpl answerDaoImpl) {
		this.answerDaoImpl = answerDaoImpl;
	}

	@Transactional
	public QuestionResponse getQuestion(int index) {
		QuestionDaoModel questionDaoModel=questionDaoImpl.getQuestion(index);
		List<String> answerIds=getAnswerIds(questionDaoModel);
		List<AnswerScoreDaoModel> answerScoreDao=answerDaoImpl.getAnswers(answerIds);
		return mapQuestionResponse(questionDaoModel,answerScoreDao	);
	}
	
	public List<String> getAnswerIds(QuestionDaoModel questionDaoModel){
		
		List<String> answerIds=new ArrayList<String>();
		answerIds.add(questionDaoModel.getAnswerId1());
		answerIds.add(questionDaoModel.getAnswerId2());
		answerIds.add(questionDaoModel.getAnswerId3());
		answerIds.add(questionDaoModel.getAnswerId4());
		return answerIds;
	}
	
	public QuestionResponse mapQuestionResponse(QuestionDaoModel questionDaoModel,List<AnswerScoreDaoModel> answerScoreDaoModel){
		QuestionResponse questionResponse=new QuestionResponse();
		questionResponse.setId(questionDaoModel.getId());
		questionResponse.setQuestionText(questionDaoModel.getQuestionText());
		
		questionResponse.setAnswerId1(answerScoreDaoModel.get(0).getId());
		questionResponse.setAnswerText1(answerScoreDaoModel.get(0).getAnswerText());
		

		questionResponse.setAnswerId2(answerScoreDaoModel.get(1).getId());
		questionResponse.setAnswerText2(answerScoreDaoModel.get(1).getAnswerText());
		

		questionResponse.setAnswerId3(answerScoreDaoModel.get(2).getId());
		questionResponse.setAnswerText3(answerScoreDaoModel.get(2).getAnswerText());
		

		questionResponse.setAnswerId4(answerScoreDaoModel.get(3).getId());
		questionResponse.setAnswerText4(answerScoreDaoModel.get(3).getAnswerText());
		return questionResponse;
		
	}

}
