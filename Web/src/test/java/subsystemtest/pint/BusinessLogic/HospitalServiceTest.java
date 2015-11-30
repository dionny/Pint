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
public class HospitalServiceTest extends BaseIntegrationTest {
    @Before
    public void beforeTest() throws Exception {
        createTestData();
    }

    @Test
    public void testGetNurses_returnsNurses() throws Exception {

        // Act.
        List<Employee> output = hospitalService.getNurses(testHospital1.getId());

        // Assert.
        assertEquals(3, output.size());
        assertTrue(output.contains(testAssignedNurse));
        assertTrue(output.contains(testUnassignedNurse));
        assertTrue(output.contains(testAnotherNurse));
    }
}
