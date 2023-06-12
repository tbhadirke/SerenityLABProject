package com.serenity.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.serenity.cucumber.steps.ReusableSteps;
import com.serenity.framework.SerenityTest.GetProductPOJO;
import com.serenity.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import java.util.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD_Test extends TestBase {

	static int product_id;
	static String title="test product";
	static double price=13.5;
	static String description= "lorem ipsum set";
	static String image= "https://i.pravatar.cc";
	static String category= "electronic";
	
	@Steps
	ReusableSteps step;

	@Title("This is to create a product")
	@Test
	public void test001() {

//		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
//
//		values.put("title", "test product");
//		values.put("price", 13.5);
//		values.put("description", "lorem ipsum set");
//		values.put("image", "https://i.pravatar.cc");
//		values.put("category", "electronic");

		Map<String, Object> response = step.createProduct(title, price, description, image, category);

		System.out.println(response);
		product_id = 20;
	}

	@Title("This is to get a product")
	@Test
	public void test002() {
		
		GetProductPOJO response = step.getProduct(product_id);

		System.out.println("Title:-" + response.getTitle()+" Rating: "+response.getRating().getRate());

	}

	@Title("This is to update a product")
	@Test
	public void test003() {

		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();

		values.put("title", "test product");
		values.put("price", 100.5);
		values.put("description", "lorem ipsum set");
		values.put("image", "https://i.pravatar.cc");
		values.put("category", "Beauty");

		SerenityRest.rest().given().log().all().when().body(values).put("/" + product_id).then().log().all();
		
		Map<String, Object> response = SerenityRest.rest().given().when().get("/" + product_id).then().log().all()
				.extract().as(Map.class);
		System.out
				.println("New Price is: " + response.get("price") + " and new category is:" + response.get("category"));

	}

	@Title("This is to delete a product")
	@Test
	public void test004() {

		Map<String, Object> response = SerenityRest.rest().given().when().delete("/" + product_id).then().log().all()
				.log().all().extract().as(Map.class);

		System.out.println("after deleting: " + response);

		System.out.println("Verify product exists or not");

		SerenityRest.rest().given().when().get("/" + product_id).then().log().all().statusCode(200);

	}

}
