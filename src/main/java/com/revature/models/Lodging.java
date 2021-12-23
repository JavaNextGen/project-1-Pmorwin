package com.revature.models;

//This Class represents the employees table in our database
public class Lodging {

	//fields for the employee class - must match those in your database
	
	private String lodging_info;
	private String lodging_cost;
	private String f_name;
	private String l_name;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Lodging() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all args constructor
	public Lodging(String f_name, String l_name, String lodging_info, String lodging_cost) {
		super();
		this.f_name = f_name;
		this.lodging_info = lodging_info;
		this.lodging_cost = lodging_cost;
		this.l_name = l_name;
	}

	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Lodging(String l_name, String lodging_info, String lodging_cost) {
		super();
		this.l_name = l_name;
		this.lodging_info = lodging_info;
		this.lodging_cost = lodging_cost;
	}

	
	@Override
	public String toString() {
		return "Lodging [f_name=" + f_name + ", lodging_info=" + lodging_info + ", lodging_cost=" + lodging_cost
				+ ", l_name=" + l_name + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getEmployee_id() {
		return l_name;
	}

	public void setEmployee_id(String l_name) {
		this.l_name = l_name;
	}

	public String getLodging_id() {
		return f_name;
	}

	public void setLodging_id(String f_name) {
		this.f_name = f_name;
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
		result = prime * result + ((lodging_info == null) ? 0 : lodging_info.hashCode());
		result = prime * result + ((lodging_cost == null) ? 0 : lodging_cost.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
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
		if (f_name != other.f_name)
			return false;
		if (lodging_info == null) {
			if (other.lodging_info != null)
				return false;
		} else if (!lodging_info.equals(other.lodging_info))
			return false;
		if (l_name != other.l_name)
			return false;
		return true;
	}
}