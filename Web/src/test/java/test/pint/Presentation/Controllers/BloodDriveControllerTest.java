package test.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.BusinessLogic.Validators.ValidationException;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import com.pint.Presentation.Controllers.BloodDriveController;
import com.pint.Presentation.Controllers.UserProvider;
import com.pint.Presentation.ViewModels.BloodDriveDetailCoordinatorViewModel;
import com.pint.Presentation.ViewModels.BloodDriveDetailNurseViewModel;
import com.pint.Presentation.ViewModels.BloodDriveSummaryViewModel;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BloodDriveControllerTest {

    private BloodDriveController bloodDriveController;

    private UserService userService;
    private BloodDriveService bloodDriveService;
    private UserProvider userProvider;

    private Hospital testHospital;
    private BloodDrive testDrive1;
    private BloodDrive testDrive2;
    private User testUser;
    private Employee testEmployee;
    private java.sql.Date testDate;
    private Employee testAssignedNurse;
    private Employee testUnassignedNurse;

    @Before
    public void beforeTest() throws Exception {
        userService = mock(UserService.class);
        bloodDriveService = mock(BloodDriveService.class);
        userProvider = mock(UserProvider.class);

        bloodDriveController = new BloodDriveController(bloodDriveService, userService, userProvider);

        testDate = Utils.sqlDate(DateTime.now());

        testHospital = new Hospital("Test Hospital");

        testDrive1 = new BloodDrive(
                1, "Test Drive 1", "Description 1", testDate, testDate, "Address 1", 0, "City 1", "State 1", 1, testHospital);

        testDrive2 = new BloodDrive(
                2, "Test Drive 2", "Description 2", testDate, testDate, "Address 2", 0, "City 2", "State 2", 1, testHospital);

        testUser = new User();
        testUser.setId(1L);
        testEmployee = new Employee();
        testEmployee.setHospitalId(testHospital);

        when(userService.getEmployeeByUserId(1L))
                .thenReturn(testEmployee);

        when(userProvider.getUser())
                .thenReturn(testUser);

        testAssignedNurse = new Employee(5L);
        testUnassignedNurse = new Employee(6L);
    }

    @Test
    public void testGetBloodDrivesByLocation_returnsBloodDrivesOnSuccess() throws Exception {

        // Arrange.
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);

        when(bloodDriveService.getBloodDrivesByLocation(anyString(), anyString()))
                .thenReturn(bloodDrives);

        // Act.
        List<BloodDriveSummaryViewModel> output =
                (List<BloodDriveSummaryViewModel>)
                        bloodDriveController.getBloodDrivesByLocation("Miami", "FL");

        // Assert.
        assertEquals(2, output.size());
        assertEquals("Test Drive 1", output.get(0).title);
        assertEquals("Description 1", output.get(0).description);
        assertEquals(testDate, output.get(0).startTime);
        assertEquals(testDate, output.get(0).endTime);
        assertEquals("Address 1", output.get(0).address);
        assertEquals(1, output.get(0).bloodDriveId);
    }

    @Test
    public void testGetBloodDrivesByLocation_returnsBadRequestOnError() throws Exception {

        // Arrange.
        when(bloodDriveService.getBloodDrivesByLocation(anyString(), anyString()))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDrivesByLocation("Miami", "FL");

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDriveById_returnsBloodDriveOnSuccess() throws Exception {

        // Arrange.
        when(bloodDriveService.getBloodDriveById(anyLong()))
                .thenReturn(testDrive1);

        // Act.
        BloodDriveDetailNurseViewModel output =
                (BloodDriveDetailNurseViewModel)
                        bloodDriveController.getBloodDriveByIdForDonor(1L);

        // Assert.
        assertEquals("Test Drive 1", output.title);
        assertEquals("Description 1", output.description);
        assertEquals(testDate, output.startTime);
        assertEquals(testDate, output.endTime);
        assertEquals("Address 1", output.address);
        assertEquals(1, output.bloodDriveId);
        assertEquals(0, output.numberOfDonors);
    }

    @Test
    public void testGetBloodDriveById_returnsBadRequestOnError() throws Exception {

        // Arrange.
        when(bloodDriveService.getBloodDriveById(anyLong()))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDriveByIdForDonor(1L);

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDrives_returnsBloodDrivesOnSuccess() throws Exception {
        // Arrange.
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);

        testUser.grantRole(UserRole.COORDINATOR);

        when(bloodDriveService.getBloodDrivesForCoordinator(any(Hospital.class), any(User.class)))
                .thenReturn(bloodDrives);

        // Act.
        List<BloodDriveSummaryViewModel> output =
                (List<BloodDriveSummaryViewModel>)
                        bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(2, output.size());
        assertEquals("Test Drive 1", output.get(0).title);
        assertEquals("Description 1", output.get(0).description);
        assertEquals(testDate, output.get(0).startTime);
        assertEquals(testDate, output.get(0).endTime);
        assertEquals("Address 1", output.get(0).address);
        assertEquals(1, output.get(0).bloodDriveId);
    }

    @Test
    public void testGetBloodDrives_returnsUnauthorizedForNurse() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.NURSE);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrives_returnsUnauthorizedForManager() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.MANAGER);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrives_returnsUnauthorizedForDonor() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.DONOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrives_returnsBadRequestOnUserServiceError() throws Exception {

        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);
        when(userService.getEmployeeByUserId(anyLong()))
                .thenThrow(new RuntimeException());
        when(bloodDriveService.getBloodDrivesForCoordinator(any(Hospital.class), any(User.class)))
                .thenReturn(bloodDrives);

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDrives_returnsBadRequestOnBloodDriveServiceError() throws Exception {

        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);
        when(bloodDriveService.getBloodDrivesForCoordinator(any(Hospital.class), any(User.class)))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDrives();

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsBloodDrivesOnSuccess() throws Exception {
        // Arrange.
        List<BloodDrive> bloodDrives = new ArrayList<>();
        bloodDrives.add(testDrive1);
        bloodDrives.add(testDrive2);

        testUser.grantRole(UserRole.NURSE);

        when(bloodDriveService.getBloodDrivesForNurse(any(Hospital.class), any(User.class)))
                .thenReturn(bloodDrives);

        // Act.
        List<BloodDriveSummaryViewModel> output =
                (List<BloodDriveSummaryViewModel>)
                        bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(2, output.size());
        assertEquals("Test Drive 1", output.get(0).title);
        assertEquals("Description 1", output.get(0).description);
        assertEquals(testDate, output.get(0).startTime);
        assertEquals(testDate, output.get(0).endTime);
        assertEquals("Address 1", output.get(0).address);
        assertEquals(1, output.get(0).bloodDriveId);
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsUnauthorizedForCoordinator() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsUnauthorizedForManager() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.MANAGER);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsUnauthorizedForDonor() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.DONOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsBadRequestOnUserServiceError() throws Exception {

        // Arrange.
        testUser.grantRole(UserRole.NURSE);
        when(userService.getEmployeeByUserId(anyLong()))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDrivesForNurse_returnsBadRequestOnBloodDriveServiceError() throws Exception {

        // Arrange.
        testUser.grantRole(UserRole.NURSE);
        when(bloodDriveService.getBloodDrivesForNurse(any(Hospital.class), any(User.class)))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDrivesForNurse();

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetBloodDriveByIdForCoordinator_returnsBloodDriveOnSuccess() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);

        List<Employee> assignedNurses = new ArrayList<>();
        assignedNurses.add(testAssignedNurse);
        assignedNurses.add(testAssignedNurse);

        List<Employee> unassignedNurses = new ArrayList<>();
        unassignedNurses.add(testUnassignedNurse);
        unassignedNurses.add(testUnassignedNurse);

        when(bloodDriveService.getBloodDriveByCoordinator(1L, testUser))
                .thenReturn(testDrive1);

        when(bloodDriveService.getNursesForBloodDrive(1L, testUser))
                .thenReturn(assignedNurses);

        when(bloodDriveService.getUnassignedNurses(1L, testUser))
                .thenReturn(unassignedNurses);

        // Act.
        BloodDriveDetailCoordinatorViewModel output =
                (BloodDriveDetailCoordinatorViewModel)
                        bloodDriveController.getBloodDriveByIdForCoordinator(1L);

        // Assert.
        assertEquals("Test Drive 1", output.title);
        assertEquals("Description 1", output.description);
        assertEquals(testDate, output.startTime);
        assertEquals(testDate, output.endTime);
        assertEquals("Address 1", output.address);
        assertEquals(1, output.bloodDriveId);
        assertEquals(assignedNurses, output.assignedNurses);
        assertEquals(unassignedNurses, output.unassignedNurses);
    }

    @Test
    public void testGetBloodDriveByIdForCoordinator_returnsUnauthorizedForNurse() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.NURSE);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDriveByIdForCoordinator(1L);

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDriveByIdForCoordinator_returnsUnauthorizedForManager() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.MANAGER);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDriveByIdForCoordinator(1L);

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDriveByIdForCoordinators_returnsUnauthorizedForDonor() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.DONOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.getBloodDriveByIdForCoordinator(1L);

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testGetBloodDriveByIdForCoordinators_returnsBadRequestOnError() throws Exception {

        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);
        when(bloodDriveService.getBloodDriveByCoordinator(anyLong(), any(User.class)))
                .thenThrow(new RuntimeException());

        // Act.
        ResponseEntity response = (ResponseEntity) bloodDriveController.getBloodDriveByIdForCoordinator(1L);

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }


    @Test
    public void testInputDonor_delegatesToBloodDriveServiceWhenAuthorized() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.NURSE);

        // Act.
        Long id = (Long)bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        verify(bloodDriveService).inputDonor(testUser, 1L, "test@pint.edu");
        assertEquals(1, (long)id);
    }

    @Test
    public void testInputDonor_returnsUnauthorizedForCoordinator() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.COORDINATOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testInputDonor_returnsUnauthorizedForManager() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.MANAGER);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testInputDonor_returnsUnauthorizedForDonor() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.DONOR);

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        assertEquals(HttpStatus.UNAUTHORIZED, output.getStatusCode());
    }

    @Test
    public void testInputDonor_returnsMessageOnValidationException() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.NURSE);

        Mockito.doThrow(new ValidationException("Test Validation Error"))
                .when(bloodDriveService).inputDonor(testUser, 1L, "test@pint.edu");

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, output.getStatusCode());
        assertEquals("Test Validation Error", output.getBody());
    }

    @Test
    public void testInputDonor_returnsBadRequestOnError() throws Exception {
        // Arrange.
        testUser.grantRole(UserRole.NURSE);

        Mockito.doThrow(new RuntimeException("Test Validation Error"))
                .when(bloodDriveService).inputDonor(testUser, 1L, "test@pint.edu");

        // Act.
        ResponseEntity output = (ResponseEntity) bloodDriveController.inputDonor(1L, "test@pint.edu");

        // Assert.
        assertEquals(HttpStatus.BAD_REQUEST, output.getStatusCode());
        assertNull(output.getBody());
    }
}