package tests;

import helper.testHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testDelete extends testHelper{
    Response response;
    @Test
    public void testDeleteRequest(){

//      We first create a booking in order to test DELETE request
        response = createBooking();
        Assert.assertEquals(200,response.statusCode());
        int bookingId = response.getBody().jsonPath().get("bookingid");
        System.out.println("Booking Confirmed, Please note the Booking ID: "+bookingId);

//        Test that the above created record is deleted successfully
        response = deleteBooking(bookingId);
        Assert.assertEquals(201,response.statusCode());

    }
}
