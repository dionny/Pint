package com.pint.entity.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pint.entity.BloodDrive;
import com.pint.entity.Donor;
import com.pint.entity.Notification;
import com.pint.entity.User;
import com.pint.entity.UserNotification;
import com.pint.utils.Constants;

@Repository
@Transactional
public class NotificationRepository extends com.pint.entity.repository.Repository{

	/**
	 * Get notifications from a blood drive
	 * @param user The user that requested the blood drives
	 * @param bd The blood drive that the user is viewing
	 * @return A list notifications for the selected blood drive
	 */
	public List<Notification> getNotifications(User user, BloodDrive bd) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Fetches a list of user notifications based on a blood drive
	 * @param user The user requesting the notifications
	 * @param bd The relevant blood drive
	 * @return A list of user notifications
	 */
	public List<UserNotification> getUserNotifications(Donor user, BloodDrive bd) {
		List<UserNotification> userNotification = null;
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();  

			String email = user.getEmailAddress();
			long bloodDriveId = bd.getBloodDriveId();

			String sql = "SELECT * FROM " + Constants.USERNOTIFICATION_TABLE_NAME + " un" +
					" WHERE un.email_address='" + email + "' " + 
					"AND un.notification_id IN (" + 
					"SELECT notification_id FROM " + Constants.NOTIFICATION_TABLE_NAME + 
					" WHERE blood_drive_id = " + bloodDriveId + ")";
			
			System.out.println(sql);

			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(UserNotification.class);

			userNotification = query.list();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return userNotification;
	 }

	/**
	 * Get all notifications for a user
	 * @param user The user requesting the notifications
	 * @return A list of user notifications
	 */
	public List<UserNotification> getUserNotifications(Donor donor) {
		List<UserNotification> userNotification = null;
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();  

			String email = donor.getEmailAddress();

			String sql = "SELECT * FROM " + Constants.USERNOTIFICATION_TABLE_NAME + " un" +
					" WHERE un.email_address='" + email + "' ";
			
			System.out.println(sql);

			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(UserNotification.class);

			userNotification = query.list();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return userNotification;
	 }

	/**
	 * Get a list of all notifications for a user
	 * @param user The user requesting the notifications
	 * @return A list of notifications
	 */
	public List<Notification> getNotifications(User user) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Get a list of all notifications for a blood drive
	 * @param bd The relevant blood drive
	 * @return A list of notifications
	 */
	public List<Notification> getNotifications(BloodDrive bd) { 
		List<Notification> notification = null;
		try{
			HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory)entityManagerFactory;
			SessionFactory sessionFactory = emFactory.getSessionFactory();
			Session currentSession = sessionFactory.getCurrentSession();  

			long bloodDriveId = bd.getBloodDriveId();

			String sql = "SELECT * FROM " + Constants.NOTIFICATION_TABLE_NAME +
					" WHERE blood_drive_id='" + bloodDriveId + "'";
			
			System.out.println(sql);

			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(Notification.class);

			notification = query.list();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return notification;
	 }

	/**
	 * Gets a user notification based on a notification
	 * @param note The notification of interest
	 * @param user The user for which a user notification is requested
	 * @return A list of user notifications
	 */
	public List<UserNotification> getUserNotification(Notification note, User user) { 
		// TODO Auto-generated method
		return null;
	 } 

}
