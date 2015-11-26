package com.pint.Presentation.Controllers;

import java.util.List;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserAuthentication;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    @RequestMapping("/api/coordinator/getBloodDriveById/{id}")
    @ResponseBody
    public Object getBloodDriveById(@PathVariable("id") long bdId) {
        BloodDrive bd = null;
        try {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof UserAuthentication) {
                User user = ((UserAuthentication) authentication).getDetails();
                if (user.isEmployee()) {
                  
                    bd = bloodDriveService.getBloodDrive(bdId, user);
                } else {
                    throw new Exception("Forbidden.");
                }
            }

        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return bd;
    }
    
    @RequestMapping("/api/coordinator/getNursesForBloodDrive")
    @ResponseBody
    public Object getNursesForBloodDrive(@PathVariable("bd") BloodDrive bd) {
    	List<Employee> nurses = null;
        try {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof UserAuthentication) {
                User user = ((UserAuthentication) authentication).getDetails();
                if (user.isEmployee()) {
                  
                    nurses = bloodDriveService.getNursesForBloodDrive(bd, user);
                } else {
                    throw new Exception("Forbidden.");
                }
            }

        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return nurses;
    }
    
    @RequestMapping("/api/coordinator/getNursesForBloodDrive")
    @ResponseBody
    public Object getUnassignedNurses(@PathVariable("bd") BloodDrive bd) {
    	List<Employee> nurses = null;
        try {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof UserAuthentication) {
                User user = ((UserAuthentication) authentication).getDetails();
                if (user.isEmployee()) {
                  
                    nurses = bloodDriveService.getUnassignedNurses( bd,user);
                } else {
                    throw new Exception("Forbidden.");
                }
            }

        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return nurses;
    }
    @Autowired
    private BloodDriveService bloodDriveService;

    @Autowired
    private UserService userService;
}
