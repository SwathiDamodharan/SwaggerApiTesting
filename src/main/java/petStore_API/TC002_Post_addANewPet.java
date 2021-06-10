package petStore_API;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_addANewPet {

	@Test
	public static void addANewPet() throws IOException {
		
		System.out.println("*******************Updating an existing pet***************************");
		
		//JsonFilePath
		File files=new File("C:\\Users\\Swathi\\eclipse-workspace\\Swagger_petstore\\jsonFiles\\addANewPet.json");
					
		//Initializing header and content type of request body
		RestAssured.
		given().		
			accept(ContentType.JSON).
			contentType(ContentType.JSON).
			
			//passing input in the form of json file
			body(files).
			
		//invoking put request to update the data
		when().
			post("https://petstore.swagger.io/v2/pet").
			
		//getting response status code and asserting the testcase based on the response code
		then().
			assertThat().
			statusCode(200).log().body();
		
		
		
	}
}
