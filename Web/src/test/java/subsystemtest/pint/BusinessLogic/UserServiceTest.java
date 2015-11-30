package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.BusinessLogic.Validators.ValidationException;
import com.pint.Data.Models.*;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

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

        // Arrange.
        Mockito.doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            User actualValue = (User) args[0];
            actualValue.setId(10L);

            when(dataFacade.getUserById(10L))
                    .thenReturn(actualValue);

            return actualValue;
        }).when(dataFacade).createOrUpdateUser(any(User.class));

        // Act.
        Employee output = userService.createEmployee(
                "test@pint.edu",
                "password",
                "first",
                "last",
                "3335558888",
                UserRole.MANAGER,
                testHospital1.getId());

        User user = userService.getUserById(10L);

        // Assert.
        verify(dataFacade).createEmployee(output);
        verify(dataFacade).createOrUpdateUser(user);
        assertEquals("test@pint.edu", user.getUsername());
        assertNotEquals("password", user.getPassword());
        assertTrue(user.hasRole(UserRole.MANAGER));
        assertEquals("first", output.getFirstName());
        assertEquals("last", output.getLastName());
        assertEquals("3335558888", output.getPhoneNumber());
    }

    @Test
    public void testCreateDonor_createsDonor() throws Exception {

        // Arrange.
        Mockito.doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            User actualValue = (User) args[0];
            actualValue.setId(10L);

            when(dataFacade.getUserById(10L))
                    .thenReturn(actualValue);

            return actualValue;
        }).when(dataFacade).createOrUpdateUser(any(User.class));

        // Act.
        Donor output = userService.createDonor(
                "test@pint.edu",
                "password",
                "USA",
                "Miami",
                "FL",
                33165);

        User user = userService.getUserById(10L);

        // Assert.
        verify(dataFacade).createDonor(output);
        verify(dataFacade).createOrUpdateUser(user);
        assertEquals("test@pint.edu", user.getUsername());
        assertNotEquals("password", user.getPassword());
        assertTrue(user.hasRole(UserRole.DONOR));
//        assertEquals("first", output.getFirstName());
//        assertEquals("last", output.getLastName());
//        assertEquals("3335558888", output.getPhoneNumber());
//        verify(dataFacade).createDonor(output);
    }
}
