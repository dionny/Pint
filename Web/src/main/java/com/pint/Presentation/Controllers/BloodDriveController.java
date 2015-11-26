package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import com.pint.Presentation.ViewStrategies.BloodDriveDetailViewStrategy;
import com.pint.Presentation.ViewStrategies.BloodDriveSummaryViewStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            User user = Session.getUser();
            if (user.isEmployee()) {
                Hospital hospital = userService.getEmployeeByUserId(user.getId()).getHospitalId();
                bloodDrives = bloodDriveService.getBloodDrivesForCoordinator(hospital, user);
            } else {
                throw new Exception("Forbidden.");
            }
        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return summaryViewStrategy.CreateViewModel(bloodDrives);
    }

    @RequestMapping("/api/coordinator/getBloodDriveById/{id}")
    @ResponseBody
    public Object getBloodDriveById(@PathVariable("id") long bdId) {
        BloodDrive bd;
        try {
            User user = Session.getUser();
            if (user.isEmployee()) {
                bd = bloodDriveService.getBloodDrive(bdId, user);
            } else {
                throw new Exception("Forbidden.");
            }
        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return detailViewStrategy.CreateViewModel(bd);
    }

    @RequestMapping("/api/coordinator/getNursesForBloodDrive/{id}")
    @ResponseBody
    public Object getNursesForBloodDrive(@PathVariable("id") Long bdId) {
        List<Employee> nurses = null;
        try {
            User user = Session.getUser();
            if (user.isEmployee()) {
                nurses = bloodDriveService.getNursesForBloodDrive(bdId, user);
            } else {
                throw new Exception("Forbidden.");
            }
        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return nurses;
    }

    @RequestMapping("/api/coordinator/getUnassignedNursesForBloodDrive/{id}")
    @ResponseBody
    public Object getUnassignedNurses(@PathVariable("id") Long bdId) {
        List<Employee> nurses = null;
        try {
            User user = Session.getUser();
            if (user.isEmployee()) {
                nurses = bloodDriveService.getUnassignedNurses(bdId, user);
            } else {
                throw new Exception("Forbidden.");
            }
        } catch (Exception ex) {
            return "Error retrieving blood drives: " + ex.toString();
        }

        return nurses;
    }

    @RequestMapping(value="/api/coordinator/assignNurses/{bdId}", method=RequestMethod.POST)
    @ResponseBody
    public Object assignNurses(@PathVariable("bdId") Long bdId, List<Long> nurses) {
//        List<Employee> nurses = null;
//        try {
//            User user = Session.getUser();
//            if (user.isEmployee()) {
//                nurses = bloodDriveService.getUnassignedNurses(bdId, user);
//            } else {
//                throw new Exception("Forbidden.");
//            }
//        } catch (Exception ex) {
//            return "Error retrieving blood drives: " + ex.toString();
//        }
//
//        return nurses;

        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    @Autowired
    private BloodDriveService bloodDriveService;

    @Autowired
    private UserService userService;

    @Autowired
    private BloodDriveSummaryViewStrategy summaryViewStrategy;

    @Autowired
    private BloodDriveDetailViewStrategy detailViewStrategy;
}
