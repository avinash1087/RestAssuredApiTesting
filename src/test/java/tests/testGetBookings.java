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

public class testGetBookings extends testHelper{

    Response response;

    @Test
    public void testGetAllBookings() {
        response = getAllBookings();
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
        response = createBooking();
        int bookingId = response.getBody().jsonPath().get("bookingid");

//        Get Booking by ID
        Response getResponsebyId = getBookingById(bookingId);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.getBody().jsonPath().getString("booking"),
                getResponsebyId.getBody().jsonPath().getString("$"));

//        Delete the Booking
        deleteBooking(bookingId);

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
        response = createBooking();
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int actualBookingId = response.getBody().jsonPath().get("bookingid");

//        GET booking by name and validate it
        response = getBookingByName(firstName, lastName);
        Assert.assertEquals(200,response.statusCode());
        List<HashMap<String,Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(actualBookingId)));

//        DELETE the booking
        deleteBooking(actualBookingId);


    }

    @Test
    public void testGetBookingByDate() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by checkin and checkout date range
        * Delete the booking
    */

//        Create a Booking
        response = createBooking();
        int actualBookingId = response.getBody().jsonPath().get("bookingid");


//        GET booking by name and validate it
        response = getBookingByDate(createTestData.checkInDateRange,createTestData.checkOutDateRange);
        Assert.assertEquals(200,response.statusCode());
        List<HashMap<String,Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(actualBookingId)));

//        DELETE the booking
        deleteBooking(actualBookingId);


    }


}
