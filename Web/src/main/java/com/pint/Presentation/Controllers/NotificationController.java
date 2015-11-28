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
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository notificatiionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodDriveBaseRepository bloodDriveBaseRepository;

//    @RequestMapping("/api/donor/")
//    @ResponseBody
//    public String getUserNotification(@RequestParam(value = "email") String email, @RequestParam(value = "id") long bloodDriveId) {
//        String userNotification = "";
//        try {
//            User donor = userRepository.findByUsername(email);
//            BloodDrive bloodDrive = (BloodDrive) bloodDriveBaseRepository.get(bloodDriveId, new BloodDrive());
//
//            if (donor == null) System.out.println("\n\n\nDonor not found \n\n\n");
//            else System.out.println("\n\n\nDonor found\n\n\n");
//
//            if (bloodDrive == null) System.out.println("\n\n\n BD not found \n\n\n");
//            else System.out.println("\n\n\n BD found\n\n\n");
//
//            List<UserNotification> userNotificationList = notificatiionRepository.getUserNotifications(donor, bloodDrive);
//
//            for (Iterator<UserNotification> iter = userNotificationList.iterator(); iter.hasNext(); ) {
//                UserNotification notification = (UserNotification) iter.next();
//                userNotification += notification.getContent() + "\n\n";
//            }
//        } catch (Exception ex) {
//            return "Error creating the user: " + ex.toString();
//        }
//
//        return userNotification;
//    }

    @RequestMapping("/api/donor/getUserNotifications/{id}")
    @ResponseBody
    public Object getUserNotification(@PathVariable("id") Long id) {
        List<UserNotification> userNotifications;
        try {
            User donor = userRepository.findOne(id);

            if (donor == null) System.out.println("\n\n\nDonor not found \n\n\n");
            else System.out.println("\n\n\nDonor found\n\n\n");

            userNotifications = notificatiionRepository.getUserNotifications(donor);

        } catch (Exception ex) {
            return "Error getting notifications: " + ex.toString();
        }

        return userNotifications;
    }

    @RequestMapping("/api/donor/getBloodDriveUserNotifications/{id}")
    @ResponseBody
    public Object getUserNotifications(@PathVariable("id") Long id) {
        List<Notification> notifications;
        try {
            BloodDrive bloodDrive = (BloodDrive) bloodDriveBaseRepository.get(id, new BloodDrive());
            notifications = notificatiionRepository.getNotifications(bloodDrive);

        } catch (Exception ex) {
            return "Error getting notifications: " + ex.toString();
        }

        return notifications;
    }
}
