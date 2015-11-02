package Data.Models;

import java.util.List;

public class BloodDrive {

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
	public List<Employee> nurses;
	/**
	 * 
	 */
	public String address;
	/**
	 * 
	 */
	public int numberOfDonors;
	/**
	 * 
	 */
	public int id;
	/**
	 * 
	 */
	public List<Notification> notification;
	/**
	 * 
	 */
	public List<Employee> employee;
	/**
	 * 
	 */
	public String city;
	/**
	 * 
	 */
	public String state;
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
	 * Getter of nurses
	 */
	public List<Employee> getNurses() {
	 	 return nurses; 
	}
	/**
	 * Setter of nurses
	 */
	public void setNurses(List<Employee> nurses) { 
		 this.nurses = nurses; 
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
	/**
	 * Getter of id
	 */
	public int getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(int id) { 
		 this.id = id; 
	}
	/**
	 * Getter of notification
	 */
	public List<Notification> getNotification() {
	 	 return notification; 
	}
	/**
	 * Setter of notification
	 */
	public void setNotification(List<Notification> notification) { 
		 this.notification = notification; 
	}
	/**
	 * Getter of employee
	 */
	public List<Employee> getEmployee() {
	 	 return employee; 
	}
	/**
	 * Setter of employee
	 */
	public void setEmployee(List<Employee> employee) { 
		 this.employee = employee; 
	}
	/**
	 * Getter of city
	 */
	public String getCity() {
	 	 return city; 
	}
	/**
	 * Setter of city
	 */
	public void setCity(String city) { 
		 this.city = city; 
	}
	/**
	 * Getter of state
	 */
	public String getState() {
	 	 return state; 
	}
	/**
	 * Setter of state
	 */
	public void setState(String state) { 
		 this.state = state; 
	}
	/**
	 * 
	 */
	public void create() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void get() { 
		// TODO Auto-generated method
	 } 

}
