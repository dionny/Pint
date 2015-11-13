package Data.Models;

public class Notification {

	/**
	 * 
	 */
	public String title;
	/**
	 * 
	 */
	public String shortDescription;
	/**
	 * 
	 */
	public String longDescription;
	/**
	 * 
	 */
	public BloodDrive bloodDrive;
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
	 * Getter of shortDescription
	 */
	public String getShortDescription() {
	 	 return shortDescription; 
	}
	/**
	 * Setter of shortDescription
	 */
	public void setShortDescription(String shortDescription) { 
		 this.shortDescription = shortDescription; 
	}
	/**
	 * Getter of longDescription
	 */
	public String getLongDescription() {
	 	 return longDescription; 
	}
	/**
	 * Setter of longDescription
	 */
	public void setLongDescription(String longDescription) { 
		 this.longDescription = longDescription; 
	}
	/**
	 * Getter of bloodDrive
	 */
	public BloodDrive getBloodDrive() {
	 	 return bloodDrive; 
	}
	/**
	 * Setter of bloodDrive
	 */
	public void setBloodDrive(BloodDrive bloodDrive) { 
		 this.bloodDrive = bloodDrive; 
	} 

}
