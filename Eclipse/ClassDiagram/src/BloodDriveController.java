

public class BloodDriveController extends Controller {

	/**
	 * 
	 */
	public CoordinatorDashboard coordinatordashboard;
	/**
	 * 
	 */
	public BloodDrive campaign;
	/**
	 * 
	 */
	public NotificationController notificationcontroller;
	/**
	 * 
	 */
	public HomeScreen homescreen;
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
	 * Getter of campaign
	 */
	public BloodDrive getCampaign() {
	 	 return campaign; 
	}
	/**
	 * Setter of campaign
	 */
	public void setCampaign(BloodDrive campaign) { 
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
	 * 
	 * @param bloodDrive 
	 * @return 
	 */
	public BloodDrive createBloodDrive(BloodDrive bloodDrive) { 
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
	 * @return 
	 */
	public String getBloodDrives() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param nurses 
	 * @return 
	 */
	public BloodDrive saveNurses(Employee nurses) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param emailAddress 
	 */
	public void submitUser(String emailAddress) { 
		// TODO Auto-generated method
	 } 

}