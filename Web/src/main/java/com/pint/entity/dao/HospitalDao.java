package com.pint.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.pint.entity.Hospital;

public interface HospitalDao extends CrudRepository<Hospital, Long>{
	
}
