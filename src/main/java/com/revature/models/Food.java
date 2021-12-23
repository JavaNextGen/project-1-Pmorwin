package com.revature.models;


//This Class represents the employees table in our database
public class Food {

	//fields for the employee class - must match those in your database
	private String food_info;
	private String food_cost;
	private String f_name;
	private String l_name;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}


	//all args constructor
	public Food(String f_name, String l_name, String food_info, String food_cost) {
		super();
		this.f_name = f_name;
		this.food_info = food_info;
		this.food_cost = food_cost;
		this.l_name = l_name;
	}
	
	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Food(String l_name, String food_info, String food_cost) {
		super();
		this.l_name = l_name;
		this.food_info = food_info;
		this.food_cost = food_cost;
	}
	
	@Override
	public String toString() {
		return "Food [f_name=" + f_name + ", food_info=" + food_info + ", food_cost=" + food_cost + ", l_name="
				+ l_name + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getEmployee_id() {
		return l_name;
	}

	public void setEmployee_id(String l_name) {
		this.l_name = l_name;
	}

	public String getFood_id() {
		return f_name;
	}


	public void setFood_id(String f_name) {
		this.f_name = f_name;
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
		result = prime * result + ((food_info == null) ? 0 : food_info.hashCode());
		result = prime * result + ((food_cost == null) ? 0 : food_cost.hashCode());
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
		Food other = (Food) obj;
		if (f_name != other.f_name)
			return false;
		if (food_info == null) {
			if (other.food_info != null)
				return false;
		} else if (!food_info.equals(other.food_info))
			return false;
		if (l_name != other.l_name)
			return false;
		return true;
	}
}