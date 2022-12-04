package tests;

import helper.TestHelper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestGetAllBookings extends TestHelper {


        @Test
        public void testGetAllBookings() {
            Response response = getAllBookings();
            Assert.assertEquals(200, response.statusCode());
        }
    }

