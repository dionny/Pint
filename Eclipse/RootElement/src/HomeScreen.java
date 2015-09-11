

import java.util.List;

public class HomeScreen extends Screen {

	/**
	 * 
	 */
	public MobileLoginScreen mobileloginscreen;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	/**
	 * 
	 */
	public List<Campaign> campaigns;
	/**
	 * 
	 */
	public UserController usercontroller;

	/**
	 * Getter of mobileloginscreen
	 */
	public MobileLoginScreen getMobileloginscreen() {
	 	 return mobileloginscreen; 
	}

	/**
	 * Setter of mobileloginscreen
	 */
	public void setMobileloginscreen(MobileLoginScreen mobileloginscreen) { 
		 this.mobileloginscreen = mobileloginscreen; 
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
	 * Getter of usercontroller
	 */
	public UserController getUsercontroller() {
	 	 return usercontroller; 
	}

	/**
	 * Setter of usercontroller
	 */
	public void setUsercontroller(UserController usercontroller) { 
		 this.usercontroller = usercontroller; 
	}

	/**
	 * 
	 */
	public void viewNotifications() { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param sessionKey 
	 * @return 
	 */
	public boolean clickLogout(String sessionKey) { 
		// TODO Auto-generated method
		return false;
	 }

	/**
	 * 
	 */
	public void refresh() { 
		// TODO Auto-generated method
	 } 

}