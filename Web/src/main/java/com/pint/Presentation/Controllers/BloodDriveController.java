package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import com.pint.Presentation.ViewStrategies.BloodDriveDetailViewStrategy;
import com.pint.Presentation.ViewStrategies.BloodDriveSummaryViewStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return nurses;
    }

    @RequestMapping(value = "/api/coordinator/assignNurses/{bdId}", method = RequestMethod.POST)
    @ResponseBody
    public Object assignNurses(@PathVariable("bdId") Long bdId, @RequestBody Object nurses) {
        try {
            User user = Session.getUser();
            if (user.isEmployee()) {
                LinkedHashMap<String, ArrayList<Integer>> map =
                        (LinkedHashMap<String, ArrayList<Integer>>) nurses;

                bloodDriveService.assignNurses(user, bdId,
                        Utils.toLongs(map.get("nurses")));
            } else {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return bdId;
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
