package Client.Mobile;

import Data.Models.BloodDrive;
import Data.Models.Notification;

public class DetailScreen extends MobileScreen {

	/**
	 * 
	 */
	public BloodDrive bloodDrive;

	/**
	 * Getter of bloodDrive.
	 * @return The BloodDrive displayed in the DetailScreen.
	 */
	public BloodDrive getBloodDrive() {
	 	 return bloodDrive; 
	}

	/**
	 * Setter of bloodDrive.
	 * @param bloodDrive The BloodDrive that is to be displayed in the DetailScreen.
	 */
	public void setBloodDrive(BloodDrive bloodDrive) { 
		 this.bloodDrive = bloodDrive; 
	}

	/**
	 * After the user taps a notification in the notification list,
	 * this method will scroll to that same notification on the 
	 * DetailScreen. It will also open the contents for the user to
	 * read.
	 * @param note The notification to scroll to and open. 
	 */
	public void scrollToAndOpen(Notification note) { 
		// TODO Auto-generated method
	 } 

}
