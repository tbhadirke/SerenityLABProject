package com.serenity.framework.SerenityTest;

import java.util.LinkedHashMap;
import java.util.Map;

import com.serenity.utility.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import com.serenity.utility.*;

public class ReusableSteps {
	
	@Step("This is to create product with Title:{0} and price:{1}")
	public Map<String, Object> createProduct(String title,double price,String description,String image,String category){
		CreateProductsPOJO body= new CreateProductsPOJO();
		
		body.setTitle(title);
		body.setPrice(price);
		body.setDescription(description);
		body.setImage(image);
		body.setCategory(category);
		
		return SerenityRest.rest().given()
				.log().all()
				.spec(ReusableSpecifications.getReqestGenericSpecification())
				.when().body(body).post().then().log()
				.all().extract().as(Map.class);
	}
	
	@Step("This is to get product with productId:{0}")
	public GetProductPOJO getProduct(int productId){
		return SerenityRest.rest().given().log().all().when().get("/"+productId+"").then()
				.spec(ReusableSpecifications.getReponseGenericSpecification())
				.log().all()
		.extract().as(GetProductPOJO.class);
	}
	
	@Step("This is to GET Country Data")
	public ValidatableResponse getCountriesData(String country) {
		
		return SerenityRest.rest().given().relaxedHTTPSValidation().log().all()
				.get("/"+country).then().log().all().spec(ReusableSpecifications.getReponseGenericSpecification());
	}
	
	@Step("This is to create new user")
	public ValidatableResponse createUser(String firstname, String salary, String age) {
		
		LinkedHashMap<String,Object> body= new LinkedHashMap<String,Object>();
		body.put("name",firstname);
		body.put("salary",salary);
		body.put("age",age);
		
		return SerenityRest.rest().given().log().all().when().body(body).post().then().log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
