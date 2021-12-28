package com.revature.models;

import java.util.Objects;

//This Class represents the employees table in our database
public class Food {

	//fields for the employee class - must match those in your database
	private int e_id;
	private String food_cost;
	private String food_info;


	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}


	//all args constructor
	public Food(int e_id, String food_cost, String food_info) {
		super();
		this.e_id = e_id;
		this.food_cost = food_cost;
		this.food_info = food_info;
	}
	
	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Food(String food_cost, String food_info) {
		super();
		this.food_cost = food_cost;
		this.food_info = food_info;
	}

	@Override
	public String toString() {
		return "Food [e_id=" + e_id + ", food_cost=" + food_cost + ", food_info=" + food_info + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getE_id() {
		return e_id;
	}


	public void setE_id(int e_id) {
		this.e_id = e_id;
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


	@Override
	public int hashCode() {
		return Objects.hash(e_id, food_cost, food_info);
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
		return e_id == other.e_id && Objects.equals(food_cost, other.food_cost)
				&& Objects.equals(food_info, other.food_info);
	}
}