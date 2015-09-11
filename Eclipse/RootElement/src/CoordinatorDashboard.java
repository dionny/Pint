

import java.util.List;

public class CoordinatorDashboard {

	/**
	 * 
	 */
	public List<Campaign> campaigns;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
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
	 * 
	 * @param campaignId 
	 */
	public void stopCampaign(int campaignId) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param title 
	 * @param endTime 
	 * @param startTime 
	 * @param nurses 
	 * @param description 
	 * @param address 
	 * @return 
	 */
	public Campaign createCampaign(String title, long endTime, long startTime, HospitalUser nurses, String description, String address) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param campaignId 
	 * @param message 
	 */
	public void sendNotifications(int campaignId, String message) { 
		// TODO Auto-generated method
	 } 

}