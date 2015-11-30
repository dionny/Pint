package test.pint.BusinessLogic.Services;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.HospitalService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.BusinessLogic.Validators.ValidationException;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Donor;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BloodDriveServiceTest {

    private BloodDriveService bloodDriveService = new BloodDriveService();

    private DataFacade dataFacade;
    private UserService userService;
    private HospitalService hospitalService;

    private Hospital testHospital1;
    private Hospital testHospital2;
    private BloodDrive testDrive1;
    private BloodDrive testDrive2;
    private BloodDrive testDrive3;
    private java.sql.Date testDate;
    private Employee testAssignedNurse;
    private Employee testUnassignedNurse;
    private Employee testOtherHospitalNurse;
    private Employee testAnotherNurse;
    private Employee testCoordinator;
    private Donor testDonor;
    private User testUser;
    private Employee testEmployee;

    private BloodDrive createMockBloodDrive(long bloodDriveId, String title, String description, Date startTime, Date endTime, String address, int numberofDonors, String city, String state, int zip, Hospital hospitalId) {
        BloodDrive drive = new BloodDrive(
                1, "Test Drive 1", "Description 1", testDate, testDate, "Address 1", 0, "City 1", "State 1", 1, hospitalId);

        when(dataFacade.getBloodDriveById(bloodDriveId))
                .thenReturn(drive);

        return drive;
    }

    private Employee createMockEmployee(Long id, UserRole role, Hospital hospital) {
        User user = new User();
        user.setId(id);
        user.grantRole(role);
        Employee employee = new Employee(id);
        employee.setHospitalId(hospital);

        when(userService.getUserById(id))
                .thenReturn(user);

        when(userService.getEmployeeByUserId(id))
                .thenReturn(employee);

        return employee;
    }

    private Donor createMockDonor(Long id, String email) {
        User user = new User();
        user.setId(id);
        user.grantRole(UserRole.DONOR);
        Donor donor = new Donor();
        donor.setUserId(id);

        when(userService.getUserById(id))
                .thenReturn(user);

        when(userService.getUserByEmail(email))
                .thenReturn(user);

        return donor;
    }

    @Before
    public void beforeTest() throws Exception {
        userService = mock(UserService.class);
        dataFacade = mock(DataFacade.class);
        hospitalService = mock(HospitalService.class);

        bloodDriveService = new BloodDriveService(userService, hospitalService, dataFacade);

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
    }

    @Test
    public void testGetCoordinator_returnsCoordinatorWhenSingleCoordinator() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive1.getEmployees().add(testCoordinator);
        testDrive1.getEmployees().add(testUnassignedNurse);

        // Act.
        Employee output = bloodDriveService.getCoordinator(testDrive1);

        // Assert.
        assertEquals(testCoordinator, output);
    }

    @Test
    public void testGetCoordinator_returnsNullWhenNoCoordinator() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive1.getEmployees().add(testUnassignedNurse);

        // Act.
        Employee output = bloodDriveService.getCoordinator(testDrive1);

        // Assert.
        assertNull(output);
    }

    @Test
    public void testGetBloodDrivesByHospital_returnsBloodDrivesWhenExist() throws Exception {

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesByHospital(1L);

        // Assert.
        assertEquals(2, output.size());
        assertEquals(testDrive1, output.get(0));
        assertEquals(testDrive2, output.get(1));
    }

    @Test
    public void testGetBloodDrivesByHospital_returnsEmptyWhenNoneExist() throws Exception {

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesByHospital(3L);

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testGetBloodDrivesByLocation_delegatesToDataFacade() throws Exception {

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesByLocation("Miami", "FL");

        // Assert.
        verify(dataFacade).getBloodDrivesByLocation("Miami", "FL");
    }

    @Test
    public void testGetBloodDrivesForCoordinator_returnsBloodDrivesOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testCoordinator);

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesForCoordinator(
                testHospital1,
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(1, output.size());
    }

    @Test
    public void testGetBloodDrivesForCoordinator_returnsEmptyOnNonMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testCoordinator);

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesForCoordinator(
                testHospital2,
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testCreateBloodDrive_createsCorrectBloodDrive() throws Exception {

        // Act.
        java.sql.Date start = Utils.sqlDate(DateTime.now().minusDays(5));
        java.sql.Date end = Utils.sqlDate(DateTime.now().plusDays(5));

        BloodDrive output = bloodDriveService.createBloodDrive(testHospital1,
                "New Title",
                "New Address",
                "New Description",
                "New City",
                "New State",
                start, end,
                testCoordinator);

        // Assert.
        verify(dataFacade).createOrUpdateBloodDrive(output);
        assertEquals("New Title", output.getTitle());
        assertEquals("New Address", output.getAddress());
        assertEquals("New Description", output.getDescription());
        assertEquals("New City", output.getCity());
        assertEquals("New State", output.getState());
        assertEquals(start, output.getStartTime());
        assertEquals(end, output.getEndTime());
        assertEquals(testHospital1, output.getHospitalId());
        assertEquals(1, output.getEmployees().size());
        assertTrue(output.getEmployees().contains(testCoordinator));
    }

    @Test
    public void testGetBloodDriveByCoordinator_returnsBloodDriveOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testCoordinator);

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveByCoordinator(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(testDrive1, output);
    }

    @Test
    public void testGetBloodDriveByCoordinator_returnsNullOnNoMatch() throws Exception {

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveByCoordinator(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertNull(output);
    }

    @Test
    public void testGetNursesForBloodDrive_returnsNursesOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive1.getEmployees().add(testUnassignedNurse);
        testDrive1.getEmployees().add(testCoordinator);

        userService.getUserById(testAssignedNurse.getUserId())
                .setUsername("TestNurse1@pint.edu");

        userService.getUserById(testUnassignedNurse.getUserId())
                .setUsername("TestNurse2@pint.edu");

        // Act.
        List<Employee> output = bloodDriveService.getNursesForBloodDrive(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(2, output.size());
        assertEquals(testAssignedNurse, output.get(0));
        assertEquals("TestNurse1@pint.edu", output.get(0).getEmail());
        assertEquals(testUnassignedNurse, output.get(1));
        assertEquals("TestNurse2@pint.edu", output.get(1).getEmail());
    }

    @Test
    public void testGetNursesForBloodDrive_returnsEmptyOnNoMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testCoordinator);

        // Act.
        List<Employee> output = bloodDriveService.getNursesForBloodDrive(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testGetNursesForBloodDrive_returnsEmptyOnNonCoordinator() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive1.getEmployees().add(testUnassignedNurse);

        // Act.
        List<Employee> output = bloodDriveService.getNursesForBloodDrive(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testBloodDrivesContainEmployee_returnsTrueOnMatch() throws Exception {

        // Arrange.
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);
        bloodDrives.add(testDrive3);

        testDrive2.getEmployees().add(testCoordinator);

        // Act.
        boolean output = bloodDriveService.bloodDrivesContainEmployee(
                bloodDrives,
                testCoordinator);

        // Assert.
        assertTrue(output);
    }

    @Test
    public void testBloodDrivesContainEmployee_returnsFalseOnNoMatch() throws Exception {

        // Arrange.
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);
        bloodDrives.add(testDrive3);

        testDrive1.getEmployees().add(testUnassignedNurse);
        testDrive2.getEmployees().add(testCoordinator);
        testDrive3.getEmployees().add(testCoordinator);

        // Act.
        boolean output = bloodDriveService.bloodDrivesContainEmployee(
                bloodDrives,
                testAssignedNurse);

        // Assert.
        assertFalse(output);
    }

    @Test
    public void testGetUnassignedNurses_returnsCorrectUnassignedNurses() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        List<Employee> allNursesOtherHospital = new ArrayList<>();
        allNursesOtherHospital.add(testOtherHospitalNurse);

        when(hospitalService.getNurses(testHospital1.getId()))
                .thenReturn(allNurses);

        when(hospitalService.getNurses(testHospital2.getId()))
                .thenReturn(allNursesOtherHospital);

        testDrive1.getEmployees().add(testCoordinator);
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testUnassignedNurse);

        // Act.
        List<Employee> output = bloodDriveService.getUnassignedNurses(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(1, output.size());
    }

    @Test
    public void testGetUnassignedNurses_returnsEmptyOnNonCoordinator() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        List<Employee> allNursesOtherHospital = new ArrayList<>();
        allNursesOtherHospital.add(testOtherHospitalNurse);

        when(hospitalService.getNurses(testHospital1.getId()))
                .thenReturn(allNurses);

        when(hospitalService.getNurses(testHospital2.getId()))
                .thenReturn(allNursesOtherHospital);

        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testUnassignedNurse);

        // Act.
        List<Employee> output = bloodDriveService.getUnassignedNurses(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testCoordinator.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testAssignNurses_correctlyAssignsNursesOnValid() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        List<Employee> allNursesOtherHospital = new ArrayList<>();
        allNursesOtherHospital.add(testOtherHospitalNurse);

        when(hospitalService.getNurses(testHospital1.getId()))
                .thenReturn(allNurses);

        when(hospitalService.getNurses(testHospital2.getId()))
                .thenReturn(allNursesOtherHospital);

        testDrive1.getEmployees().add(testCoordinator);
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testUnassignedNurse);

        List<Long> nursesToAssign = new ArrayList<>();
        nursesToAssign.add(testAnotherNurse.getUserId());

        // Act.
        bloodDriveService.assignNurses(
                userService.getUserById(testCoordinator.getUserId()),
                testDrive1.getBloodDriveId(),
                nursesToAssign);

        // Assert.
        assertTrue(testDrive1.getEmployees().contains(testAnotherNurse));
        verify(dataFacade).createOrUpdateBloodDrive(testDrive1);
    }

    @Test(expected = Exception.class)
    public void testAssignNurses_throwsExceptionOnInvalid() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        when(hospitalService.getNurses(testHospital1.getId()))
                .thenReturn(allNurses);

        testDrive1.getEmployees().add(testCoordinator);
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testUnassignedNurse);

        List<Long> nursesToAssign = new ArrayList<>();
        nursesToAssign.add(testAssignedNurse.getUserId());

        // Act.
        bloodDriveService.assignNurses(
                userService.getUserById(testCoordinator.getUserId()),
                testDrive1.getBloodDriveId(),
                nursesToAssign);
    }

    @Test
    public void testUnassignNurses_correctlyUnassignsNurseOnValid() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        when(hospitalService.getNurses(testHospital1.getId()))
                .thenReturn(allNurses);

        testDrive1.getEmployees().add(testCoordinator);
        testDrive1.getEmployees().add(testAssignedNurse);

        List<Long> nursesToUnassign = new ArrayList<>();
        nursesToUnassign.add(testAssignedNurse.getUserId());

        // Act.
        bloodDriveService.unassignNurses(
                userService.getUserById(testCoordinator.getUserId()),
                testDrive1.getBloodDriveId(),
                nursesToUnassign);

        // Assert.
        assertFalse(testDrive1.getEmployees().contains(testAssignedNurse));
        verify(dataFacade).createOrUpdateBloodDrive(testDrive1);
    }


    @Test
    public void testGetBloodDrivesForNurse_returnsBloodDrivesOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testAssignedNurse);

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesForNurse(
                testHospital1,
                userService.getUserById(testAssignedNurse.getUserId()));

        // Assert.
        assertEquals(2, output.size());
        assertEquals(testDrive1, output.get(0));
        assertEquals(testDrive2, output.get(1));
    }

    @Test
    public void testGetBloodDrivesForNurse_doesNotReturnOtherNurseInfo() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);
        testDrive2.getEmployees().add(testAssignedNurse);

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesForNurse(
                testHospital1,
                userService.getUserById(testUnassignedNurse.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsEmptyOnNonMatch() throws Exception {

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesForNurse(
                testHospital1,
                userService.getUserById(testAssignedNurse.getUserId()));

        // Assert.
        assertEquals(0, output.size());
    }

    @Test
    public void testGetBloodDriveByNurse_returnsBloodDriveOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveByNurse(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testAssignedNurse.getUserId()));

        // Assert.
        assertEquals(testDrive1, output);
    }

    @Test
    public void testGetBloodDriveByNurse_returnsNullOnNonMatch() throws Exception {

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveByNurse(
                testDrive1.getBloodDriveId(),
                userService.getUserById(testAssignedNurse.getUserId()));

        // Assert.
        assertNull(output);
    }

    @Test
    public void testInputDonor_correctlyInputsDonorOnMatch() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);

        // Act.
        assertEquals(0, testDrive1.getNumberOfDonors());
        bloodDriveService.inputDonor(
                userService.getUserById(testAssignedNurse.getUserId()),
                testDrive1.getBloodDriveId(),
                "donor@pint.edu");

        // Assert.
        assertEquals(1, testDrive1.getNumberOfDonors());
        verify(dataFacade).createOrUpdateBloodDrive(testDrive1);
    }

    @Test(expected = ValidationException.class)
    public void testInputDonor_throwsExceptionOnUnauthorizedNurse() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);

        // Act.
        assertEquals(0, testDrive1.getNumberOfDonors());
        bloodDriveService.inputDonor(
                userService.getUserById(testUnassignedNurse.getUserId()),
                testDrive1.getBloodDriveId(),
                "donor@pint.edu");
    }

    @Test(expected = ValidationException.class)
    public void testInputDonor_throwsExceptionOnNonexistingDonor() throws Exception {

        // Arrange.
        testDrive1.getEmployees().add(testAssignedNurse);

        // Act.
        assertEquals(0, testDrive1.getNumberOfDonors());
        bloodDriveService.inputDonor(
                userService.getUserById(testAssignedNurse.getUserId()),
                testDrive1.getBloodDriveId(),
                "donor2@pint.edu");
    }

    @Test
    public void testGetBloodDriveById_returnsBloodDriveOnMatch() throws Exception {

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveById(testDrive1.getBloodDriveId());

        // Assert.
        assertEquals(testDrive1, output);
    }

    @Test
    public void testGetBloodDriveById_returnsNullOnNonMatch() throws Exception {

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveById(-1L);

        // Assert.
        assertNull(output);
    }
}