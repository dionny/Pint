

import java.util.List;

public class BloodDrive extends Entity {

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
	public BloodDriveController blooddrivecontroller;
	/**
	 * 
	 */
	public HomeScreen homescreen;
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
	public List<Donor> donor;
	/**
	 * 
	 */
	public Hospital hospital;
	/**
	 * 
	 */
	public Employee employee;
	/**
	 * 
	 */
	public int id;
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
	 * Getter of blooddrivecontroller
	 */
	public BloodDriveController getBlooddrivecontroller() {
	 	 return blooddrivecontroller; 
	}
	/**
	 * Setter of blooddrivecontroller
	 */
	public void setBlooddrivecontroller(BloodDriveController blooddrivecontroller) { 
		 this.blooddrivecontroller = blooddrivecontroller; 
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
	 * Getter of donor
	 */
	public List<Donor> getDonor() {
	 	 return donor; 
	}
	/**
	 * Setter of donor
	 */
	public void setDonor(List<Donor> donor) { 
		 this.donor = donor; 
	}
	/**
	 * Getter of hospital
	 */
	public Hospital getHospital() {
	 	 return hospital; 
	}
	/**
	 * Setter of hospital
	 */
	public void setHospital(Hospital hospital) { 
		 this.hospital = hospital; 
	}
	/**
	 * Getter of employee
	 */
	public Employee getEmployee() {
	 	 return employee; 
	}
	/**
	 * Setter of employee
	 */
	public void setEmployee(Employee employee) { 
		 this.employee = employee; 
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
	 * 
	 */
	public void stop() { 
		// TODO Auto-generated method
	 } 

}