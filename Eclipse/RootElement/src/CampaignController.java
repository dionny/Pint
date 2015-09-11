

public class CampaignController extends Controller {

	/**
	 * 
	 */
	public Campaign campaign;
	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	/**
	 * 
	 */
	public HomeScreen homescreen;
	/**
	 * 
	 */
	public CoordinatorDashboard coordinatordashboard;
	/**
	 * Getter of campaign
	 */
	public Campaign getCampaign() {
	 	 return campaign; 
	}
	/**
	 * Setter of campaign
	 */
	public void setCampaign(Campaign campaign) { 
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
	 * Getter of homescreen
	 */
	public HomeScreen getHomescreen() {
	 	 return homescreen; 
	}
	/**
	 * Setter of homescreen
	 */
	public void setHomescreen(HomeScreen homescreen) { 
		 this.homescreen = homescreen; 
	}
	/**
	 * Getter of coordinatordashboard
	 */
	public CoordinatorDashboard getCoordinatordashboard() {
	 	 return coordinatordashboard; 
	}
	/**
	 * Setter of coordinatordashboard
	 */
	public void setCoordinatordashboard(CoordinatorDashboard coordinatordashboard) { 
		 this.coordinatordashboard = coordinatordashboard; 
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
	 * @param message 
	 * @param campaignId 
	 */
	public void sendNotifications(String message, int campaignId) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param campaign 
	 * @return 
	 */
	public Campaign createCampaign(Campaign campaign) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param latitude 
	 * @param longitude 
	 * @return 
	 */
	public Campaign getCampaigns(float latitude, float longitude) { 
		// TODO Auto-generated method
		return null;
	 } 

}