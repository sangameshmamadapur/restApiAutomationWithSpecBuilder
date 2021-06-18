package Restapi1.automation1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class Petstore {
	public static void main(String[] args) {

		order or = new order();
		or.setId(1);
		or.setPetId(2);
		or.setQuantity(2);
		or.setShipDate("2021-06-16T14:49:04.897Z");
		or.setStatus("Placed");
		or.setComplete(true);

//		RestAssured.baseURI = "https://petstore.swagger.io/v2";
//
//		String resp = given().log().all().contentType("application/json").body(or).when().post("store/order").then()
//				.log().all().assertThat().statusCode(200).extract().response().asString();
//
//		System.out.println("response" + resp);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").setContentType(ContentType.JSON).build();
        ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        String Response=given().log().all().spec(req).body(or).when().post("store/order").then().spec(res)
				.log().all().extract().response().asString();
    	System.out.println("Response" + Response);
        
	}
}
