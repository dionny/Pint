package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.*;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.*;
import org.joda.time.DateTime;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by DionnyS on 11/30/2015.
 */
public class BaseIntegrationTest {

    protected DataFacade dataFacade;

    protected UserService userService;
    protected HospitalService hospitalService;
    protected BloodDriveService bloodDriveService;
    protected EmployeeService employeeService;
    protected NotificationService notificationService;

    protected Hospital testHospital1;
    protected Hospital testHospital2;
    protected BloodDrive testDrive1;
    protected BloodDrive testDrive2;
    protected BloodDrive testDrive3;
    protected java.sql.Date testDate;
    protected Employee testAssignedNurse;
    protected Employee testUnassignedNurse;
    protected Employee testOtherHospitalNurse;
    protected Employee testAnotherNurse;
    protected Employee testCoordinator;
    protected Donor testDonor;
    protected User testUser;
    protected Employee testEmployee;

    protected BloodDrive createMockBloodDrive(long bloodDriveId, String title, String description, Date startTime, Date endTime, String address, int numberofDonors, String city, String state, int zip, Hospital hospitalId) {
        BloodDrive drive = new BloodDrive(
                bloodDriveId, title, description, startTime, endTime, address, numberofDonors, city, state, zip, hospitalId);

        when(dataFacade.getBloodDriveById(bloodDriveId))
                .thenReturn(drive);

        return drive;
    }

    protected Employee createMockEmployee(Long id, UserRole role, Hospital hospital) {
        User user = new User();
        user.setId(id);
        user.grantRole(role);
        Employee employee = new Employee(id);
        employee.setHospitalId(hospital);

        when(dataFacade.getUserById(id))
                .thenReturn(user);

        when(dataFacade.getEmployeeById(id))
                .thenReturn(employee);

        return employee;
    }

    protected Donor createMockDonor(Long id, String email) {
        User user = new User();
        user.setId(id);
        user.grantRole(UserRole.DONOR);
        Donor donor = new Donor();
        donor.setUserId(id);

        when(dataFacade.getUserById(id))
                .thenReturn(user);

        when(dataFacade.getUserByEmail(email))
                .thenReturn(user);

        return donor;
    }

    protected void createTestData() {

        dataFacade = mock(DataFacade.class);
        userService = new UserService(dataFacade);
        hospitalService = new HospitalService(dataFacade, userService);
        bloodDriveService = new BloodDriveService(userService, hospitalService, dataFacade);
        employeeService = new EmployeeService(userService, dataFacade);
        notificationService = new NotificationService(dataFacade);

        testDate = Utils.sqlDate(DateTime.now());
        testHospital1 = new Hospital("Test Hospital 1");
        testHospital1.setId(1L);

        testHospital2 = new Hospital("Test Hospital 2");
        testHospital2.setId(2L);

        testDrive1 = createMockBloodDrive(
                1, "Test Drive 1", "Description 1", testDate, testDate, "Address 1", 0, "City 1", "State 1", 1, testHospital1);
        testDrive2 = createMockBloodDrive(
                2, "Test Drive 2", "Description 2", testDate, testDate, "Address 2", 0, "City 2", "State 2", 1, testHospital1);
        testDrive3 = createMockBloodDrive(
                2, "Test Drive 3", "Description 3", testDate, testDate, "Address 3", 0, "City 3", "State 3", 1, testHospital2);

        testDrive1.setEmployees(new HashSet<>());
        testDrive2.setEmployees(new HashSet<>());
        testDrive3.setEmployees(new HashSet<>());

        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);
        bloodDrives.add(testDrive3);

        when(dataFacade.getBloodDrives())
                .thenReturn(bloodDrives);

        testDonor = createMockDonor(9L, "donor@pint.edu");

        testEmployee = createMockEmployee(1L, UserRole.COORDINATOR, testHospital1);
        testCoordinator = createMockEmployee(3L, UserRole.COORDINATOR, testHospital1);
        testAssignedNurse = createMockEmployee(5L, UserRole.NURSE, testHospital1);
        testUnassignedNurse = createMockEmployee(6L, UserRole.NURSE, testHospital1);
        testAnotherNurse = createMockEmployee(7L, UserRole.NURSE, testHospital1);
        testOtherHospitalNurse = createMockEmployee(8L, UserRole.NURSE, testHospital2);

        List<Employee> hospital1Employees = new ArrayList<>();
        hospital1Employees.add(testEmployee);
        hospital1Employees.add(testCoordinator);
        hospital1Employees.add(testAssignedNurse);
        hospital1Employees.add(testUnassignedNurse);
        hospital1Employees.add(testAnotherNurse);

        when(dataFacade.getHospitalEmployees(1L)).thenReturn(hospital1Employees);

        List<Employee> hospital2Employees = new ArrayList<>();
        hospital2Employees.add(testOtherHospitalNurse);

        when(dataFacade.getHospitalEmployees(2L)).thenReturn(hospital2Employees);
    }
}