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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TC001_Post_Upload_PetImage {

	public static int petID;
	@Test
	public static void uploadPetImage() throws FileNotFoundException {

		System.out.println("*******************Uploading pet image for the existing pet id***************************");

		//Jsonfilepath
		File file=new File(".//jsonFiles//uploadPetImage.json");

		//Instantiating JSONParser class
		JSONParser parser=new JSONParser();

		try {
			//parsing the contents of json file
			Object obj= parser.parse(
					new FileReader(".//jsonFiles//uploadPetImage.json"));
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
			body(file).

			//invoking post request to update the data
			when().
			post("https://petstore.swagger.io/v2/pet/"+petID+"/uploadImage").

			//getting response status code and asserting the testcase based on the response code
			then().
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
		


	}
}
