package at.restassured.learning;

import static io.restassured.RestAssured.given;
import java.util.List;
import at.restassured.pojo.API;
import at.restassured.pojo.GetCourse;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class OAuthTest {

	public static void main(String[] args) throws Exception {
		
		RestAssured.registerParser("text/html", Parser.JSON);
		
		//Generating the code from the browser
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./src/test/resources/chromedriver.exe"); 
		 * WebDriver driver = new ChromeDriver(); 
		 * driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verify"); 
		 * driver.findElement(By.cssSelector("input[type='email']")).sendKeys("dinesh.cdr@gmail.com");
		 * driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER ); 
		 * Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Welcome123@");
		 * driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER );
		 *  Thread.sleep(3000);
		 *  String url = driver.getCurrentUrl();
		 */
		String url ="https://rahulshettyacademy.com/getCourse.php?state=verify&code=4%2F0AX4XfWhFWS30YwGmWO44RSQmobYbGZf97R39eNDSQFRKR_w04vaxdCv33AgfyNyXbVIcXQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialInput = url.split("code=")[1];
		String code = partialInput.split("&scope")[0];
		System.out.println("Code: "+code);		
		
		//Converting the code to Access token
		String accessToken = given().urlEncodingEnabled(false)
														.queryParam("code",code)
														.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
														.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
														.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
														.queryParam("grant_type", "authorization_code")
												.when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
			JsonPath js = new JsonPath(accessToken);
			String token = js.getString("access_token");
			System.out.println("Access Token: "+token);
		
		//Fetching the course details
		GetCourse response = given().queryParam("access_token", token)
												.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println(response.getLinkedIn());
		System.out.println(response.getInstructor());
		String courseTitle = response.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(courseTitle);
		
		List<API> apiCourses = response.getCourses().getApi();
		for(API apiCourse:apiCourses) {
			if(apiCourse.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apiCourse.getPrice());
			}
		}
		
		//System.out.println("Final Response: "+response);

	}

}
