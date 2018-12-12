/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees;

import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ciprian
 */
public class Employee {
    
    int number;
    String name;
    double salary;
    String employmentDate;
    String adress;
    String phoneNo;
    int enteredNum;
    double enteredNumDouble;
  //  String enteredString; 
    
    Scanner keyboard = new Scanner(System.in);
    
    void salary_change(double amount){
        
        salary = amount; 
        
    }

    void address_change(String amount){
        
        adress = amount; 
        
    }
    
   void phoneNo_change(String change){
       
       phoneNo = change;
       
   }
    
   void employmentDate_change(String change){
       
       employmentDate = change;
       
   }
   
   void delete_employee(ArrayList<Employee> emp, int index){
       
       emp.remove(index + 1);
       
       
   }
   
   void get_info(ArrayList<Employee> emp){
       
       
       int j = 0;
       System.out.println("All the employee information is:");
		for(Employee employee: emp)
		{       
                    
                    if(employee.getName() == null){
                        
                        j++;
                        
                        if(j == emp.size()-1){
                        
                        System.out.println("Database is empty!");
                        }
                    }
                    else{
			System.out.println("#"+ (j + 1) + ": " + employee.getName());
			j++;
		}
            }
       
   }
   
   
    
    public Employee(int number, String name, double salary, String employmentDate, String adress, String phoneNo) {
        this.number = number;
        this.name = name;
        this.salary = salary;
        this.employmentDate = employmentDate;
        this.adress = adress;
        this.phoneNo = phoneNo;
    }
    
    public Employee(){
        
        this.number = -1;
        this.name = null;
        this.salary = -1;
        this.employmentDate = null;
        this.adress = null;
        this.phoneNo = null;
        
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    void search_Employee(ArrayList<Employee>emp , String name){
       
       for(Employee employee: emp)
		{
                    if(employee.getName().equals(name)){
                        
                        System.out.println("Employee found!");
                        System.out.println("Number is: " + employee.getNumber());
                        System.out.println("Salary is: " + employee.getSalary());
                        System.out.println("Phone No is: " + employee.getPhoneNo());
                        System.out.println("Address is: " + employee.getAdress());
                       
                    }
                    else
                        System.out.println("Employee not found");
		}
       
       
       
   }
    
    public void delete_employee(ArrayList<Employee>emp , String name){
        
        for(Employee employee: emp)
		{
                    
                    if(employee.getName().equals(name)){
                        
                        System.out.println("Employee found and deleted");
                        employee.setName( null);
                        employee.setNumber(-1);
                        employee.setAdress(null);
                        employee.setEmploymentDate(null);
                        employee.setPhoneNo(null);
                        
                       
                    }
                    else
                        System.out.println("Employee not found in order to be deleted");
                    
                
                }
        
        
    }
    void create_new(ArrayList<Employee> emp)
    {
    	int empNum = 0;
        
//        int number;
//    	double salary;
//    	String name;
//        String adress;
//        String phoneNo;
//        String employmentDate;
        
        
        
    	// Propts user for how many employees 
		System.out.print("How many Employee's would you like to create?:");
	//	empNum = keyboard.nextInt();
                empNum = checkInt();
    	// Creating each object to add the object array 
		for(int i = 0; i < empNum; i++)
		{
                    
                System.out.printf("What is Employee Number?: ");
	//	   number = keyboard.nextInt(); 
		number = checkInt(); 
		System.out.printf("What is Employee Name?: ");
		name = keyboard.next();
		System.out.printf("\nWhat is %s's Salary?: ", name);
		salary = checkDouble();
                
                
		System.out.printf("\nWhat is %s's employmentDate?: ", name);
		adress = keyboard.next();
                System.out.printf("\nWhat is %s's Address?: ", name);
		phoneNo = keyboard.next();
                System.out.printf("\nWhat is %s's phoneNo: ", name);
		employmentDate = keyboard.next();
                System.out.println();
		emp.add(new Employee(number,name,salary,employmentDate,adress,phoneNo));
					
				}
	
    
}
    
    
    public int checkInt()
	{
		do {
			while(!keyboard.hasNextInt())
			{
				System.out.println("That is not a number!");
				keyboard.next();
			}
			enteredNum = keyboard.nextInt();
		}while (enteredNum <= 0);

		return enteredNum;
	}
    
    
    public int checkDouble()
	{
		do {
			while(!keyboard.hasNextDouble())
			{
				System.out.println("That is not a number!");
				keyboard.next();
			}
			enteredNumDouble = keyboard.nextDouble();
		}while (enteredNum <= 0);

		return enteredNum;
	} 
    
        
}
