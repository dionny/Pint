package com.pint.security;

import java.util.List;

import com.pint.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.entity.Donor;
import com.pint.entity.Employee;
import com.pint.utils.Constants;


@Repository
@Transactional
public class UserService extends BaseRepository {
	public Donor get(String email){
		Donor donor = null;
		
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();

			String sql = "SELECT * FROM " + Constants.DONOR_TABLE_NAME + " WHERE email_address = '" + email + "'";
			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(Donor.class);

			List<Donor> donors = query.list();
			
			if (donors != null && donors.size() > 0)
				donor = donors.get(0);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return donor;
	}

	public void createEmployee(Employee employee){
		create(employee);
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
