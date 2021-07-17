Feature: Validating the place API's

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
					Given Add place payload with "<name>" "<language>" "<address>"
					When user calls "addPlaceAPI" with "POST" http request
					Then the API call got success with status code 200
					And "status" in response body is "OK"
					And "scope" in response body is "APP"
					And verify place ID created maps to "<name>" using "getPlaceAPI"
					
Examples:
|name 	 | language | address                      |
|Dell	 	 | English     | World Cross Center |
#|Lenevo	 | Spanish    | Sea Cross Center      |

@DeletePlace
Scenario: Verify if Delete place functionality is working
				Given Delete place payload
				When user calls "deletePlaceAPI" with "POST" http request
				Then the API call got success with status code 200
				And "status" in response body is "OK"