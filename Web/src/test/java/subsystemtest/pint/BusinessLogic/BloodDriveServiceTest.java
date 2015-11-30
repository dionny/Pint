package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BloodDriveServiceTest extends BaseIntegrationTest {

    @Before
    public void beforeTest() throws Exception {
        createTestData();
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
    public void testGetBloodDrivesByHospital_returnsBloodDrivesWhenExist() throws Exception {

        // Act.
        List<BloodDrive> output = bloodDriveService.getBloodDrivesByHospital(1L);

        // Assert.
        assertEquals(2, output.size());
        assertEquals(testDrive1, output.get(0));
        assertEquals(testDrive2, output.get(1));
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
    public void testGetUnassignedNurses_returnsCorrectUnassignedNurses() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        List<Employee> allNursesOtherHospital = new ArrayList<>();
        allNursesOtherHospital.add(testOtherHospitalNurse);

        when(dataFacade.getHospitalEmployees(testHospital1.getId()))
                .thenReturn(allNurses);

        when(dataFacade.getHospitalEmployees(testHospital2.getId()))
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
    public void testAssignNurses_correctlyAssignsNursesOnValid() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        List<Employee> allNursesOtherHospital = new ArrayList<>();
        allNursesOtherHospital.add(testOtherHospitalNurse);

        when(dataFacade.getHospitalEmployees(testHospital1.getId()))
                .thenReturn(allNurses);

        when(dataFacade.getHospitalEmployees(testHospital2.getId()))
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

    @Test
    public void testUnassignNurses_correctlyUnassignsNurseOnValid() throws Exception {

        // Arrange.
        List<Employee> allNurses = new ArrayList<>();
        allNurses.add(testAssignedNurse);
        allNurses.add(testAnotherNurse);
        allNurses.add(testUnassignedNurse);

        when(dataFacade.getHospitalEmployees(testHospital1.getId()))
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

    @Test
    public void testGetBloodDriveById_returnsBloodDriveOnMatch() throws Exception {

        // Act.
        BloodDrive output = bloodDriveService.getBloodDriveById(testDrive1.getBloodDriveId());

        // Assert.
        assertEquals(testDrive1, output);
    }
}