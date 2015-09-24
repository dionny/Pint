

import java.util.List;

public class NurseDashboard extends Screen {

	/**
	 * 
	 */
	public BloodDrive bloodDrives;
	/**
	 * 
	 */
	public BloodDriveController campaigncontroller;
	public List<BloodDrive> campaign;
	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	public List<Notification> notification;
	/**
	 * Getter of bloodDrives
	 */
	public BloodDrive getBloodDrives() {
	 	 return bloodDrives; 
	}
	/**
	 * Setter of bloodDrives
	 */
	public void setBloodDrives(BloodDrive bloodDrives) { 
		 this.bloodDrives = bloodDrives; 
	}
	/**
	 * Getter of campaigncontroller
	 */
	public BloodDriveController getCampaigncontroller() {
	 	 return campaigncontroller; 
	}
	/**
	 * Setter of campaigncontroller
	 */
	public void setCampaigncontroller(BloodDriveController campaigncontroller) { 
		 this.campaigncontroller = campaigncontroller; 
	}
	/**
	 * Getter of campaign
	 */
	public List<BloodDrive> getCampaign() {
	 	 return campaign; 
	}
	/**
	 * Setter of campaign
	 */
	public void setCampaign(List<BloodDrive> campaign) { 
		 this.campaign = campaign; 
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
	 * 
	 * @param title 
	 * @param description 
	 * @param startTime 
	 * @param endTime 
	 * @param nurses 
	 * @param address 
	 * @return 
	 */
	public BloodDrive createBloodDrive(String title, String description, long startTime, long endTime, Employee nurses, String address) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param bloodDriveId 
	 */
	public void stopBloodDrive(int bloodDriveId) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bloodDriveId 
	 * @param message 
	 */
	public void sendNotifications(int bloodDriveId, String message) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param message 
	 */
	public void setNotificationMsg(String message) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void confirmNotification() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bloodDrive 
	 */
	public void selectBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
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
	 * @param emailAddress 
	 */
	public void enterEmail(String emailAddress) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void addDonor() { 
		// TODO Auto-generated method
	 } 

}