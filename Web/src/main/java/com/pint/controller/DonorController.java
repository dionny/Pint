package com.pint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pint.repository.DonorRepository;

@Controller
public class DonorController {
	@Autowired
	private DonorRepository donorRepository;
}
