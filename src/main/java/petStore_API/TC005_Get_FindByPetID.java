package petStore_API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC005_Get_FindByPetID {

	public static int petID;

	@Test
	public static void findPetByID() throws FileNotFoundException {

		System.out.println("*******************Updating an existing pet***************************");

		//JsonFilePath
		File filePath=new File(".//jsonFiles//getPetByPetID.json");

		//Instantiating JSONParser class
		JSONParser parser=new JSONParser();

		try {
			//parsing the contents of json file
			Object obj= parser.parse(
					new FileReader(".//jsonFiles//getPetByPetID.json"));
			JSONObject jsonobj=(JSONObject) obj;

			//Retrieving the value associated with key "id"
			String pet_id=String.valueOf(jsonobj.get("id"));
			petID=Integer.parseInt(pet_id);

			//Initializing header and content type of request body
			Response resp=RestAssured.
			given().
				header("Content-Type","application/json").
				baseUri("https://petstore.swagger.io/").
				contentType(ContentType.JSON).

				//passing input in the form of json file
				body(filePath).

			//invoking get request to fetch the data	
			when().
				get("v2/pet/"+petID+"").

			//getting response 	
			then().
				extract().
				response();

			//Asserting the testcase with respect the status code
			Assert.assertEquals(200, resp.getStatusCode());
			
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
