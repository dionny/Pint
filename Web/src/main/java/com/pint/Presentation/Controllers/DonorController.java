package com.pint.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pint.Data.Repositories.DonorRepository;

@Controller
public class DonorController {
	@Autowired
	private DonorRepository donorRepository;
}
