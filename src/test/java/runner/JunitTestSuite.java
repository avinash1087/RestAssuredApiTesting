package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestCreateAndDeleteBooking.class,
        TestGetAllBookings.class,
        TestGetBookingsWithFilter.class,
        TestPartialUpdateBooking.class,
        TestUpdateBooking.class

})
public class JunitTestSuite {
}
