package com.revature.models;


//This Class represents the employees table in our database
public class Travel {

	//fields for the employee class - must match those in your database
	private int Travel_id;
	private String Travel_info;
	private String Travel_cost;
	private int employee_id;
	
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Travel(int travel_id, String travel_info, String travel_cost, int employee_id) {
		super();
		Travel_id = travel_id;
		Travel_info = travel_info;
		Travel_cost = travel_cost;
		this.employee_id = employee_id;
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public Travel(int travel_id, String travel_info, String travel_cost) {
		super();
		Travel_id = travel_id;
		Travel_info = travel_info;
		Travel_cost = travel_cost;
		
	}

	@Override
	public String toString() {
		return "Travel [Travel_id=" + Travel_id + ", Travel_info=" + Travel_info + ", Travel_cost=" + Travel_cost
				+ ", employee_id=" + employee_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getTravel_id() {
		return Travel_id;
	}

	public void setTravel_id(int travel_id) {
		Travel_id = travel_id;
	}

	public String getTravel_info() {
		return Travel_info;
	}

	public void setTravel_info(String travel_info) {
		Travel_info = travel_info;
	}

	public String getTravel_cost() {
		return Travel_cost;
	}

	public void setTravel_cost(String travel_cost) {
		Travel_cost = travel_cost;
	}

	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((Travel_info == null) ? 0 : Travel_info.hashCode());
		result = prime * result + ((Travel_cost == null) ? 0 : Travel_cost.hashCode());
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
		Travel other = (Travel) obj;
		if (Travel_id != other.Travel_id)
			return false;
		if (Travel_info == null) {
			if (other.Travel_info != null)
				return false;
		} else if (!Travel_info.equals(other.Travel_info))
			return false;
		if (employee_id != other.employee_id)
			return false;
		return true;
	}
}