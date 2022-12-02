package helper;

import org.json.simple.JSONObject;

public class createTestData {

    public static String checkInDateRange = "2022-11-25";
    public static String checkOutDateRange = "2022-12-31";

    public static JSONObject getTokenRequestBody(){
        JSONObject credentials = new JSONObject();
        credentials.put("username","admin");
        credentials.put("password","password123");

        return credentials;
    }
    public static JSONObject getCreateBookingData(){
        JSONObject body = new JSONObject();
        body.put("firstname","Rakesh");
        body.put("lastname","Kumar");
        body.put("depositpaid",true);
        body.put("totalprice",1087);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2022-12-01");
        bookingDates.put("checkout","2022-12-02");

        body.put("bookingdates",bookingDates);
        body.put("additionalneeds","Breakfast");

        return body;
    }

    public static JSONObject getUpdateBookingData(){
        JSONObject body = new JSONObject();
        body.put("firstname","Charlie");
        body.put("lastname","Chaplin");
        body.put("depositpaid",true);
        body.put("totalprice",5000);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2022-12-01");
        bookingDates.put("checkout","2022-12-02");

        body.put("bookingdates",bookingDates);
        body.put("additionalneeds","Lunch/Dinner");

        return body;
    }

    public static JSONObject getPartialUpdateBookingData(){
        JSONObject body = new JSONObject();
        body.put("firstname","Stephan");
        body.put("lastname","Hawkings");
        body.put("additionalneeds","Double Bed");

        return body;
    }
}
