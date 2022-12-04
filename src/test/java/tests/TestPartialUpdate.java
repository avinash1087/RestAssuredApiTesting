package tests;

import org.junit.Assert;
import org.junit.Test;

public class TestPartialUpdate extends BaseClass {

    @Test
    public void testPatchRequest() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test PATCH by updating the booking details
        * Validate that the booking has been updated
        * Delete the booking
    */

//        GET booking by ID and validate it
        response = updatePartialBooking(bookingId);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Double Bed",response.jsonPath().getString("additionalneeds"));
        Assert.assertEquals("Stephan",response.jsonPath().getString("firstname"));
        Assert.assertEquals("Hawkings",response.jsonPath().getString("lastname"));


    }
}
