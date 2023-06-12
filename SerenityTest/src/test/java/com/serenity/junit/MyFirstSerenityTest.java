package com.serenity.junit;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.*;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
/**
 * @author Administrator
 *
 */
public class MyFirstSerenityTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://fakestoreapi.com/products";
	}
	
	@Test
	public void getData() {
		Map<String, Object> response = SerenityRest.rest().given().log().all().when().get("/20").then().log().all()
				.extract().as(Map.class);

		System.out.println("Product details:-" + response);
	}

}
