package com.revature.models;



//This Class represents the employees table in our database
public class Miscellaneous {

	//fields for the employee class - must match those in your database
	private int misc_id;
	private String misc_info;
	private String misc_cost;
	private int employee_id;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Miscellaneous() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Miscellaneous(int misc_id, String misc_info, String misc_cost, int employee_id) {
		super();
		this.misc_id = misc_id;
		this.misc_info = misc_info;
		this.misc_cost = misc_cost;
		this.employee_id = employee_id;
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public Miscellaneous(int misc_id, String misc_info, String misc_cost) {
		super();
		this.misc_id = misc_id;
		this.misc_info = misc_info;
		this.misc_cost = misc_cost;
	}

	@Override
	public String toString() {
		return "Miscellaneous [misc_id=" + misc_id + ", misc_info=" + misc_info + ", misc_cost=" + misc_cost
				+ ", employee_id=" + employee_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getMisc_id() {
		return misc_id;
	}

	public void setMisc_id(int misc_id) {
		this.misc_id = misc_id;
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

	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((misc_info == null) ? 0 : misc_info.hashCode());
		result = prime * result + ((misc_cost == null) ? 0 : misc_cost.hashCode());
		result = prime * result + employee_id;
		return result;
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
		if (misc_id != other.misc_id)
			return false;
		if (misc_info == null) {
			if (other.misc_info != null)
				return false;
		} else if (!misc_info.equals(other.misc_info))
			return false;
		if (employee_id != other.employee_id)
			return false;
		return true;
	}
}