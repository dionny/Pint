package com.pint.repository;

import java.util.List;

import com.pint.entity.BloodDrive;
import com.pint.entity.Notification;
import com.pint.security.User;
import com.pint.entity.UserNotification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NotificationRepository {

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
	public List<UserNotification> getUserNotifications(User user, BloodDrive bd) {
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Get all notifications for a user
	 * @param user The user requesting the notifications
	 * @return A list of user notifications
	 */
	public List<UserNotification> getUserNotifications(User user) { 
		// TODO Auto-generated method
		return null;
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
		// TODO Auto-generated method
		return null;
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
