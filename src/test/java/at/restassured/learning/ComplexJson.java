package at.restassured.learning;

import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(PayLoad.courseDetails());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String title = js.get("courses[2].title");
		System.out.println(title);
		
		 
	}

}
