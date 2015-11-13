package Presentation.ViewModels;

public class NotificationDetailViewModel extends ViewModel {

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

}
