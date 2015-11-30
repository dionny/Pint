package subsystemtest.pint.BusinessLogic;

import com.pint.Data.Models.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest extends BaseIntegrationTest {
    @Before
    public void beforeTest() throws Exception {
        createTestData();
    }

    @Test
    public void testGetEmployees_returnsEmployees() throws Exception {

        // Act.
        List<Employee> output = employeeService.getEmployees(
                userService.getUserById(testCoordinator.getUserId()), testHospital1);

        // Assert.
        assertEquals(4, output.size());
        assertFalse(output.contains(testCoordinator));
        assertTrue(output.contains(testEmployee));
        assertTrue(output.contains(testAssignedNurse));
        assertTrue(output.contains(testUnassignedNurse));
        assertTrue(output.contains(testAnotherNurse));
    }
}
