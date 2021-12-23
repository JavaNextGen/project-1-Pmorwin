package com.revature.models;


//This Class represents the employees table in our database
public class Food {

	//fields for the employee class - must match those in your database
	private int food_id;
	private String food_info;
	private String food_cost;
	private int employee_id;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}


	//all args constructor
	public Food(int food_id, String food_info, String food_cost, int employee_id) {
		super();
		this.food_id = food_id;
		this.food_info = food_info;
		this.food_cost = food_cost;
		this.employee_id = employee_id;
	}
	
	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public Food(int food_id, String food_info, String food_cost) {
		super();
		this.food_id = food_id;
		this.food_info = food_info;
		this.food_cost = food_cost;
	}
	
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_info=" + food_info + ", food_cost=" + food_cost + ", employee_id="
				+ employee_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getFood_id() {
		return food_id;
	}


	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}


	public String getFood_info() {
		return food_info;
	}


	public void setFood_info(String food_info) {
		this.food_info = food_info;
	}


	public String getFood_cost() {
		return food_cost;
	}


	public void setFood_cost(String food_cost) {
		this.food_cost = food_cost;
	}


	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + food_id;
		result = prime * result + ((food_info == null) ? 0 : food_info.hashCode());
		result = prime * result + ((food_cost == null) ? 0 : food_cost.hashCode());
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
		Food other = (Food) obj;
		if (food_id != other.food_id)
			return false;
		if (food_info == null) {
			if (other.food_info != null)
				return false;
		} else if (!food_info.equals(other.food_info))
			return false;
		if (employee_id != other.employee_id)
			return false;
		return true;
	}
}