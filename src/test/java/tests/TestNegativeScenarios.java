package tests;

import helper.CreateTestData;
import helper.TestHelper;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestNegativeScenarios extends TestHelper {

    @Test
    public void testInvalidBookingId() {
        given().when().get(baseUrl+"/abc123").then().statusCode(404);
    }

    @Test
    public void testInvalidRequestBody(){
        given().contentType(ContentType.JSON).body(CreateTestData.getInvalidCreateBookingData().toString()).
                when().post(baseUrl).then().statusCode(500);
    }

    @Test
    public void testInvalidToken(){
        given().headers("Content-Type", "application/json", "Cookie", "token=Er4567").
                body(CreateTestData.getUpdateBookingData().toString()).
                when().put(baseUrl + "/74569" ).then().statusCode(403);
    }
}
