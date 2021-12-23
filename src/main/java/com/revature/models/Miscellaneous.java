package com.revature.models;



//This Class represents the employees table in our database
public class Miscellaneous {

	//fields for the employee class - must match those in your database
	private String misc_info;
	private String misc_cost;
	private String f_name;
	private String l_name;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Miscellaneous() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Miscellaneous(String f_name, String l_name, String misc_info, String misc_cost) {
		super();
		this.f_name = f_name;
		this.misc_info = misc_info;
		this.misc_cost = misc_cost;
		this.l_name = l_name;
	}

	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Miscellaneous(String l_name, String misc_info, String misc_cost) {
		super();
		this.l_name = l_name;
		this.misc_info = misc_info;
		this.misc_cost = misc_cost;
	}

	@Override
	public String toString() {
		return "Miscellaneous [f_name=" + f_name + ", misc_info=" + misc_info + ", misc_cost=" + misc_cost
				+ ", l_name=" + l_name + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
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
		result = prime * result + ((misc_info == null) ? 0 : misc_info.hashCode());
		result = prime * result + ((misc_cost == null) ? 0 : misc_cost.hashCode());
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
		Miscellaneous other = (Miscellaneous) obj;
		if (f_name != other.f_name)
			return false;
		if (misc_info == null) {
			if (other.misc_info != null)
				return false;
		} else if (!misc_info.equals(other.misc_info))
			return false;
		if (l_name != other.l_name)
			return false;
		return true;
	}
}