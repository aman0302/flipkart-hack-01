package com.flipkart.hackday17.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "question")
@JsonSerialize
public class QuestionDaoModel {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="question_text")
	private String questionText;
	@Column(name="answerid1")
	private String answerId1;
	@Column(name="answerid2")
	private String answerId2;
	@Column(name="answerid3")
	private String answerId3;
	@Column(name="answerid4")
	private String answerId4;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswerId1() {
		return answerId1;
	}
	public void setAnswerId1(String answerId1) {
		this.answerId1 = answerId1;
	}
	public String getAnswerId2() {
		return answerId2;
	}
	public void setAnswerId2(String answerId2) {
		this.answerId2 = answerId2;
	}
	public String getAnswerId3() {
		return answerId3;
	}
	public void setAnswerId3(String answerId3) {
		this.answerId3 = answerId3;
	}
	public String getAnswerId4() {
		return answerId4;
	}
	public void setAnswerId4(String answerId4) {
		this.answerId4 = answerId4;
	}
	
	
}
