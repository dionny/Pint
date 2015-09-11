

import java.util.List;

public class Campaign {

	/**
	 * 
	 */
	public int coordinatorId;
	/**
	 * 
	 */
	public String title;
	/**
	 * 
	 */
	public List<HospitalUser> nurses;
	/**
	 * 
	 */
	public int campaignId;
	/**
	 * 
	 */
	public String description;
	/**
	 * 
	 */
	public CampaignController campaigncontroller;
	/**
	 * 
	 */
	public float longitude;
	/**
	 * 
	 */
	public long startTime;
	/**
	 * 
	 */
	public int hospitalId;
	/**
	 * 
	 */
	public long endTime;
	/**
	 * 
	 */
	public List<NormalUser> donors;
	/**
	 * 
	 */
	public float latitude;
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
	 * Getter of longitude
	 */
	public float getLongitude() {
	 	 return longitude; 
	}
	/**
	 * Setter of longitude
	 */
	public void setLongitude(float longitude) { 
		 this.longitude = longitude; 
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
	 * Getter of latitude
	 */
	public float getLatitude() {
	 	 return latitude; 
	}
	/**
	 * Setter of latitude
	 */
	public void setLatitude(float latitude) { 
		 this.latitude = latitude; 
	} 

}