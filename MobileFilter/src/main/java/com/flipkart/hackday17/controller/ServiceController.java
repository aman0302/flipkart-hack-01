package com.flipkart.hackday17.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.hackday17.model.ProductDaoModel;
import com.flipkart.hackday17.model.ProductResponse;
import com.flipkart.hackday17.model.QuestionResponse;
import com.flipkart.hackday17.service.impl.ProductServiceImpl;
import com.flipkart.hackday17.service.impl.QuestionServiceImpl;

@Controller
public class ServiceController {

	ProductServiceImpl productService;

	QuestionServiceImpl questionService;

	@Autowired
	public void setProductService(ProductServiceImpl productService) {
		this.productService = productService;
	}

	@Autowired
	public void setQuestionService(QuestionServiceImpl questionService) {
		this.questionService = questionService;
	}

	@RequestMapping(value = "/getQuestion", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getQuestion(@RequestParam("index") int index) {
		QuestionResponse question ;//= questionService.getQuestion(index);
		question = getDummyData();
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(question);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private QuestionResponse getDummyData() {
		// TODO Auto-generated method stub
		QuestionResponse question = new QuestionResponse();
		question.setAnswerId1("answerid1");
		question.setAnswerId2("answerId2");
		question.setAnswerId3("answerId3");
		question.setAnswerId4("answerId4");
		question.setAnswerText1("answerText1");
		question.setAnswerText2("answerText2");
		question.setAnswerText3("answerText3");
		question.setAnswerText4("answerText4");
		question.setId("id");
		question.setQuestionText("questionText");
		return question;
	}

	@RequestMapping(value = "/getProductLists", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	public @ResponseBody String getProducts(@RequestParam("answers") String answers) {
		List<ProductDaoModel> products = getProductDummyData();//productService.getProducts(answers);

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private List<ProductDaoModel> getProductDummyData() {
		List<ProductDaoModel> daoModels=new ArrayList<ProductDaoModel>();
		ProductDaoModel daoModel1=new ProductDaoModel();
		daoModel1.setImageUrl("https://rukminim1.flixcart.com/image/400/400/kurta/g/y/s/m-svbk1828-svanik-original-imaerwfaheb8nr8g.jpeg?q=70");
		daoModel1.setName("name");
		daoModel1.setProductId("productId");
		
		ProductDaoModel daoModel2=new ProductDaoModel();
		daoModel2.setImageUrl("imageUr");
		daoModel2.setName("name");
		daoModel2.setProductId("productId2");
		
		ProductDaoModel daoModel3=new ProductDaoModel();
		daoModel3.setImageUrl("imageUrl");
		daoModel3.setName("name");
		daoModel3.setProductId("productId3");


		ProductDaoModel daoModel4=new ProductDaoModel();
		daoModel4.setImageUrl("imageUrl");
		daoModel4.setName("name");
		daoModel4.setProductId("productId4");
		
		daoModels.add(daoModel4);

		daoModels.add(daoModel3);

		daoModels.add(daoModel2);

		daoModels.add(daoModel1);
		return daoModels;
	}
}
