package helper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static helper.CreateTestData.getTokenRequestBody;
import static io.restassured.RestAssured.given;

public class TestHelper {

    public String baseUrl = "https://restful-booker.herokuapp.com/booking";

    public String getToken() {

        JSONObject credentials = getTokenRequestBody();

        return given().contentType(ContentType.JSON).body(credentials.toString()).
                when().post("https://restful-booker.herokuapp.com/auth").
                then().statusCode(200).extract()
                .jsonPath().getString("token");

    }

    public Response getAllBookings() {
        return given().when().get(baseUrl).thenReturn();
    }

    public Response getBookingById(int bookingId){
        return given().when().get(baseUrl+"/"+bookingId).thenReturn();
    }

    public Response getBookingByName(String firstName, String lastName) {
        return given().
                when().queryParam("firstname", firstName).queryParam("lastname", lastName)
                .get(baseUrl).thenReturn();
    }

    public Response getBookingByDate(String checkin, String checkout) {
        return given().
                when().queryParam("checkin", checkin).queryParam("checkout", checkout)
                .get(baseUrl).thenReturn();
    }

    public Response createBooking() {

        JSONObject requestBody = CreateTestData.getCreateBookingData();

        Response response = given().contentType(ContentType.JSON).body(requestBody.toString()).
                when().post(baseUrl).then().statusCode(200).and().extract().response();

        System.out.println("Booking Created With Booking ID: " +
                response.getBody().jsonPath().getString("bookingid"));

        return response;
    }

    public Response deleteBooking(int bookingId) {

//      Get Token in order to delete a booking
        String token = getToken();
        Assert.assertNotNull(token);

        System.out.println("Deleting BookingID: "+bookingId);
        return given().headers("Content-Type", "application/json", "Cookie", "token=" + token).
                when().delete(baseUrl + "/" + bookingId).thenReturn();
    }

    public Response updateBooking(int bookingId){
        //      Get Token in order to delete a booking
        String token = getToken();
        Assert.assertNotNull(token);

        JSONObject updateRequestBody= CreateTestData.getUpdateBookingData();
        System.out.println("Updating BookingID: "+bookingId);
        return given().headers("Content-Type", "application/json", "Cookie", "token=" + token).
                body(updateRequestBody.toString()).
                when().put(baseUrl + "/" + bookingId).thenReturn();
    }

    public Response updatePartialBooking(int bookingId){
        //      Get Token in order to delete a booking
        String token = getToken();
        Assert.assertNotNull(token);

        JSONObject updateRequestBody= CreateTestData.getPartialUpdateBookingData();
        System.out.println("Partially Updating BookingID: "+bookingId);
        return given().headers("Content-Type", "application/json", "Cookie", "token=" + token).
                body(updateRequestBody.toString()).
                when().patch(baseUrl + "/" + bookingId).thenReturn();
    }
}
