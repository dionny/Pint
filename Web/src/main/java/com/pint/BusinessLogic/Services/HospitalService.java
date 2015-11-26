package com.pint.BusinessLogic.Services;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dionny on 11/24/2015.
 */
@Service
public class HospitalService {

    @Autowired
    private DataFacade dataFacade;

    @Autowired
    private UserService userService;

    public Hospital createHospital(String hospital) {
        return dataFacade.createHospital(hospital);
    }

    public Iterable<Employee> getEmployees(Long id) {
        return dataFacade.getHospitalEmployees(id);
    }

    public List<Employee> getNurses(Long id) {
        Iterable<Employee> employees = getEmployees(id);
        List<Employee> output = new ArrayList<>();
        for (Employee employee :
                employees) {
            User eeUser = userService.getUserById(employee.getUserId());
            if (eeUser.hasRole(UserRole.NURSE)) {
                employee.setEmail(eeUser.getUsername());
                output.add(employee);
            }
        }
        return output;
    }
}
