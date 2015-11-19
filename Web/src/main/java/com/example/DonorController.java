package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DonorController {
	@Autowired
	private DonorDao donorDao;
}
