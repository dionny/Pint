package test.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Hospital;
import com.pint.Presentation.Controllers.BloodDriveController;
import com.pint.Presentation.Controllers.UserProvider;
import com.pint.Presentation.ViewModels.BloodDriveDetailNurseViewModel;
import com.pint.Presentation.ViewModels.BloodDriveSummaryViewModel;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    private java.sql.Date testDate;

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
    }

//    @Test
//    public void test
}