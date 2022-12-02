import helper.testHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class testUpdateBooking {
    helper.testHelper testHelper = new testHelper();
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

//        Create a Booking
        response = testHelper.createBooking();
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int actualBookingId = response.getBody().jsonPath().get("bookingid");

//        GET booking by ID and validate it
        response = testHelper.updateBooking(actualBookingId);
        Assert.assertEquals(200, response.statusCode());

//        DELETE the booking
        testHelper.deleteBooking(actualBookingId);

    }
}
