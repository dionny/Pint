

import java.util.List;

public class HomeScreen extends Screen {

	/**
	 * 
	 */
	public MobileLoginScreen mobileloginscreen;
	/**
	 * 
	 */
	public UserController usercontroller;
	/**
	 * 
	 */
	public List<Campaign> campaigns;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	/**
	 * 
	 */
	public RegistrationScreen registrationscreen;
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
	 * Getter of registrationscreen
	 */
	public RegistrationScreen getRegistrationscreen() {
	 	 return registrationscreen; 
	}
	/**
	 * Setter of registrationscreen
	 */
	public void setRegistrationscreen(RegistrationScreen registrationscreen) { 
		 this.registrationscreen = registrationscreen; 
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
	public void viewNotifications() { 
		// TODO Auto-generated method
	 } 

}