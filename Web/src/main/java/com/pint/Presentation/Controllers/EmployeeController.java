package com.pint.Presentation.Controllers;

import com.pint.BusinessLogic.Security.UserHelper;
import com.pint.Data.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private UserHelper userHelper;


    @RequestMapping("/nurses")
    @ResponseBody
    public String getNurses(Long hospitalId) {
        String nurses = "";
        try {
            List<Employee> nurseList = userHelper.getAllEmployees(hospitalId);
            if (nurseList != null) {
                for (int i = 0; i < nurseList.size(); i++) {
                    nurses += " " + nurseList.get(i).getFirstName();
                }
            }
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return nurses;
    }
}
