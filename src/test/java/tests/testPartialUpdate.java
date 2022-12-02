package tests;

import helper.testHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class testPartialUpdate extends testHelper {
    Response response;

    @Test
    public void testPatchRequest() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test PATCH by updating the booking details
        * Validate that the booking has been updated
        * Delete the booking
    */

//        Create a Booking
        response = createBooking();
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int actualBookingId = response.getBody().jsonPath().get("bookingid");

//        GET booking by ID and validate it
        response = updatePartialBooking(actualBookingId);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Double Bed",response.jsonPath().getString("additionalneeds"));
        Assert.assertEquals("Stephan",response.jsonPath().getString("firstname"));
        Assert.assertEquals("Hawkings",response.jsonPath().getString("lastname"));

//        DELETE the booking
        deleteBooking(actualBookingId);

    }
}
