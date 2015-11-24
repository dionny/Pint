package com.pint.Presentation.Controllers;

import java.util.List;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserAuthentication;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloodDriveController {

    @RequestMapping("/api/donor/getBloodDrivesByLocation")
    @ResponseBody
    public Object getBloodDrivesByLocation(@RequestParam(value = "city", defaultValue = "miami") String city, @RequestParam(value = "state", defaultValue = "florida") String state) {
        List<BloodDrive> bloodDrives = null;
        try {
            bloodDrives = bloodDriveService.getBloodDrivesByLocation(city, state);
        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return bloodDrives;
    }

    @RequestMapping("/api/coordinator/getBloodDrives")
    @ResponseBody
    public Object getBloodDrives() {
        List<BloodDrive> bloodDrives = null;
        try {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof UserAuthentication) {
                User user = ((UserAuthentication) authentication).getDetails();
                if (user.isEmployee()) {
                    Hospital hospital = userService.getEmployeeByUserId(user.getId()).getHospitalId();
                    bloodDrives = bloodDriveService.getBloodDrivesForCoordinator(hospital, user);
                } else {
                    throw new Exception("Forbidden.");
                }
            }

        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return bloodDrives;
    }

    @Autowired
    private BloodDriveService bloodDriveService;

    @Autowired
    private UserService userService;
}
