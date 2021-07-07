package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utility;

public class StepDefination extends Utility {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	
	TestData testData = new TestData();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Exception{	 
	
	 res = given().spec(requestSpecification()).body(testData.addPlacePayLoad(name, language, address));	
}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String http) {
	
	APIResources resourceAPI = APIResources.valueOf(resource);	
	
	if(http.equalsIgnoreCase("POST"))
			response =res.when().post(resourceAPI.getResource());
	else if(http.equalsIgnoreCase("GET"))
			response =res.when().get(resourceAPI.getResource());	
}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(int statsuCode) {
  
		assertEquals(response.getStatusCode(),statsuCode);
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String expValue) {		
	
	assertEquals(getJsonPath(response,keyValue), expValue);	
}

@Then("verify place ID created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expName, String resource) throws Exception {
    
	String placeID = getJsonPath(response, "place_id");
	 res = given().spec(requestSpecification()).queryParam("place_id", placeID);
	 user_calls_with_http_request(resource,"GET");
	 String actname = getJsonPath(response, "name");
	 assertEquals(actname,expName);
}


}
