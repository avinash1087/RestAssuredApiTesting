package tests;

import helper.testHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class testUpdateBooking extends testHelper {
    Response response;

    @Test
    public void testPutRequest()  {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test PUT by updating the booking details
        * Validate that the booking has been updated
        * Delete the booking
    */

//        Create a Booking
        response = createBooking();
        int actualBookingId = response.getBody().jsonPath().get("bookingid");

//        GET booking by ID and validate it
        response = updateBooking(actualBookingId);
        Assert.assertEquals(200, response.statusCode());

//        DELETE the booking
        deleteBooking(actualBookingId);

    }
}
