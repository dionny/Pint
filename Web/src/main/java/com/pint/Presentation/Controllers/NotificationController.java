package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.NotificationService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Donor;
import com.pint.Data.Models.UserNotification;
import com.pint.Presentation.ViewStrategies.NotificationDetailViewStrategy;
import com.pint.Presentation.ViewStrategies.NotificationSummaryViewStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/api/donor/getUserNotifications")
    @ResponseBody
    public Object getUserNotification() {
        List<UserNotification> userNotifications;

        try {
            User user = Session.getUser();
            if (user.isDonor()) {
                userNotifications = notificationService.getUserNotifications(user);
            } else {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return new NotificationSummaryViewStrategy().CreateViewModel(userNotifications);
    }

    @RequestMapping("/api/donor/getBloodDriveUserNotifications/{id}")
    @ResponseBody
    public Object getUserNotifications(@PathVariable("id") Long id) {
        List<UserNotification> userNotifications;

        try {
            User user = Session.getUser();
            if (user.isDonor()) {
                userNotifications = notificationService.getUserNotifications(user, id);
            } else {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return new NotificationDetailViewStrategy().CreateViewModel(userNotifications);
    }
}
