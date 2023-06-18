package com.serenity.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hamcrest.*;
import com.serenity.framework.SerenityTest.ReusableSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class SerenityCucumberSteps {

	@Steps
	ReusableSteps step;

	@When("user use GET method to API endpoint to search details of {string} they receives valid response")
	public void user_use_get_method_to_api_endpoint_to_search_details_of_they_receives_valid_response(String string) {
		ValidatableResponse response = step.getCountriesData(string);

		ArrayList<LinkedHashMap<String, Object>> resp = response.extract().as(ArrayList.class);

		LinkedHashMap<String, Object> out = resp.get(0);

		LinkedHashMap<String, Object> out1 = (LinkedHashMap<String, Object>) out.get("name");

		if (out1.containsValue("Republic of India")) {
			System.out.println("Republic of India is present in response");
			System.out.println("Response of API :=" + resp);
		}

	}

	@When("user use GET method to to search {string} country details they received {int} error")
	public void user_use_get_method_to_to_search_country_details_they_received_error(String string, Integer int1) {
		ValidatableResponse response = step.getCountriesData(string);

		response.assertThat().statusCode(int1);
	}

	@When("user use GET method to search {string} country deatils they able to see capital in response")
	public void user_use_get_method_to_search_country_deatils_they_able_to_see_capital_in_response(String string) {
		ValidatableResponse response = step.getCountriesData(string);

		ArrayList<LinkedHashMap<String, Object>> resp = response.extract().as(ArrayList.class);

		LinkedHashMap<String, Object> out = resp.get(0);
		
		if(out.containsKey("capital")) {
			System.out.println("Capital of "+string+" is: "+out.get("capital"));
		}else {
			System.out.println("Capital is not present");
		}
	}
	static ValidatableResponse response;
	@When("user register a user with details firstname {string}, salary {string}, age {string}")
	public void user_register_a_user_with_details_firstname_salary_age(String firstname, String salary, String age) {
	     response=step.createUser(firstname, salary, age);
	}

	@Then("receives satus code as {int}")
	public void receives_satus_code_as(Integer int1) {
	    response.assertThat().statusCode(int1);
	}

	@And("{string} is present in response body")
	public void is_present_in_response_body(String string) {
	    Map<String,Object> resp=response.extract().as(Map.class);
	    
	   if( resp.containsValue(string)) {
		   System.out.println(string+" is present");
	   }else {
		   System.out.println(string+" is not present");
	   }
	}
}
