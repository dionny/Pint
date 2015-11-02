package Presentation.ViewModels;

public class NotificationSummaryViewModel extends ViewModel {

	/**
	 * 
	 */
	public String title;
	/**
	 * 
	 */
	public String shortDescription;
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

}
