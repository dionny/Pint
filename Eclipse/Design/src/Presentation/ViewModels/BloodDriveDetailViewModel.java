package Presentation.ViewModels;

public class BloodDriveDetailViewModel extends ViewModel {

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
	public String address;
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
	public int numberOfDonors;
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
	 * Getter of address
	 */
	public String getAddress() {
	 	 return address; 
	}
	/**
	 * Setter of address
	 */
	public void setAddress(String address) { 
		 this.address = address; 
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
	 * Getter of numberOfDonors
	 */
	public int getNumberOfDonors() {
	 	 return numberOfDonors; 
	}
	/**
	 * Setter of numberOfDonors
	 */
	public void setNumberOfDonors(int numberOfDonors) { 
		 this.numberOfDonors = numberOfDonors; 
	} 

}
