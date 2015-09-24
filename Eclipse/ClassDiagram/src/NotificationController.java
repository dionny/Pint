

import java.util.List;

public class NotificationController extends Controller {

	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	/**
	 * 
	 */
	public NotificationScreen notificationscreen;
	public List<Notification> notification;
	/**
	 * Getter of campaigncontroller
	 */
	public CampaignController getCampaigncontroller() {
	 	 return campaigncontroller; 
	}
	/**
	 * Setter of campaigncontroller
	 */
	public void setCampaigncontroller(CampaignController campaigncontroller) { 
		 this.campaigncontroller = campaigncontroller; 
	}
	/**
	 * Getter of notificationscreen
	 */
	public NotificationScreen getNotificationscreen() {
	 	 return notificationscreen; 
	}
	/**
	 * Setter of notificationscreen
	 */
	public void setNotificationscreen(NotificationScreen notificationscreen) { 
		 this.notificationscreen = notificationscreen; 
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
	 * @param Campaign 
	 * @param message 
	 * @return 
	 */
	public boolean checkRadius(Campaign Campaign, String message) { 
		// TODO Auto-generated method
		return false;
	 }
	/**
	 * 
	 */
	public void getNotifications() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param notification 
	 */
	public void sendNotification(Notification notification) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param Campaign 
	 * @param message 
	 * @return 
	 */
	public boolean checkRadius(BloodDrive Campaign, String message) { 
		// TODO Auto-generated method
		return false;
	 } 

}