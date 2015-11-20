package com.pint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pint.entity.repository.DonorDao;

@Controller
public class DonorController {
	@Autowired
	private DonorDao donorDao;
}
