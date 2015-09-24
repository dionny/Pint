

import java.util.List;

public class CoordinatorDashboard extends Screen {

	/**
	 * 
	 */
	public List<Campaign> campaigns;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	public List<Campaign> campaign;
	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	/**
	 * 
	 */
	public List<BloodDrive> bloodDrives;
	/**
	 * Getter of campaigns
	 */
	public List<Campaign> getCampaigns() {
	 	 return campaigns; 
	}
	/**
	 * Setter of campaigns
	 */
	public void setCampaigns(List<Campaign> campaigns) { 
		 this.campaigns = campaigns; 
	}
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
	 * Getter of campaign
	 */
	public List<Campaign> getCampaign() {
	 	 return campaign; 
	}
	/**
	 * Setter of campaign
	 */
	public void setCampaign(List<Campaign> campaign) { 
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
	public Campaign createCampaign(String title, String description, long startTime, long endTime, HospitalUser nurses, String address) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param campaignId 
	 */
	public void stopCampaign(int campaignId) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bloodDriveId 
	 * @param message 
	 */
	public void sendNotifications(int campaignId, String message) { 
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
	 * Getter of bloodDrives
	 */
	public List<BloodDrive> getBloodDrives() {
	 	 return bloodDrives; 
	}
	/**
	 * Setter of bloodDrives
	 */
	public void setBloodDrives(List<BloodDrive> bloodDrives) { 
		 this.bloodDrives = bloodDrives; 
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
	 * @param bloodDrive 
	 */
	public void selectBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
	 } 

}