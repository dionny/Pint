package com.pint.BusinessLogic.Services;

import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.Data.DataFacade;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dionny on 11/24/2015.
 */
@Service
public class UserService {

    @Autowired
    private DataFacade dataFacade;

    public Employee createEmployee(String email,
                                   String password,
                                   String firstName,
                                   String lastName,
                                   String phoneNo,
                                   UserRole role,
                                   Long hospitalId) {

        User user = new User();
        user.setUsername(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.grantRole(role);

        dataFacade.createOrUpdateUser(user);

        Hospital hospital = dataFacade.getHospitalById(hospitalId);

        Employee employee = new Employee(firstName, lastName, phoneNo, hospital);
        employee.setUserId(user.getId());

        dataFacade.createEmployee(employee);

        return employee;
    }

    public User getUserByEmail(String email) {
        return dataFacade.getUserByEmail(email);
    }

    public List<Employee> getNurses(long hospitalId) {
        return dataFacade.getNurses(hospitalId);
    }

    public void deleteUser(String username) {
        dataFacade.deleteUser(username);
    }

    public User updateUser(long id, String email, String name) {
        User user = dataFacade.getUserById(id);
        user.setUsername(email);
        dataFacade.createOrUpdateUser(user);
        return user;
    }

    public Employee getEmployeeByUserId(Long id) {
        return dataFacade.getEmployeeById(id);
    }

    public void updateUser(User currentUser) {
        dataFacade.createOrUpdateUser(currentUser);
    }

    public Iterable<User> getAllUsers() {
        return dataFacade.getAllUsers();
    }

    public void createUser(String username, String password, UserRole role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.grantRole(role);
        dataFacade.createOrUpdateUser(user);
    }
}
