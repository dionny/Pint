package com.pint.controller;

import java.util.Iterator;
import java.util.List;

import com.pint.entity.BloodDrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pint.repository.BloodDriveRepository;

@Controller
public class BloodDriveController {

	@RequestMapping("/blooddrive")
	@ResponseBody
	public String getBloodDrivesByLocation(@RequestParam(value="city", defaultValue="miami") String city,@RequestParam(value="state", defaultValue="florida") String state){
		List<BloodDrive> blooddrive = null;
		String blooddrives="";
		try {
			blooddrive = bloodDriveRepository.getBloodDrivesByLocation(city,state);
			for (Iterator<BloodDrive> iter = blooddrive.iterator(); iter.hasNext();)
			{
				BloodDrive bd=(BloodDrive) iter.next();
				blooddrives += bd.getTitle();
			}	
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}

		return "Returned Blood Drives succesfully! (name = " + blooddrives + ")";
	}

	@Autowired
	private BloodDriveRepository bloodDriveRepository;
}
