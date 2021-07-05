package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class StepDefinition {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;

@Given("Add placepayload")
public void add_placepayload() {
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";

	AddPlace p =new AddPlace();
	p.setAccuracy(50);
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("https://rahulshettyacademy.com");
	p.setName("Frontline house");
	List<String> myList =new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");

	p.setTypes(myList);
	Location l =new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);

	 RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	.setContentType(ContentType.JSON).build();	 
	 
	 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 res = given().spec(req).body(p);
	
}

@When("user calls {string} with post http request")
public void user_calls_with_post_http_request(String string) {
	
	response =res.when().post("/maps/api/place/add/json").
			then().spec(resspec).extract().response();
}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer statsuCode) {
  
		assertEquals(response.getStatusCode(),200);
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String expValue) {
	
	String resp = response.asString();
	JsonPath js = new JsonPath(resp);
	assertEquals(js.get(keyValue).toString(),expValue);
	
}


}
