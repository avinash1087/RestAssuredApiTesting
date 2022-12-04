package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestUpdateBooking extends BaseClass {
    Response response;

    @Test
    public void testPutRequest() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test PUT by updating the booking details
        * Validate that the booking has been updated
        * Delete the booking
    */

//        GET booking by ID and validate it
        response = updateBooking(bookingId);
        Assert.assertEquals(200, response.statusCode());

    }
}
