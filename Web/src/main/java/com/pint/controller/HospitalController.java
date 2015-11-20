package com.pint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pint.entity.Hospital;
import com.pint.entity.repository.HospitalRepository;


@Controller
public class HospitalController {
    /*@RequestMapping("/createhospital")
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
    }*/
    
    @RequestMapping("hospital")
    @ResponseBody
    public String getHospital(@RequestParam(value="id", defaultValue="1") long hospitalId){
    	Hospital hospital = null;
        try {
        	hospital = hospitalRepository.get(hospitalId);
        }
        catch (Exception ex) {
        	return "Error creating the user: " + ex.toString();
        }
        
        return "Returned hospital succesfully! (name = " + hospital.getName() + ")";
    }
    
    @Autowired
    private HospitalRepository hospitalRepository;
}
