package tests;

import helper.TestHelper;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class BaseClass extends TestHelper {
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
