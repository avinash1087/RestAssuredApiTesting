package tests;

import helper.TestHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestCreateAndDeleteBooking extends TestHelper {
    @Test
    public void testCreateAndDeleteRequest(){

//      We first create a booking in order to test DELETE request
        Response response = createBooking();
        Assert.assertEquals(200,response.statusCode());
        int bookingId = response.getBody().jsonPath().get("bookingid");
        System.out.println("Booking Confirmed, Please note the Booking ID: "+bookingId);

//        Test that the above created record is deleted successfully
        response = deleteBooking(bookingId);
        Assert.assertEquals(201,response.statusCode());

    }
}
