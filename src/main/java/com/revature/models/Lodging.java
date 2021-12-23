package com.revature.models;

//This Class represents the employees table in our database
public class Lodging {

	//fields for the employee class - must match those in your database
	private int lodging_id;
	private String lodging_info;
	private String lodging_cost;
	private int employee_id;
	
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Lodging() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all args constructor
	public Lodging(int lodging_id, String lodging_info, String lodging_cost, int employee_id) {
		super();
		this.lodging_id = lodging_id;
		this.lodging_info = lodging_info;
		this.lodging_cost = lodging_cost;
		this.employee_id = employee_id;
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public Lodging(int lodging_id, String lodging_info, String lodging_cost) {
		super();
		this.lodging_id = lodging_id;
		this.lodging_info = lodging_info;
		this.lodging_cost = lodging_cost;
	}

	
	@Override
	public String toString() {
		return "Lodging [lodging_id=" + lodging_id + ", lodging_info=" + lodging_info + ", lodging_cost=" + lodging_cost
				+ ", employee_id=" + employee_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getLodging_id() {
		return lodging_id;
	}

	public void setLodging_id(int lodging_id) {
		this.lodging_id = lodging_id;
	}

	public String getLodging_info() {
		return lodging_info;
	}

	public void setLodging_info(String lodging_info) {
		this.lodging_info = lodging_info;
	}

	public String getlodging_cost() {
		return lodging_cost;
	}

	public void setlodging_cost(String lodging_cost) {
		this.lodging_cost = lodging_cost;
	}

	
	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lodging_id;
		result = prime * result + ((lodging_info == null) ? 0 : lodging_info.hashCode());
		result = prime * result + ((lodging_cost == null) ? 0 : lodging_cost.hashCode());
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
		Lodging other = (Lodging) obj;
		if (lodging_id != other.lodging_id)
			return false;
		if (lodging_info == null) {
			if (other.lodging_info != null)
				return false;
		} else if (!lodging_info.equals(other.lodging_info))
			return false;
		if (employee_id != other.employee_id)
			return false;
		return true;
	}
}