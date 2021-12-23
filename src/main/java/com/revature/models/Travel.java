package com.revature.models;


//This Class represents the employees table in our database
public class Travel {

	//fields for the employee class - must match those in your database
	private String Travel_info;
	private String Travel_cost;
	private String f_name;
	private String l_name;
	
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Travel(String f_name, String l_name , String travel_info, String travel_cost) {
		super();
		this.f_name = f_name;
		this.Travel_info = travel_info;
		this.Travel_cost = travel_cost;
		this.l_name = l_name;
	}

	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Travel(String l_name, String travel_info, String travel_cost) {
		super();
		this.l_name = l_name;
		this.Travel_info = travel_info;
		this.Travel_cost = travel_cost;
		
	}

	@Override
	public String toString() {
		return "Travel [l_name=" + l_name + ", Travel_info=" + Travel_info + ", Travel_cost=" + Travel_cost
				+ ", l_name=" + l_name + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getEmployee_id() {
		return l_name;
	}

	public void setEmployee_id(String l_name) {
		this.l_name = l_name;
	}

	public String getl_name() {
		return l_name;
	}

	public void setl_name(String l_name) {
		this.l_name = l_name;
	}

	public String getTravel_info() {
		return Travel_info;
	}

	public void setTravel_info(String travel_info) {
		this.Travel_info = travel_info;
	}

	public String getTravel_cost() {
		return Travel_cost;
	}

	public void setTravel_cost(String travel_cost) {
		this.Travel_cost = travel_cost;
	}

	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Travel_info == null) ? 0 : Travel_info.hashCode());
		result = prime * result + ((Travel_cost == null) ? 0 : Travel_cost.hashCode());
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
		Travel other = (Travel) obj;
		if (l_name != other.l_name)
			return false;
		if (Travel_info == null) {
			if (other.Travel_info != null)
				return false;
		} else if (!Travel_info.equals(other.Travel_info))
			return false;
		if (l_name != other.l_name)
			return false;
		return true;
	}
}