package petStore_API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC004_Get_findPetByStatus {

	public static String status;
	@Test
	public static void addANewPet() {
		File filePath=new File(".//jsonFiles//findPetByStatus.json");

		JSONParser parser=new JSONParser();

		try {
			//parsing the contents of json file
			Object obj= parser.parse(
					new FileReader(".//jsonFiles//findPetByStatus.json"));
			JSONObject jsonobj=(JSONObject) obj;

			//Retrieving the value associated with key "id"
			String status=String.valueOf(jsonobj.get("status"));
			
		Response resp=RestAssured.
				given().header("Content-Type","application/json").
				contentType(ContentType.JSON).
				body(filePath).
				when().
				get("https://petstore.swagger.io/v2/pet/findByStatus?status="+status+"").
				then().extract().response();
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
