package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.Donor;
import com.pint.Data.Models.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.junit.Assert.*;
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
        assertEquals("USA", output.getCountry());
        assertEquals("Miami", output.getCity());
        assertEquals("FL", output.getState());
        assertEquals(33165, output.getZip());
    }

    @Test
    public void testGetUserById() throws Exception {

        // Act.
        User user = userService.getUserById(testUser.getId());

        // Assert.
        assertEquals(user, testUser);
    }

    @Test
    public void testGetUserByEmail() throws Exception {

        // Act.
        User user = userService.getUserByEmail(testUser.getUsername());

        // Assert.
        assertEquals(testUser, user);
    }

    @Test
    public void testDeleteUser() throws Exception {

        // Act.
        userService.deleteUser(testUser.getUsername());

        // Assert.
        verify(dataFacade).deleteUser(testUser.getUsername());
    }

    @Test
    public void testUpdateUser() throws Exception {

        // Act.
        User output = userService.updateUser(testUser.getId(), "newEmail@pint.edu");

        // Assert.
        verify(dataFacade).createOrUpdateUser(output);
        assertEquals("newEmail@pint.edu", output.getUsername());
    }

    @Test
    public void testGetEmployeeByUserId() throws Exception {

        // Act.
        Employee output = userService.getEmployeeByUserId(testEmployee.getUserId());

        // Assert.
        assertEquals(testEmployee, output);
    }

    @Test
    public void testUpdateUser_ByUserObject() throws Exception {

        // Act.
        userService.updateUser(testUser);

        // Assert.
        verify(dataFacade).createOrUpdateUser(testUser);
    }

    @Test
    public void testGetAllUsers() throws Exception {

        // Act.
        Collection<User> users = Utils.iterableToCollection(userService.getAllUsers());

        // Assert.
        assertEquals(1, users.size());
        assertTrue(users.contains(testUser));
    }
}
