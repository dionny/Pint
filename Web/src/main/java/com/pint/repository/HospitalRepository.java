package com.pint.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.entity.Hospital;


@Repository
@Transactional
public class HospitalRepository extends com.pint.repository.Repository{
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void create(Object data) { 
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();

			currentSession.save(data);
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}


	public Hospital get(long hospitalId)  
	{
		HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
		SessionFactory sessionFactory = emFactory.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();  

		Hospital hospital = (Hospital)currentSession.get(Hospital.class, hospitalId);

		return hospital;
	}

	public List<Hospital> getHospitals(){
		List<Hospital> hospitals = null;

		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();

			SQLQuery query = currentSession.createSQLQuery(("SELECT * FROM hospital"));
			query.addEntity(Hospital.class);

			hospitals = query.list();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}

		return hospitals;
	}
}
