

import java.util.List;

public class NotificationScreen {

	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	/**
	 * 
	 */
	public List<String> notifications;
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
	 * Getter of notifications
	 */
	public List<String> getNotifications() {
	 	 return notifications; 
	}
	/**
	 * Setter of notifications
	 */
	public void setNotifications(List<String> notifications) { 
		 this.notifications = notifications; 
	} 

}