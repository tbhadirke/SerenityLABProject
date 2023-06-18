package com.serenity.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/create";
	}

}
