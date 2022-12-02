package tests;

import helper.createTestData;
import helper.testHelper;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class testGetBookings {
    testHelper testHelper = new testHelper();
    Response response;

    @Test
    public void testGetAllBookings() {
        response = testHelper.getAllBookings();
        Assert.assertEquals(200, response.statusCode());
    }


    @Test
    public void testGetBookingById() {

    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by ID
        * Validate the response
        * Delete the booking
    */

//        Create a Booking
        response = testHelper.createBooking();
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int bookingId = response.getBody().jsonPath().get("bookingid");

//        Get Booking by ID
        Response getResponsebyId = testHelper.getBookingById(bookingId);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.getBody().jsonPath().getString("booking"),
                getResponsebyId.getBody().jsonPath().getString("$"));

//        Delete the Booking
        testHelper.deleteBooking(bookingId);

    }

    @Test
    public void testGetBookingByName() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by name
        * Delete the booking
    */

//        Create a Booking
        response = testHelper.createBooking();
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int actualBookingId = response.getBody().jsonPath().get("bookingid");

//        GET booking by name and validate it
        response = testHelper.getBookingByName(firstName, lastName);
        Assert.assertEquals(200,response.statusCode());
        List<HashMap<String,Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(actualBookingId)));

//        DELETE the booking
        testHelper.deleteBooking(actualBookingId);


    }

    @Test
    public void testGetBookingByDate() throws ParseException {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by checkin and checkout date
        * Delete the booking
    */

//        Create a Booking
        response = testHelper.createBooking();
        String checkin = response.jsonPath().getString("booking.bookingdates.checkin");
        String checkout = response.jsonPath().getString("booking.bookingdates.checkout");
        int actualBookingId = response.getBody().jsonPath().get("bookingid");


//        GET booking by name and validate it
        response = testHelper.getBookingByDate(createTestData.checkInDateRange,createTestData.checkOutDateRange);
        Assert.assertEquals(200,response.statusCode());
        List<HashMap<String,Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(actualBookingId)));

//        DELETE the booking
        testHelper.deleteBooking(actualBookingId);


    }


}
