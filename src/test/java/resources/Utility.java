package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	
	RequestSpecification req;
	
	
	public RequestSpecification requestSpecification() throws Exception{
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		 req =new RequestSpecBuilder().setBaseUri(getPropertyValue("baseUrl")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();	
		 return req;
	}
	
	public static String getPropertyValue(String key) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\java\\resources\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key) {
		
		String resp = response.asString();
		JsonPath  js = new JsonPath(resp);
		return js.get(key);
	}

}
