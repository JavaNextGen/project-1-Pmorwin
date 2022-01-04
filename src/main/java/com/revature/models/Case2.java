package com.revature.models;

import java.util.List;
import java.util.Scanner;
import com.revature.services.EmployeeService;
import com.revature.services.FoodService;
import com.revature.services.LodgingService;
import com.revature.services.MiscellaneousService;
import com.revature.services.TravelService;

public class Case2 {
	
	Scanner scan = new Scanner(System.in);
	boolean displayMenu = true;
	EmployeeService eServices = new EmployeeService();
	FoodService fs = new FoodService();
	LodgingService ls = new LodgingService();
	TravelService ts = new TravelService();
	MiscellaneousService ms = new MiscellaneousService();
	Menu_Employee e_menu = new Menu_Employee();

public void case2() {
	System.out.println();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("~~~~  Which category of reinbursement requests would you like to view?  ~~~~");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println();
	System.out.println("1: LODGING");
	System.out.println("2: TRAVEL");
	System.out.println("3: FOOD");
	System.out.println("4: Miscellaneous");
	System.out.println("5: Exit the Program");
	System.out.println();	
	String case2 = scan.nextLine();//user input

	switch(case2) {
	
		case "1": {
			//need to get the list of employees from the repository layer
			List<Lodging> lodging = ls.getLodging();
			
			//enhanced for loop to print out the Employees one by one
			for(Lodging l : lodging) {
				System.out.println(l);
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~  Do you need to review another request?  ~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~  Input 1 for Yes | Input 2 for No  ~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			String breakOut = scan.nextLine();
				switch(breakOut) {
					case "1":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						break;
					}
					case "2":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~  Have a Nice Day!  ~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
					default:{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
				}
			break;//we need a break in each case block, or else all the other calls will still run
		}
		case "2": {
			//need to get the list of employees from the repository layer
			List<Travel> travel = ts.getTravel();
			
			//enhanced for loop to print out the Employees one by one
			for(Travel t : travel) {
				System.out.println(t);
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~  Do you need to review another request?  ~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~  Input 1 for Yes | Input 2 for No  ~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			String breakOut = scan.nextLine();
				switch(breakOut) {
					case "1":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						break;
					}
					case "2":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~  Have a Nice Day!  ~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
					default:{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
				}
			break;//we need a break in each case block, or else all the other calls will still run
		}
		case "3": {
			//need to get the list of employees from the repository layer
			List<Food> food = fs.getFood();
			
			//enhanced for loop to print out the Employees one by one
			for(Food f : food) {
				System.out.println(f);
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~  Do you need to review another request?  ~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~  Input 1 for Yes | Input 2 for No  ~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			String breakOut = scan.nextLine();
				switch(breakOut) {
					case "1":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						break;
					}
					case "2":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~  Have a Nice Day!  ~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
					default:{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
				}
			break;//we need a break in each case block, or else all the other calls will still run
		}
		case "4": {
			//need to get the list of employees from the repository layer
			List<Miscellaneous> miscellaneous = ms.getMiscellaneous();
			
			//enhanced for loop to print out the Employees one by one
			for(Miscellaneous m : miscellaneous) {
				System.out.println(m);
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~  Do you need to review another request?  ~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~  Input 1 for Yes | Input 2 for No  ~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			String breakOut = scan.nextLine();
				switch(breakOut) {
					case "1":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						break;
					}
					case "2":{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~  One Moment Please!  ~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~  Have a Nice Day!  ~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
					default:{
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println();
						displayMenu = false;
						break;
					}
				}
			break;//we need a break in each case block, or else all the other calls will still run
		}
		case "5":{
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			displayMenu = false;
			break;
		}
		default: {
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~  That was not a valid input!  ~~~~~~~~~~~~~~~~~~~~~~"); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();							
			break;
		}
	}
}


	
	
	
	


}
