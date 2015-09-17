

import java.util.List;

public class Campaign extends Entity {

	/**
	 * 
	 */
	public int campaignId;
	/**
	 * 
	 */
	public int coordinatorId;
	/**
	 * 
	 */
	public int hospitalId;
	/**
	 * 
	 */
	public String title;
	/**
	 * 
	 */
	public String description;
	/**
	 * 
	 */
	public long startTime;
	/**
	 * 
	 */
	public long endTime;
	/**
	 * 
	 */
	public String latitude;
	/**
	 * 
	 */
	public String longitude;
	/**
	 * 
	 */
	public List<HospitalUser> nurses;
	/**
	 * 
	 */
	public List<NormalUser> donors;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	/**
	 * 
	 */
	public HomeScreen homescreen;
	/**
	 * Getter of campaignId
	 */
	public int getCampaignId() {
	 	 return campaignId; 
	}
	/**
	 * Setter of campaignId
	 */
	public void setCampaignId(int campaignId) { 
		 this.campaignId = campaignId; 
	}
	/**
	 * Getter of coordinatorId
	 */
	public int getCoordinatorId() {
	 	 return coordinatorId; 
	}
	/**
	 * Setter of coordinatorId
	 */
	public void setCoordinatorId(int coordinatorId) { 
		 this.coordinatorId = coordinatorId; 
	}
	/**
	 * Getter of hospitalId
	 */
	public int getHospitalId() {
	 	 return hospitalId; 
	}
	/**
	 * Setter of hospitalId
	 */
	public void setHospitalId(int hospitalId) { 
		 this.hospitalId = hospitalId; 
	}
	/**
	 * Getter of title
	 */
	public String getTitle() {
	 	 return title; 
	}
	/**
	 * Setter of title
	 */
	public void setTitle(String title) { 
		 this.title = title; 
	}
	/**
	 * Getter of description
	 */
	public String getDescription() {
	 	 return description; 
	}
	/**
	 * Setter of description
	 */
	public void setDescription(String description) { 
		 this.description = description; 
	}
	/**
	 * Getter of startTime
	 */
	public long getStartTime() {
	 	 return startTime; 
	}
	/**
	 * Setter of startTime
	 */
	public void setStartTime(long startTime) { 
		 this.startTime = startTime; 
	}
	/**
	 * Getter of endTime
	 */
	public long getEndTime() {
	 	 return endTime; 
	}
	/**
	 * Setter of endTime
	 */
	public void setEndTime(long endTime) { 
		 this.endTime = endTime; 
	}
	/**
	 * Getter of latitude
	 */
	public String getLatitude() {
	 	 return latitude; 
	}
	/**
	 * Setter of latitude
	 */
	public void setLatitude(String latitude) { 
		 this.latitude = latitude; 
	}
	/**
	 * Getter of longitude
	 */
	public String getLongitude() {
	 	 return longitude; 
	}
	/**
	 * Setter of longitude
	 */
	public void setLongitude(String longitude) { 
		 this.longitude = longitude; 
	}
	/**
	 * Getter of nurses
	 */
	public List<HospitalUser> getNurses() {
	 	 return nurses; 
	}
	/**
	 * Setter of nurses
	 */
	public void setNurses(List<HospitalUser> nurses) { 
		 this.nurses = nurses; 
	}
	/**
	 * Getter of donors
	 */
	public List<NormalUser> getDonors() {
	 	 return donors; 
	}
	/**
	 * Setter of donors
	 */
	public void setDonors(List<NormalUser> donors) { 
		 this.donors = donors; 
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
	 */
	public void stop() { 
		// TODO Auto-generated method
	 } 

}