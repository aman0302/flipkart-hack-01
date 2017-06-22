package com.flipkart.hackday17.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="answer_Score")
@JsonSerialize
public class AnswerScoreDaoModel {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="answer_text")
	private String answerText;
	@Column(name="answer_value")
	private BigDecimal answerValue;
	@Column(name="score")
	private String score;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public BigDecimal getAnswerValue() {
		return answerValue;
	}
	public void setAnswerValue(BigDecimal answerValue) {
		this.answerValue = answerValue;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
