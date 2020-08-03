package DemoJunitRest.DemoJunitRest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test {

	@Test

	public void getALdata() {

		ArrayList<Object[]> Ob = new ArrayList<Object[]>();
		utility reader = new utility("E:/softwares/eclipse/DemoJunitRest/src/test/java/data/data.xlsx");
		for (int rowNumber = 0; rowNumber <= reader.getRowCount("Sheet1"); rowNumber++) {
			String City = reader.getCellData("Sheet1", "Data", rowNumber);
			baseURI = "https://www.google.com";

			// adding path parameter and creating request and getting response
			RequestSpecification request = given().contentType(ContentType.JSON);
			Response response = given().contentType(ContentType.JSON).when().get(City);


			// Printing all the details from resposne

			//System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(response.getBody().jsonPath());
			//System.out.println(response.getBody());
			Assert.assertEquals(response.getStatusCode(), 200);
			

		}

	}

}
