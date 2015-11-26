package com.pint.BusinessLogic.Services;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Dionny on 11/24/2015.
 */
@Service
public class BloodDriveService {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFacade dataFacade;

    public Employee getCoordinator(BloodDrive bd) {
        Set<Employee> employees = bd.getEmployees();
        for (Employee ee :
                employees) {
            User user = userService.getUserById(ee.getUserId());
            if (user.hasRole(UserRole.COORDINATOR)) {
                return ee;
            }
        }
        return null;
    }

    private void setCoordinator(BloodDrive bd, Employee coordinator) {
        Set<Employee> employees = bd.getEmployees();

        // First remove the existing coordinator.
        Employee existing = null;
        for (Employee ee :
                employees) {
            User user = userService.getUserById(ee.getUserId());
            if (user.hasRole(UserRole.COORDINATOR)) {
                existing = ee;
            }
        }

        if (existing != null) {
            employees.remove(existing);
        }

        // Then add the new coordinator.
        employees.add(coordinator);
    }

    public List<BloodDrive> getBloodDrivesByLocation(String city, String state) {
        return dataFacade.getBloodDrivesByLocation(city, state);
    }

    public List<BloodDrive> getBloodDrivesForCoordinator(Hospital hospital, User user) {
        List<BloodDrive> output = new ArrayList<>();
        Iterable<BloodDrive> bloodDrives = dataFacade.getBloodDrives();
        for (BloodDrive bloodDrive :
                bloodDrives) {
            if (bloodDrive.getHospitalId().getId() == hospital.getId() &&
                    getCoordinator(bloodDrive).getUserId() == user.getId()) {
                output.add(bloodDrive);
            }
        }

        return output;
    }

    public BloodDrive createBloodDrive(Hospital hospital,
                                       String title,
                                       String address,
                                       String description,
                                       String city,
                                       String state,
                                       Date from,
                                       Date to,
                                       Employee coordinator) {

        BloodDrive bloodDrive = new BloodDrive();
        bloodDrive.setTitle(title);
        bloodDrive.setAddress(address);
        bloodDrive.setDescription(description);
        bloodDrive.setStartTime(from);
        bloodDrive.setEndTime(to);
        bloodDrive.setCity(city);
        bloodDrive.setState(state);
        bloodDrive.setHospitalId(hospital);

        setCoordinator(bloodDrive, coordinator);

        dataFacade.createOrUpdateBloodDrive(bloodDrive);

        return bloodDrive;
    }

    public BloodDrive getBloodDrive(long bdId, User user) {
        BloodDrive bd = dataFacade.getBloodDrivesById(bdId);
        if (getCoordinator(bd).getUserId() == user.getId()) {
            return bd;
        }
        return null;
    }


    public List<Employee> getNursesForBloodDrive(BloodDrive bd, User user) {
        List<Employee> output = new ArrayList<>();
        if (getCoordinator(bd).getUserId() == user.getId()) {
            Set<Employee> employees = bd.getEmployees();
            for (Employee ee :
                    employees) {
                User eeUser = userService.getUserById(ee.getUserId());
                if (eeUser.hasRole(UserRole.NURSE)) {
                    output.add(ee);
                }
            }
        }

        return output;
    }

    public List<Employee> getUnassignedNurses(BloodDrive bd, User user) {
        List<Employee> allNurses = userService.getNurses(bd.getHospitalId().getId());
        if (getCoordinator(bd).getUserId() == user.getId()) {
            Set<Employee> employees = bd.getEmployees();
            for (Employee ee :
                    employees) {
                User eeUser = userService.getUserById(ee.getUserId());
                if (eeUser.hasRole(UserRole.NURSE)) {
                    allNurses.remove(ee);
                }
            }
        }

        return allNurses;
    }
}
