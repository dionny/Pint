package com.pint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pint.DonorRepository;

@Controller
public class DonorController {
	@Autowired
	private DonorRepository donorRepository;
}
