package petStore_API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Tc003_Put_updateAnExistingPet {

	
	@Test
	public static void updateAnExistingPet() throws FileNotFoundException {

		System.out.println("*******************Updating an existing pet***************************");

		//JsonFilePath
		File filePath=new File("C:\\Users\\Swathi\\eclipse-workspace\\Swagger_petstore\\jsonFiles\\updateAnExistingPetID.json");

			

			//Initializing header and content type of request body
			RestAssured.		
			given().
			accept(ContentType.JSON).
			contentType(ContentType.JSON).

			//passing input in the form of json file
			body(filePath).

			//invoking put request to update the data	
			when().
			put("https://petstore.swagger.io/v2/pet").

			//getting response status code and asserting the testcase based on the response code
			then().
			assertThat().
			statusCode(200).log().body();
		
	}
}


