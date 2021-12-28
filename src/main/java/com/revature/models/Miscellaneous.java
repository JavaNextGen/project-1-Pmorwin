package com.revature.models;

import java.util.Objects;

//This Class represents the employees table in our database
public class Miscellaneous {

	//fields for the employee class - must match those in your database
	private int e_id;
	private String misc_cost;
	private String misc_info;


	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Miscellaneous() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Miscellaneous(int e_id, String misc_cost, String misc_info) {
		super();
		this.e_id = e_id;
		this.misc_cost = misc_cost;
		this.misc_info = misc_info;
	}

	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Miscellaneous(String misc_cost, String misc_info) {
		super();
		this.misc_cost = misc_cost;
		this.misc_info = misc_info;
	}

	@Override
	public String toString() {
		return "Miscellaneous [e_id=" + e_id + ", misc_cost=" + misc_cost + ", misc_info=" + misc_info + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	
	public String getMisc_info() {
		return misc_info;
	}

	public void setMisc_info(String misc_info) {
		this.misc_info = misc_info;
	}

	public String getMisc_cost() {
		return misc_cost;
	}

	public void setMisc_cost(String misc_cost) {
		this.misc_cost = misc_cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e_id, misc_cost, misc_info);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miscellaneous other = (Miscellaneous) obj;
		return e_id == other.e_id && Objects.equals(misc_cost, other.misc_cost)
				&& Objects.equals(misc_info, other.misc_info);
	}
}