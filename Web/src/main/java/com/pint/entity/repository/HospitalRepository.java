package com.pint.entity.repository;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.entity.Hospital;


@Repository
@Transactional
public class HospitalRepository{
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Hospital get(long hospitalId)  
	{
		HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
		SessionFactory sessionFactory = emFactory.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();  

		Hospital hospital = (Hospital)currentSession.get(Hospital.class, hospitalId); 

		return hospital;
	} 
}
