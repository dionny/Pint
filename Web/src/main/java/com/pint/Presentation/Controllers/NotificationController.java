package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Notification;
import com.pint.Data.Models.UserNotification;
import com.pint.Data.Repositories.BloodDriveBaseRepository;
import com.pint.Data.Repositories.NotificationRepository;
import com.pint.Data.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    private NotificationRepository notificatiionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodDriveBaseRepository bloodDriveBaseRepository;

    @RequestMapping("/usernotification")
    @ResponseBody
    public String getUserNotification(@RequestParam(value = "email") String email, @RequestParam(value = "id") long bloodDriveId) {
        String userNotification = "";
        try {
            User donor = userRepository.findByUsername(email);
            BloodDrive bloodDrive = (BloodDrive) bloodDriveBaseRepository.get(bloodDriveId, new BloodDrive());

            if (donor == null) System.out.println("\n\n\nDonor not found \n\n\n");
            else System.out.println("\n\n\nDonor found\n\n\n");

            if (bloodDrive == null) System.out.println("\n\n\n BD not found \n\n\n");
            else System.out.println("\n\n\n BD found\n\n\n");

            List<UserNotification> userNotificationList = notificatiionRepository.getUserNotifications(donor, bloodDrive);

            for (Iterator<UserNotification> iter = userNotificationList.iterator(); iter.hasNext(); ) {
                UserNotification notification = (UserNotification) iter.next();
                userNotification += notification.getContent() + "\n\n";
            }
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }

        return userNotification;
    }

    @RequestMapping("/usernotification2")
    @ResponseBody
    public String getUserNotification(@RequestParam(value = "email") String email) {
        String userNotification = "";
        try {
            User donor = userRepository.findByUsername(email);

            if (donor == null) System.out.println("\n\n\nDonor not found \n\n\n");
            else System.out.println("\n\n\nDonor found\n\n\n");

            List<UserNotification> userNotificationList = notificatiionRepository.getUserNotifications(donor);

            for (Iterator<UserNotification> iter = userNotificationList.iterator(); iter.hasNext(); ) {
                UserNotification notification = (UserNotification) iter.next();
                userNotification += notification.getContent() + "\n\n";
            }
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }

        return userNotification;
    }

    @RequestMapping("/notification_by_drive")
    @ResponseBody
    public String getUserNotification(@RequestParam(value = "driveid") long bloodDriveId) {
        String notificationStr = "";
        try {

            BloodDrive bloodDrive = (BloodDrive) bloodDriveBaseRepository.get(bloodDriveId, new BloodDrive());
            List<Notification> notificationList = notificatiionRepository.getNotifications(bloodDrive);

            for (Iterator<Notification> iter = notificationList.iterator(); iter.hasNext(); ) {
                Notification notification = (Notification) iter.next();
                notificationStr += notification.getContent() + "\n\n";
            }
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }

        return notificationStr;
    }
}
