package com.pint.entity.repository;

import org.hibernate.type.descriptor.java.EnumJavaTypeDescriptor;

public abstract class Repository {

	/**
	 * Executes a read request
	 * @param id 
	 * @param object 
	 */
	public void get(int id, Object data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes an update request
	 * @param data 
	 */
	public void update(Object data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a delete request
	 * @param data 
	 */
	public void delete(Object data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a write request
	 * @param data 
	 */
	public void create(Object data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a read request
	 * @param id 
	 * @param object 
	 */
	public void get(String id, Object object) { 
		// TODO Auto-generated method
	 } 

}
