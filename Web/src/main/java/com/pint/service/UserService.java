package com.pint.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.pint.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.entity.Employee;

@Repository
@Transactional
public class UserService {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public boolean createEmployee(Employee employee){
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();

			currentSession.save(employee);
			
			return true;
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public List<Employee> getAllNurses(Long hospitalId){
		List<Employee> nurses = null;

		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();

			String sql = "SELECT * FROM EMPLOYEE WHERE hospital_id = :hospital_id";
			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(Employee.class);			
			query.setParameter("hospital_id", hospitalId);

			nurses = query.list();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		return nurses;
	}
}
