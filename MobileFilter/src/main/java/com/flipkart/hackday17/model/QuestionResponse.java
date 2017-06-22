package com.flipkart.hackday17.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class QuestionResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String questionText;
	private String answerText1;
	private String answerId1;
	private String answerText2;
	private String answerId2;
	private String answerText3;
	private String answerId3;
	private String answerText4;
	private String answerId4;
	
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswerText1() {
		return answerText1;
	}
	public void setAnswerText1(String answerText1) {
		this.answerText1 = answerText1;
	}
	public String getAnswerId1() {
		return answerId1;
	}
	public void setAnswerId1(String answerId1) {
		this.answerId1 = answerId1;
	}
	public String getAnswerText2() {
		return answerText2;
	}
	public void setAnswerText2(String answerText2) {
		this.answerText2 = answerText2;
	}
	public String getAnswerId2() {
		return answerId2;
	}
	public void setAnswerId2(String answerId2) {
		this.answerId2 = answerId2;
	}
	public String getAnswerText3() {
		return answerText3;
	}
	public void setAnswerText3(String answerText3) {
		this.answerText3 = answerText3;
	}
	public String getAnswerId3() {
		return answerId3;
	}
	public void setAnswerId3(String answerId3) {
		this.answerId3 = answerId3;
	}
	public String getAnswerText4() {
		return answerText4;
	}
	public void setAnswerText4(String answerText4) {
		this.answerText4 = answerText4;
	}
	public String getAnswerId4() {
		return answerId4;
	}
	public void setAnswerId4(String answerId4) {
		this.answerId4 = answerId4;
	}
	
	
	
}
