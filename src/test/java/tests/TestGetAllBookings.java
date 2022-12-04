package tests;

import helper.testHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestGetAllBookings extends testHelper {


        @Test
        public void testGetAllBookings() {
            Response response = getAllBookings();
            Assert.assertEquals(200, response.statusCode());
        }
    }

