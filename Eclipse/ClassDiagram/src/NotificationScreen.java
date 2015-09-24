

import java.util.List;

public class NotificationScreen extends Screen {

	/**
	 * 
	 */
	public List<Notification> notifications;
	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	public List<Notification> notification;
	/**
	 * Getter of notifications
	 */
	public List<Notification> getNotifications() {
	 	 return notifications; 
	}
	/**
	 * Setter of notifications
	 */
	public void setNotifications(List<Notification> notifications) { 
		 this.notifications = notifications; 
	}
	/**
	 * Getter of notificationcontroller
	 */
	public NotificationController getNotificationcontroller() {
	 	 return notificationcontroller; 
	}
	/**
	 * Setter of notificationcontroller
	 */
	public void setNotificationcontroller(NotificationController notificationcontroller) { 
		 this.notificationcontroller = notificationcontroller; 
	}
	/**
	 * Getter of notification
	 */
	public List<Notification> getNotification() {
	 	 return notification; 
	}
	/**
	 * Setter of notification
	 */
	public void setNotification(List<Notification> notification) { 
		 this.notification = notification; 
	}
	/**
	 * 
	 * @param displayNotification 
	 */
	public void displayNotification(Notification displayNotification) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param notification 
	 */
	public void selectNotification(Notification notification) { 
		// TODO Auto-generated method
	 } 

}