package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testPing {
    @Test
    public void testPing() {
        given().when().get("https://restful-booker.herokuapp.com/ping").then().statusCode(201);
    }
}
