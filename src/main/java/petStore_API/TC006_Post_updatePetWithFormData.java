package petStore_API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC006_Post_updatePetWithFormData {


	public static int petID;
	@Test
	public static void updateAPetInTheStoreWithFormData() {		

		System.out.println("*******************Updating form data for existing pet id***************************");

		File filePath=new File(".//jsonFiles//updatePetWithFormData.json");
		
		//Instantiating JSONParser class
		JSONParser parser=new JSONParser();
		
		try {
			//parsing the contents of json file
			Object obj= parser.parse(
					new FileReader(".//jsonFiles//updatePetWithFormData.json"));
			JSONObject jsonobj=(JSONObject) obj;
			
			//retrieveing the value associated with key "id"
			String pet_id=String.valueOf(jsonobj.get("id"));
			petID=Integer.parseInt(pet_id);
						
			//Initializing header and content type of request body
			RestAssured.
			given().
			accept(ContentType.JSON).
			contentType(ContentType.JSON).

			//passing input in the form of json file
			body(filePath).

			when().
			//invoking post request to update the data
			post("https://petstore.swagger.io/v2/pet/"+petID+"").
			then().
			//getting response status code and asserting the testing testcase based on the response code
			assertThat().
			statusCode(200).log().body();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JsonFilePath

	} 
}




