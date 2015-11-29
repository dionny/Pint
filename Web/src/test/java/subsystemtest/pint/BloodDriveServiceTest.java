package subsystemtest.pint;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.HospitalService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by Dionny on 11/28/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BloodDriveServiceTest {

    @InjectMocks
    private UserService userService = new UserService();

    @InjectMocks
    private HospitalService hospitalService = new HospitalService();

    @InjectMocks
    private BloodDriveService bloodDriveService = new BloodDriveService(userService, hospitalService);

    @Mock
    private DataFacade dataFacade;

    private BloodDrive bloodDrive;

    @Before
    public void setUp() throws Exception {
        bloodDrive = new BloodDrive();
        HashSet<Employee> employees = new HashSet<>();
        User user = new User();
        user.setId(1L);
        user.grantRole(UserRole.COORDINATOR);
        Employee coordinator = new Employee(1L);
        employees.add(coordinator);
        bloodDrive.setEmployees(employees);

        when(dataFacade.getUserById(1L)).thenReturn(user);
        when(dataFacade.getBloodDrives()).thenReturn(null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetCoordinator() throws Exception {
        // Act.
        Employee coordinator = bloodDriveService.getCoordinator(bloodDrive);

        // Assert.
        assertNotNull(coordinator);
        assertEquals(new Long(1), coordinator.getUserId());
    }

    @Test
    public void testGetBloodDrivesByHospital() throws Exception {

    }

    @Test
    public void testGetBloodDrivesByLocation() throws Exception {

    }

    @Test
    public void testGetBl2oodDrivesByLocation() throws Exception {
    }

    @Test
    public void testGetBloodDrivesForCoordinator() throws Exception {

    }

    @Test
    public void testCreateBloodDrive() throws Exception {

    }

    @Test
    public void testGetBloodDriveByCoordinator() throws Exception {

    }

    @Test
    public void testGetNursesForBloodDrive() throws Exception {

    }

    @Test
    public void testBloodDrivesContainEmployee() throws Exception {

    }

    @Test
    public void testGetUnassignedNurses() throws Exception {

    }

    @Test
    public void testAssignNurses() throws Exception {

    }

    @Test
    public void testUnassignNurses() throws Exception {

    }

    @Test
    public void testGetBloodDrivesForNurse() throws Exception {

    }

    @Test
    public void testGetBloodDriveByNurse() throws Exception {

    }

    @Test
    public void testInputDonor() throws Exception {

    }
}