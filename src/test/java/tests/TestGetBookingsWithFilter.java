package tests;

import helper.CreateTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class TestGetBookingsWithFilter extends BaseClass {

    @Test
    public void testGetBookingById() {

    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by ID
        * Validate the response
        * Delete the booking
    */


//        Get Booking by ID
        Response getResponsebyId = getBookingById(bookingId);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.getBody().jsonPath().getString("booking"),
                getResponsebyId.getBody().jsonPath().getString("$"));


    }

    @Test
    public void testGetBookingByName() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by name
        * Delete the booking
    */

//        Fetch firstname, lastname from already created booking
        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");

//        GET booking by name and validate it
        response = getBookingByName(firstName, lastName);
        Assert.assertEquals(200, response.statusCode());
        List<HashMap<String, Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(bookingId)));


    }

    @Test
    public void testGetBookingByDate() {
    /*
        Following approach is followed to test this functionality
        * Create a booking
        * Test GET booking by checkin and checkout date range
        * Delete the booking
    */


//        GET booking by name and validate it
        response = getBookingByDate(CreateTestData.checkInDateRange, CreateTestData.checkOutDateRange);
        Assert.assertEquals(200, response.statusCode());
        List<HashMap<String, Integer>> expectedBookingId = response.getBody().jsonPath().getList("$");
        Assert.assertTrue(expectedBookingId.toString().contains(String.valueOf(bookingId)));

    }


}
