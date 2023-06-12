package com.serenity.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecifications {

	static RequestSpecBuilder reqbuild;
	static RequestSpecification reqspec;
	
	static ResponseSpecBuilder respbuild;
	static ResponseSpecification respspec;
	
	public static RequestSpecification getReqestGenericSpecification() {
		
		reqbuild= new RequestSpecBuilder();
		reqbuild.setContentType(ContentType.JSON);
		reqspec=reqbuild.build();
		return reqspec;
	}
	
	public static ResponseSpecification getReponseGenericSpecification() {
		
		respbuild=new ResponseSpecBuilder();
		respbuild.expectHeader("Content-Type", "application/json; charset=utf-8");
		respspec=respbuild.build();
		
		return respspec;
	}
}
