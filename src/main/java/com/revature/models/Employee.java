package com.revature.models;

import com.revature.models.Employee;

//This Class represents the employees table in our database
public class Employee {

	//fields for the employee class - must match those in your database
	private String f_name;
	private String l_name;

	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Employee(String f_name, String l_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!

	//so our Employee objects can be printed out - returns a String describing the object
	@Override
	public String toString() {
		return "Employee [ f_name=" + f_name + ", l_name=" + l_name + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	
	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Employee other = (Employee) obj;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		return true;
	}
}