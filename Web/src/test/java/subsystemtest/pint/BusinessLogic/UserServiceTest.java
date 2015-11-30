package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Notification;
import com.pint.Data.Models.UserNotification;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends BaseIntegrationTest {
    @Before
    public void beforeTest() throws Exception {
        createTestData();
    }

    @Test
    public void testCreateEmployee_createsEmployee() throws Exception {

        // Act.
        Employee output = userService.createEmployee(
                "test@pint.edu",
                "password",
                "first",
                "last",
                "3335558888",
                UserRole.MANAGER,
                testHospital1.getId());

        User user = userService.getUserById(output.getUserId());

        // Assert.
        verify(dataFacade).createEmployee(output);
    }
}
