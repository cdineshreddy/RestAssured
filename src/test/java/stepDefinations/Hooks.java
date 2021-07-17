package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeSceanrio() throws Exception {
		
		//execute this code only whe place is Null
		//write a code that will give you place id
		
		StepDefination sd = new StepDefination();
		if(StepDefination.placeID==null) {
			
		sd.add_place_payload_with("Dinesh", "English", "India");
		sd.user_calls_with_http_request("addPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("Dinesh", "getPlaceAPI");
		}		
	}

}
