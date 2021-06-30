package at.restassured.learning;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {
	
	//given > all input details
	//when > Submit the API, http method
	//Then > Validate the response
	public static void main(String[] args) {
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body(PayLoad.addPlace())
	.when().post("maps/api/place/add/json")
	.then().statusCode(200).body("scope", equalTo("APP"))
	.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	JsonPath js = new JsonPath(response);
	String placeID = js.getString("place_id");
	
	System.out.println(placeID);
	
	//update the place
	
	String newAddress = "70 Summer walk, USA";
	given().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeID+"\",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "")
	.when().put("maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	//get the place
	
	String getplaceResponse = given().queryParam("key", "qaclick123")
																.queryParam("place_id",placeID)
	.when().get("maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	 
	 JsonPath jp = new JsonPath(getplaceResponse);
	 String actualAddress = jp.get("address");
	 
	 Assert.assertEquals(actualAddress, newAddress);
	 
	}
}
