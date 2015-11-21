package com.pint.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.pint.entity.BloodDrive;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.utils.Constants;

@Repository
@Transactional
public class BloodDriveRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public List<BloodDrive> getBloodDrivesByLocation(String city, String state)
	{
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();  


			String sql = "SELECT * FROM " + Constants.BLOODDRIVE_TABLE_NAME + 
					" WHERE city='" + city + "' " + 
					"AND state='" + state + "'";  

			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(BloodDrive.class);

			List<BloodDrive> result = query.list();

			return result;
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
