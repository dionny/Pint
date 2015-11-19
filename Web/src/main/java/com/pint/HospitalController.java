package com.pint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HospitalController {
    @RequestMapping("/createhospital")
    @ResponseBody
    public String createHospital(@RequestParam(value="name", defaultValue="test_hosptial") String hospitalName) {
    	Hospital hospital = null;
        try {
        	hospital = new Hospital(hospitalName);
        	hospitalDao.save(hospital);
        }
        catch (Exception ex) {
        	return "Error creating the user: " + ex.toString();
        }
        
        return "User succesfully created! (id = " + hospital.getId() + ")";
    }
    
    @Autowired
    private HospitalDao hospitalDao;
}
