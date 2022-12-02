package tests;

import helper.testHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testCreateBooking extends testHelper{
    Response response;
    int bookingId;

    @Test
    public void testCreateBooking() {

        response = createBooking();
        bookingId = response.getBody().jsonPath().get("bookingid");

        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(bookingId);

        System.out.println("Booking Confirmed, Please note the Booking ID: " + bookingId);

    }

}
