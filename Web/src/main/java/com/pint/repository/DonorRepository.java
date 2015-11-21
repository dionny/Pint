package com.pint.repository;

import org.springframework.data.repository.CrudRepository;

import com.pint.entity.Donor;

public interface DonorRepository extends CrudRepository<Donor, Long>{

}
