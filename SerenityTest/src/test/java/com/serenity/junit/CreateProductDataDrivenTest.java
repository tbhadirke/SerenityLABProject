package com.serenity.junit;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.serenity.cucumber.steps.ReusableSteps;
import com.serenity.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("testdata/productdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBase {
	
	@Steps
	ReusableSteps step;
	
	private String title;
	private double price;
	private String description;
	private String image;
	private String category;
	
	public ReusableSteps getStep() {
		return step;
	}


	public void setStep(ReusableSteps step) {
		this.step = step;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	
	
	@Title("This is to create product using data driven Test approach")
	@Test
	public void createProducts() {
		
		Map<String, Object> response =step.createProduct(title,price,description,image,category);
		System.out.println("Response="+response);
	}

}
