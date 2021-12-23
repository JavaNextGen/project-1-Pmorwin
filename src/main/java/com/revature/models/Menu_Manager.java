package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.FoodDAO;
import com.revature.repositories.LodgingDAO;
import com.revature.repositories.TravelDAO;
import com.revature.util.ClearConsole;
import com.revature.repositories.MiscellaneousDAO;





public class Menu_Manager {

	EmployeeDAO eDAO = new EmployeeDAO();
	FoodDAO fDAO = new FoodDAO();
	LodgingDAO lDAO = new LodgingDAO();
	TravelDAO tDAO = new TravelDAO();
	MiscellaneousDAO mDAO = new MiscellaneousDAO();
	
	//All of the menu display optinos and control flow are contained within this method
	public void displayMenu() {
		
		boolean displayMenu = true;//We are going to use this to toggle whether the menu continues after user input
		
		Scanner scan = new Scanner(System.in); //This is a scanner object to parse (take) user input
	
		ClearConsole cc = new ClearConsole();

		//give the user a nice greeting

		
		//display the menu as long as the displayMenu boolean == true
		//this is going to hold and display all my menu options until displayMenu == flase
		while(displayMenu) {
			
			cc.clearConsole();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~  Welcome to the Employee Reinbursement Review System  ~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~  Hello, which type of reinbursement requests would you like to view?  ~~ ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1: LODGING");
			System.out.println("2: TRAVEL");
			System.out.println("3: FOOD");
			System.out.println("4: Miscellaneous");
			System.out.println("5: EXIT");
			
			//parse user input after they choose a menu option, and put it into a String variable
			int input = scan.nextInt();
			
			//Switch statement that takes the user input and executes the appropriate code
			
			switch(input) {
				
				case 1: {
					//need to get the list of employees from the repository layer
					List<Lodging> lodging = lDAO.getLodging();
					
					//enhanced for loop to print out the Employees one by one
					for(Lodging l : lodging) {
						System.out.println(l);
					}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case 2: {
					//need to get the list of employees from the repository layer
					List<Travel> travel = tDAO.getTravel();
					
					//enhanced for loop to print out the Employees one by one
					for(Travel t : travel) {
						System.out.println(t);
					}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case 3: {
					//need to get the list of employees from the repository layer
					List<Food> food = fDAO.getFood();
					
					//enhanced for loop to print out the Employees one by one
					for(Food f : food) {
						System.out.println(f);
					}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case 4: {
					//need to get the list of employees from the repository layer
					List<Miscellaneous> miscellaneous = mDAO.getMiscellaneous();
					
					//enhanced for loop to print out the Employees one by one
					for(Miscellaneous m : miscellaneous) {
						System.out.println(m);
					}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case 5:{
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Have a wonderful day!"); 
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					displayMenu = false;
					break;
				}
				default: {
					System.out.println("That was not a valid response, please try again");
				}
			
				
				}//end of switch statement
			}
		}
	}		
