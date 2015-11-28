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
    public Object getBloodDrives() throws InterruptedException {
        List<BloodDrive> bloodDrives = null;
        try {
            User user = Session.getUser();
            if (user.isCoordinator()) {
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
    public Object getBloodDriveById(@PathVariable("id") long bdId) throws InterruptedException {
        BloodDrive bd;
        List<Employee> assignedNurses;
        List<Employee> unassignedNurses;
        try {
            User user = Session.getUser();
            if (user.isCoordinator()) {
                bd = bloodDriveService.getBloodDrive(bdId, user);
                assignedNurses = bloodDriveService.getNursesForBloodDrive(bdId, user);
                unassignedNurses = bloodDriveService.getUnassignedNurses(bdId, user);
            } else {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return new BloodDriveDetailViewStrategy(assignedNurses, unassignedNurses).CreateViewModel(bd);
    }

    @RequestMapping(value = "/api/coordinator/assignNurses/{bdId}", method = RequestMethod.POST)
    @ResponseBody
    public Object assignNurses(@PathVariable("bdId") Long bdId, @RequestBody ArrayList<Integer> nurses) {
        try {
            User user = Session.getUser();
            if (user.isCoordinator()) {
                bloodDriveService.assignNurses(user, bdId,
                        Utils.toLongs(nurses));
            } else {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return bdId;
    }

    @RequestMapping(value = "/api/coordinator/unassignNurses/{bdId}", method = RequestMethod.POST)
    @ResponseBody
    public Object unassignNurses(@PathVariable("bdId") Long bdId, @RequestBody ArrayList<Integer> nurses) {
        try {
            User user = Session.getUser();
            if (user.isCoordinator()) {
                bloodDriveService.unassignNurses(user, bdId,
                        Utils.toLongs(nurses));
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
}
