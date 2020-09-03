package test;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
	
public class ReqRes {

	@Test
	public void Create() {

		RestAssured.baseURI = "https://reqres.in/";

		// create new user using POST request
		String response = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}").when()
				.post("api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
		System.out.println("Response received from POST request:\n" + response);
		System.out.println("\n");

	}

	@Test
	public void Read() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		// retrieve the user details using GET request
		String response1 = given().log().all().pathParam("userId", 2).when().get("api/users/{userId}").then().log()
				.all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Response received from GET request:\n" + response1);
		System.out.println("\n");

		// retrieve the details of unknown user using GET request
		String response2 = given().log().all().pathParam("userId", 23).when().get("api/users/{userId}").then().log()
				.all().assertThat().statusCode(404).extract().response().asString();
		System.out.println("Response received from GET request:\n" + response2);
		System.out.println("\n");

	}

	@Test
	public void Update() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		// update the user details using PUT request
		String response3 = given().log().all().pathParam("userId", 2).header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}").when()
				.put("api/users/{userId}").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		System.out.println("Response received from PUT request:\n" + response3);
		System.out.println("\n");

		// update the user details using PATCH request
		String response4 = given().log().all().pathParam("userId", 2).header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}").when()
				.patch("api/users/{userId}").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		System.out.println("Response received from PATCH request:\n" + response4);
		System.out.println("\n");
	}

	@Test
	public void Delete() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		// delete the created user using DELETE request
		given().log().all().pathParam("userId", 2).when().delete("api/users/{userId}").then().log().all().assertThat()
				.statusCode(204);
		System.out.println("User deleted successfully");
	}
}
