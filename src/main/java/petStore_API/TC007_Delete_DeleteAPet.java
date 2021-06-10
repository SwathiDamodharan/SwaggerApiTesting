package petStore_API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC007_Delete_DeleteAPet {

	public static int petID;
	@Test
	public static void main() {

		File filePath=new File(".//jsonFiles//deleteAPet.json");

		//Instantiating JSONParser class
		JSONParser parser=new JSONParser();

		try {
			//parsing the contents of json file
			Object obj= parser.parse(
					new FileReader(".//jsonFiles//deleteAPet.json"));
			JSONObject jsonobj=(JSONObject) obj;

			//Retrieving the value associated with key "id"
			String pet_id=String.valueOf(jsonobj.get("id"));
			petID=Integer.parseInt(pet_id);

			RestAssured.given().accept(ContentType.JSON).
			contentType(ContentType.JSON).when().
			delete("https://petstore.swagger.io/v2/pet/"+petID+"").then().
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
