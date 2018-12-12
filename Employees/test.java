/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees;

// import Employee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ciprian
 */
public class test {
    
    static void view_menu()
	{

		System.out.println("\n\n-------------------------------------");
        System.out.println("|    Employee Interaction Menu      |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("|   Select number and press enter   |");
        System.out.println("|       to perform operation        |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("| 1.) Create New Employee           |");
        System.out.println("| 2.) Modify Employee Information   |");
        System.out.println("| 3.) Delete an Employee            |");
        System.out.println("| 4.) List Current Employees        |");
        System.out.println("| 5.) Search an Employee            |");
        System.out.println("| 6.) View Menu                     |");
        System.out.println("| 7.) Exit Program!                 |");
        System.out.println("|                                   |");
        System.out.println("-------------------------------------");
	}

	static Scanner console = new Scanner(System.in);
    
        public static void main(String args[]) throws IOException
	{
            
            Employee mEmployee = new Employee();
		boolean programOn = true;
		int userMenuOption;
		int empNum, index;
                String change, search;
                char check;
                String name;

		// Creates an Object Arraylist based on number of employees to create
		ArrayList<Employee> emp = new ArrayList<Employee>();
                
                mEmployee.create_new(emp);

		// Call view_menu() method to display menu on screen
		view_menu();
            
                while(programOn)
		{
			// Prompt and accept menu options and execute them in the switch statement
			System.out.print("\nSelect a menu option (5 for list options): ");
			System.out.println();
			userMenuOption = console.nextInt();
			
			switch(userMenuOption)
			{
				case 1:
				{
					// Call the creat_new()method with emp ArrayList as argument
					mEmployee.create_new(emp);
					break;
				}

				case 2:
				{
					Double amount;
					// Ask user which employee they want to change while checking for valid data entry
					System.out.print("Enter Employee # whos information do you want to change: ");
					empNum = console.nextInt();
		
					// Checks to see if the number enter is a valid ID by comparring length of 
					// Arraylist to the number enter
					if (empNum > emp.size())
					{
						// If not valid inform User while giving them option to display list
						System.out.println("Not a Valid Employee ID! Press 3 for Employee List.");
						break;
					}			
					else
					{
						// If valid decrease number by one for accurate array position
						empNum -= 1;

						// Ask amount user wants to adjust salary by and check for valid input
						System.out.print("Enter new salary ");
						amount = console.nextDouble();
                                                emp.get(empNum).salary_change(amount);
                                                
                                                System.out.print("Enter new address");
                                                change = console.next();
                                                emp.get(empNum).address_change(change);
                                                						
                                                System.out.print("Enter new phoneNo ");
						change = console.next();
                                                emp.get(empNum).phoneNo_change(change);
                                                
                                                System.out.print("Enter new employmentDate ");
						change = console.next();
                                                emp.get(empNum).employmentDate_change(change);
					}

					//Takes the valid arraylist number and returns that object then runs 
					// the salary_change(amount) method on that object with amount entered above
                                        //emp.get(empNum).salary_change(amount);

					break;
				}

				case 3:
				{
                                    
                                    //delete employee
                                        System.out.print("Introduce employee name for delete.");
                                        name = console.next();
					mEmployee.delete_employee(emp, name);
					break;
                                    
					
				}
				case 4:
				{
					//call the get_info() method with emp ArrayList as argument
					mEmployee.get_info(emp);
					break;
				}
				
                                case 5:
				{       
                                        // Check if employee name or number is in database	
                                        System.out.println("Introduce name? Y/N");
                                        check = (char)System.in.read();
                                        if((check == 'Y')||(check == 'y')){
					System.out.println("Introduce name of employee for search");
					//empNum = console.nextInt();
                                        search = console.next();
                                        mEmployee.search_Employee(emp, search);
                                        }
                                        
                               
									                                       
					break;
				}
                                
                                case 6:
				{
					// Display menu on screen
					view_menu();
					break;
				}

				case 7:
				{
					// Set programOn Boolean to false to end loop and exit program
					System.out.println("Program Exited!");
					programOn = false;
					break;
				}
                        }
                    }
        }
}

