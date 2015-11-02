package Data.Repositories;

import ECore.EJavaObject;

public abstract class Repository {

	/**
	 * 
	 * @param id 
	 * @param object 
	 */
	public void get(int id, EJavaObject object) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param data 
	 */
	public void update(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param data 
	 */
	public void delete(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param data 
	 */
	public void create(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param id 
	 * @param object 
	 */
	public void get(String id, EJavaObject object) { 
		// TODO Auto-generated method
	 } 

}
