package subsystemtest.pint.BusinessLogic;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Notification;
import com.pint.Data.Models.UserNotification;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DionnyS on 11/29/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest extends BaseIntegrationTest {

    @Before
    public void beforeTest() throws Exception {
        createTestData();
    }

    private Notification createNotification(BloodDrive drive,
                                            Date sentTime,
                                            String title,
                                            String shortDescription,
                                            String longDescription) {
        Notification notification = new Notification();
        notification.setBloodDrive(drive);
        notification.setTitle(title);
        notification.setShortDescription(shortDescription);
        notification.setSentTime(new Timestamp(sentTime.getTime()));
        notification.setLongDescription(longDescription);
        return notification;
    }

    @Test
    public void testCreateNotification_createsNotification() throws Exception {

        // Arrange.
        java.sql.Date sentTime = Utils.sqlDate(DateTime.now());

        // Act.
        Notification output = notificationService.createNotification(
                testDrive1,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        // Assert.
        assertEquals("Title", output.getTitle());
        assertEquals("Short Description", output.getShortDescription());
        assertEquals("Long Description", output.getLongDescription());
        assertEquals(sentTime, output.getSentTime());
        verify(dataFacade).createNotification(output);
    }

    @Test
    public void testCreateUserNotification_createsUserNotification() throws Exception {

        // Arrange.
        java.sql.Date sentTime = Utils.sqlDate(DateTime.now());

        Notification notification = createNotification(
                testDrive1,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        // Act.
        UserNotification output =
                notificationService.createUserNotification(notification, testDonor);

        // Assert.
        assertEquals(notification, output.getNotification());
        assertEquals(testDonor, output.getDonor());
        verify(dataFacade).createUserNotification(output);
    }

    @Test
    public void testGetUserNotifications_givenUser_returnsAllUserNotificationsAcrossBloodDrives() throws Exception {

        // Arrange.
        java.sql.Date sentTime = Utils.sqlDate(DateTime.now());

        Notification notification = createNotification(
                testDrive1,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        UserNotification userNotification1 = new UserNotification();
        userNotification1.setNotification(notification);
        userNotification1.setDonor(testDonor);

        UserNotification userNotification2 = new UserNotification();
        userNotification2.setNotification(notification);
        userNotification2.setDonor(testDonor);

        Notification notification2 = createNotification(
                testDrive2,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        UserNotification userNotification3 = new UserNotification();
        userNotification3.setNotification(notification2);
        userNotification3.setDonor(testDonor);

        UserNotification userNotification4 = new UserNotification();
        userNotification4.setNotification(notification2);
        userNotification4.setDonor(testDonor);

        List<UserNotification> userNotifications = new ArrayList<>();
        userNotifications.add(userNotification1);
        userNotifications.add(userNotification2);
        userNotifications.add(userNotification3);
        userNotifications.add(userNotification4);

        User user = userService.getUserById(testDonor.getUserId());
        when(dataFacade.getUserNotifications(user))
                .thenReturn(userNotifications);

        // Act.
        List<UserNotification> output =
                notificationService.getUserNotifications(user);

        // Assert.
        assertEquals(4, output.size());
        assertEquals(userNotification1, output.get(0));
        assertEquals(userNotification2, output.get(1));
        assertEquals(userNotification3, output.get(2));
        assertEquals(userNotification4, output.get(3));
        verify(dataFacade).getUserNotifications(user);
    }

    @Test
    public void testGetUserNotifications_givenUserAndBloodDrive_returnsUserNotificationsForDrive() throws Exception {

        // Arrange.
        java.sql.Date sentTime = Utils.sqlDate(DateTime.now());

        Notification notification = createNotification(
                testDrive1,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        UserNotification userNotification1 = new UserNotification();
        userNotification1.setNotification(notification);
        userNotification1.setDonor(testDonor);

        UserNotification userNotification2 = new UserNotification();
        userNotification2.setNotification(notification);
        userNotification2.setDonor(testDonor);

        Notification notification2 = createNotification(
                testDrive2,
                sentTime,
                "Title",
                "Short Description",
                "Long Description");

        UserNotification userNotification3 = new UserNotification();
        userNotification3.setNotification(notification2);
        userNotification3.setDonor(testDonor);

        UserNotification userNotification4 = new UserNotification();
        userNotification4.setNotification(notification2);
        userNotification4.setDonor(testDonor);

        List<UserNotification> userNotifications = new ArrayList<>();
        userNotifications.add(userNotification1);
        userNotifications.add(userNotification2);
        userNotifications.add(userNotification3);
        userNotifications.add(userNotification4);

        User user = userService.getUserById(testDonor.getUserId());
        when(dataFacade.getUserNotifications(user))
                .thenReturn(userNotifications);

        // Act.
        List<UserNotification> output =
                notificationService.getUserNotifications(user, testDrive1.getBloodDriveId());

        // Assert.
        assertEquals(2, output.size());
        assertEquals(userNotification1, output.get(0));
        assertEquals(userNotification2, output.get(1));
        verify(dataFacade).getUserNotifications(user);
    }
}
