package tests;

import helper.testHelper;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class BaseClass extends testHelper {
    int bookingId;
    Response response;

    @Before
    public void createABooking(){
        response = createBooking();
        bookingId = response.getBody().jsonPath().get("bookingid");
    }

    @After
    public void deleteABooking(){
        deleteBooking(bookingId);
    }
}
