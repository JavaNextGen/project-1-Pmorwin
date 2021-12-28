package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.FoodDAO;
import com.revature.repositories.LodgingDAO;
import com.revature.repositories.TravelDAO;
import com.revature.services.EmployeeService;
import com.revature.services.FoodService;
import com.revature.services.LodgingService;
import com.revature.services.MiscellaneousService;
import com.revature.services.TravelService;
import com.revature.util.ClearConsole;
import com.revature.repositories.MiscellaneousDAO;



@SuppressWarnings("unused")
public class Menu_Manager{

	EmployeeDAO eDAO = new EmployeeDAO();
	FoodDAO fDAO = new FoodDAO();
	LodgingDAO lDAO = new LodgingDAO();
	TravelDAO tDAO = new TravelDAO();
	MiscellaneousDAO mDAO = new MiscellaneousDAO();
	EmployeeService eServices = new EmployeeService();
	FoodService fs = new FoodService();
	LodgingService ls = new LodgingService();
	TravelService ts = new TravelService();
	MiscellaneousService ms = new MiscellaneousService();
	Menu_Employee e_menu = new Menu_Employee();
	
	//All of the menu display optinos and control flow are contained within this method
	public void displayMenu() {
		
		boolean displayMenu = true;//We are going to use this to toggle whether the menu continues after user input
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); //This is a scanner object to parse (take) user input
	
		//give the user a nice greeting

		
		//display the menu as long as the displayMenu boolean == true
		//this is going to hold and display all my menu options until displayMenu == flase
		while(displayMenu) {
			
			//ClearConsole.clearConsole();
			System.out.println();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~  Welcome to the Employee Reinbursement Review System  ~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~  What would you like to do?  ~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1: Approve/Deny Reinbursement Requests");
			System.out.println("2: View Request History by Category");
			System.out.println("3: View Request History by Employee");
			System.out.println("4: Enter New Employee into the System");
			System.out.println("5: Input a Reinbursement Request");
			System.out.println("6: Exit the Program");
			System.out.println();
			String input = scan.nextLine();//user input
			
			//Switch statement that takes the user input and executes the appropriate code
			
			switch(input) {
				
				case "1": {
					
					boolean nestedWhile = true;
					while (nestedWhile) {
						System.out.println();
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~  Which category of reinbursement requests would you like to review?  ~~~");
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
								boolean doubleNested = true;
								while (doubleNested) {
									//need to get the list of employees from the repository layer
									List<Lodging> lodging = lDAO.getSingleLodging();
									//enhanced for loop to print lodging req
									for(Lodging l : lodging) {
										System.out.println(l);
									}
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
									System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
									System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									String statusChange = scan.nextLine();
									switch(statusChange) {
										case "1":{
											int decision = 1;
											int lodging_id = lodging.get(0).getLodging_id();
											ls.updateLodging(decision, lodging_id);
											break;
										}
										case "2":{
											int decision = 2;
											int lodging_id = lodging.get(0).getLodging_id();
											ls.updateLodging(decision, lodging_id);
											break;
										}
										case "3":{
											System.out.println();
											System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
											System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
											System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
											System.out.println();
											doubleNested = false;
											nestedWhile = false;
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
								}
								break;
							}
							case "2": {
								boolean doubleNested = true;
								while (doubleNested) {
								//need to get the list of employees from the repository layer
								List<Travel> travel = tDAO.getSingleTravel();
								//enhanced for loop to print out the Employees one by one
								for(Travel t : travel) {
									System.out.println(t);
								}
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								String statusChange = scan.nextLine();
								switch(statusChange) {
									case "1":{
										int decision = 1;
										int travel_id = travel.get(0).getTravel_id();
										ls.updateLodging(decision, travel_id);
										break;
									}
									case "2":{
										int decision = 2;
										int travel_id = travel.get(0).getTravel_id();
										ls.updateLodging(decision, travel_id);
										break;
									}
									case "3":{
										System.out.println();
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println();
										doubleNested = false;
										nestedWhile = false;
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
							}
								break;//we need a break in each case block, or else all the other calls will still run
							}
							case "3": {
								boolean doubleNested = true;
								while (doubleNested) {
								//need to get the list of employees from the repository layer
								List<Food> food = fDAO.getSingleFood();
								//enhanced for loop to print out the Employees one by one
								for(Food f : food) {
									System.out.println(f);
								}
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								String statusChange = scan.nextLine();
								switch(statusChange) {
									case "1":{
										int decision = 1;
										int food_id = food.get(0).getFood_id();
										ls.updateLodging(decision, food_id);
										break;
									}
									case "2":{
										int decision = 2;
										int food_id = food.get(0).getFood_id();
										ls.updateLodging(decision, food_id);
										break;
									}
									case "3":{
										System.out.println();
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println();
										doubleNested = false;
										nestedWhile = false;
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
							}
							break;//we need a break in each case block, or else all the other calls will still run
							}
							case "4": {
								boolean doubleNested = true;
								while (doubleNested) {
								//need to get the list of employees from the repository layer
								List<Miscellaneous> miscellaneous = mDAO.getSingleMiscellaneous();
								//enhanced for loop to print out the Employees one by one
								for(Miscellaneous m : miscellaneous) {
									System.out.println(m);
								}
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								String statusChange = scan.nextLine();
								switch(statusChange) {
									case "1":{
										int decision = 1;
										int misc_id = miscellaneous.get(0).getMisc_id();
										ls.updateLodging(decision, misc_id);
										break;
									}
									case "2":{
										int decision = 2;
										int misc_id = miscellaneous.get(0).getMisc_id();
										ls.updateLodging(decision, misc_id);
										break;
									}
									case "3":{
										System.out.println();
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
										System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
										System.out.println();
										doubleNested = false;
										nestedWhile = false;
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
							}
								break;//we need a break in each case block, or else all the other calls will still run
							}
							case "5":{
								System.out.println();
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println();
								nestedWhile = false;
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
						break;//we need a break in each case block, or else all the other calls will still run
					}
					break;
				}
				case "2": { //This case statement only SHOWs the requests to the user
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
								List<Lodging> lodging = lDAO.getLodging();
								
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
								List<Travel> travel = tDAO.getTravel();
								
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
								List<Food> food = fDAO.getFood();
								
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
								List<Miscellaneous> miscellaneous = mDAO.getMiscellaneous();
								
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
					break;
					}	
				case "3": {
					System.out.println();
					System.out.println("This Feature is not yet implemented");
					System.out.println();
					displayMenu = false;
					break;
				}
				case "4":{
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~  Welcome to Employee Creatation!  ~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~  Please Insert your Company Email  ~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String company_email = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("	You entered: " + company_email);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~  Please Insert your First Name  ~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String f_name = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("		You entered: " + f_name);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~  Please Insert your Last Name  ~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String l_name = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("		You entered: " + l_name);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~  Please Insert your Desired Username  ~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String employee_username = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("		You entered: " + employee_username);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~  Please Insert your Password  ~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String employee_password = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("		You entered: " + employee_password);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~  Please Insert your Role ID  ~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~  1 for Employee | 2 for Admin  ~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					String role_id = scan.nextLine();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("		You entered: " + role_id);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					Employee newEmployee = new Employee(company_email, f_name, l_name, employee_username, employee_password, Integer.parseInt(role_id));
					eServices.inputEmployee(newEmployee);
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~  Do you need anything else?  ~~~~~~~~~~~~~~~");
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
					break;
				}
				case "5":{
					e_menu.displayMenu();
				}
				
				
				
				case "6": {
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
				}
			}
		}
	}
}		

