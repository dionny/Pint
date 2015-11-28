package com.pint.BusinessLogic.Validators;

import com.pint.BusinessLogic.Security.User;
import com.pint.Data.Models.Employee;
import com.pint.Presentation.Controllers.Session;

/**
 * Created by Dionny on 11/27/2015.
 */
public class CreateEmployeeValidator extends Validator {
    private final Iterable<User> users;
    private final User user;
    private final Employee employee;

    public CreateEmployeeValidator(Iterable<User> users, User user, Employee employee) {
        this.users = users;
        this.user = user;
        this.employee = employee;
    }

    @Override
    protected boolean validObject() {
        // The password must be at least length 5.
        if (employee.getPassword().length() < 5) {
            error = "The password must have at least 5 characters.";
            return false;
        }

        // The user name must not be taken.
        for (User u :
                users) {
            if (u.getUsername().equals(user.getUsername())) {
                error = "The username is taken. Please select another username.";
                return false;
            }
        }

        return true;
    }

    @Override
    protected boolean validPermissions() {
        try {
            return Session.getUser().isManager();
        } catch (Exception e) {
            return false;
        }
    }
}
