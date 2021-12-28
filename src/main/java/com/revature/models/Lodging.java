package com.revature.models;

import java.util.Objects;

//This Class represents the employees table in our database
public class Lodging {

	//fields for the employee class - must match those in your database
	private int e_id;
	private String lodging_cost;
	private String lodging_info;

	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Lodging() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all args constructor
	public Lodging(int e_id, String lodging_cost, String lodging_info) {
		super();
		this.e_id = e_id;
		this.lodging_cost = lodging_cost;
		this.lodging_info = lodging_info;
	}

	//all args MINUS the l_name primary key... WHY?
	//we will eventually want the capability to add employees... and the l_name auto increments!!!
	public Lodging(String lodging_cost, String lodging_info) {
		super();
		this.lodging_cost = lodging_cost;
		this.lodging_info = lodging_info;
	}

	@Override
	public String toString() {
		return "Lodging [e_id=" + e_id + ", lodging_cost=" + lodging_cost + ", lodging_info=" + lodging_info + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getLodging_info() {
		return lodging_info;
	}

	public void setLodging_info(String lodging_info) {
		this.lodging_info = lodging_info;
	}

	public String getLodging_cost() {
		return lodging_cost;
	}

	public void setLodging_cost(String lodging_cost) {
		this.lodging_cost = lodging_cost;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(e_id, lodging_cost, lodging_info);
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
		return e_id == other.e_id && Objects.equals(lodging_cost, other.lodging_cost)
				&& Objects.equals(lodging_info, other.lodging_info);
	}
}