/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3_Ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ciprian
 */




public class Ex2 {
    
    
 static void view_menu()
	{

	System.out.println("\n\n-------------------------------------");
        System.out.println("|    Shell Interaction Menu      |");
        System.out.println("|---------------------------------------|");
        System.out.println("|                                       |");
        System.out.println("|   Select number and press enter       |");
        System.out.println("|       to perform operation            |");
        System.out.println("|---------------------------------------|");
        System.out.println("|                                       |");
        System.out.println("| 1.) List files from a directory       |");
        System.out.println("| 2.) List files from current directory |");
        System.out.println("| 3.) List content of a file            |");
        System.out.println("| 4.) Change current directory          |");
        System.out.println("| 5.) Create a new directory            |");
        System.out.println("| 6.) Delete/rename file/directory      |");
        System.out.println("| 7.) Concatenate 2 or more files       |");
        System.out.println("| 8.) Disp information about a file/dir |");
        System.out.println("| 9.) View Menu                         |");
        System.out.println("| 10.) Exit Program!                    |");
        System.out.println("| 11.) Delete file/dir                  |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");
	}

    
    static Scanner console = new Scanner(System.in);
    
        public static void main(String args[]) throws IOException
	{
            
          //  Employee mEmployee = new Employee();
               
		boolean programOn = true;
		int userMenuOption;
		int empNum, index;
                String change, search;
                char check;
                String name;

		// Creates an Object Arraylist based on number of employees to create
	//	ArrayList<Employee> emp = new ArrayList<Employee>();
                
         //       mEmployee.create_new(emp);

		// Call view_menu() method to display menu on screen
		view_menu();
            
                while(programOn)
		{
			// Prompt and accept menu options and execute them in the switch statement
			System.out.print("\nSelect a menu option (9 for list options): ");
			System.out.println();
			userMenuOption = console.nextInt();
			
			switch(userMenuOption)
			{
				case 1:
				{
					// List files from a directory
					list1(); 
					break;
				}

				case 2:
				{       
                                        
					
                                        //List files from current directory
                                        list2();

					break;
				}

				case 3:
				{
                                    
                                    //List content of a file   
                                       list3();
                                    
					break;
                                    
					
				}
				case 4:
				{
					// Change current directory 
					changeDir();
					break;
				}
				
                                case 5:
				{       
                                       //Create a new directory 
                                       create();                               
									                                       
					break;
				}
                                
                                case 6:
				{
					// Rename file/directory
					rename();
				}

				case 7:
				{
					// Concatenate 2 or more files 
					merge();
					break;
				}
                                case 8:
                                        //Disp information about a file/dir
                                    
                                        
				{
                                     info();
                                     break;
				}
                                case 9:
				{
					// Display menu on screen
					view_menu();
					break;
				}
                                case 10:
				{
					// Set programOn Boolean to false to end loop and exit program
					System.out.println("Program Exited!");
					programOn = false;
					break;
				}
                                
                                 case 11:
				{
					// Delete dir
                                        System.out.println("Introduce directory/file to delete: ");
                                        Scanner keyboard = new Scanner(System.in);
                                        String dir;
                                        dir = keyboard.next();      
                                        java.io.File folder = new java.io.File(dir);
					delete(folder);
                                    
					break;
				}
                        }
                    }
        }
    
   
    public static void list1(){

        System.out.println("Introduce directory to list files from: ");
        Scanner keyboard = new Scanner(System.in);
        String dir;
        dir = keyboard.next();
        
        
        java.io.File folder = new java.io.File(dir);
        java.io.File[] listOfFiles = folder.listFiles();
    
    
    for(int i = 0; i < listOfFiles.length;i++){
        if(listOfFiles[i].isFile()){
             System.out.println("File " + listOfFiles[i].getName());
        }
        else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
    }
            
        }

}
    
    public static void list2(){
        
        System.out.println("Files in current directory: ");       
        java.io.File folder = new java.io.File(System.getProperty("user.dir"));
        java.io.File[] listOfFiles = folder.listFiles();
    
    
    for(int i = 0; i < listOfFiles.length;i++){
        if(listOfFiles[i].isFile()){
             System.out.println("File " + listOfFiles[i].getName());
        }
        else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
    }
            
        }
    }
    
    public static void list3() throws FileNotFoundException{
      
      String file; 
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Introduce file path to display from");
      file = keyboard.next();       
      Scanner s = new Scanner(new java.io.File(file));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
        list.add(s.next());
    }
s.close();

    for(int i =0;i<list.size();i++){
            
            System.out.println(list.get(i));
        }
        
    }
    
    public static void changeDir(){
        String file; 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce default directory");
        file = keyboard.next();       
        
        System.setProperty("user.dir", file);    // set default directory

    
       System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        
        
    }
        
    public static void create(){
        String file; 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce path for new directory including folder to be created - Path\\dir_name ");
        file = keyboard.next();       
        java.io.File dir = new java.io.File(file);
        dir.mkdir();
      
    }
    
   
    public static void delete(java.io.File file){
        
      //  File file = new File("D:\\NetBeans\\Filews\\b\\dsad");
        
        if(file.isDirectory())
        {
            
            if(file.list().length==0){
                
                file.delete();
                System.out.println("Directory deleted!");                      
            }
            
            else
            {
                
                String files[] = file.list();
                
                for(String temp: files){
                    
                    java.io.File fileDelete = new java.io.File(file, temp);
                    delete(fileDelete);
                    
                }
                 
            }
            if(file.list().length==0){
                
                file.delete();
                System.out.println("Directory deleted!");                      
            }
            
        }else{
            
        file.delete();
        System.out.println("File is deleted");
        }
        
                
        
        
        
    }
       
    
   public static void rename(){
               
      String path; 
      String newName;
      
     // String myfile;
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Introduce file/folder path:");
      path = keyboard.next(); 
      System.out.println("Introduce name of file/dir to be renamed dot extension: ");
      String fil = keyboard.next();
      File myfile = new File(path + "\\" + fil);      
      System.out.println("Introduce new name of file/dir");
      newName = keyboard.next();  
      
        java.io.File dir = new java.io.File(path);
        java.io.File[] files = dir.listFiles();
        for(java.io.File file:files){
           System.out.println(file);
           System.out.println(myfile);
           if(file.equals(myfile)){
          
           // System.out.println("Inside If");
            String newPath = path + "\\" + newName;
            file.renameTo(new java.io.File(newPath));
           }
        }  
        
   } 
   
   
     public static void merge() throws FileNotFoundException, IOException{
         
         String file1, file2, file3;
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Introduce path of path to store in:");
         file3 = keyboard.next(); 
         System.out.println("Introduce file1 to copy from:");
         file1 = keyboard.next(); 
         System.out.println("Introduce file2 to copy from:");
         file2 = keyboard.next(); 
         PrintWriter pw = new PrintWriter("D:\\NetBeans\\Filews\\" + file3 + ".txt");
         
         BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans\\Filews\\" + file1 + ".txt"));
         String line = br.readLine();
         
         while (line != null) 
        { 
            pw.println(line);
        //    pw.println("Me wrote this");   --- this is stored in .txt
            line = br.readLine(); 
        } 
         
         br = new BufferedReader(new FileReader("D:\\NetBeans\\Filews\\" + file2 +".txt"));
         line = br.readLine();
         
          while (line != null) 
        { 
            pw.println(line); 
            line = br.readLine(); 
        } 
         
         
        pw.flush();
        
        br.close();
        pw.close();
        
        System.out.println("Merged file1.txt and file2.txt into " +  file3 + ".txt"); 
         
     }
     
     public static void info(){
         
      //   String filename = JOptionPane.showInputDialog("Enter filename: ");
	//	File f = new File(filename);
                System.out.println("Enter file path + name + extension");
                Scanner keyboard = new Scanner(System.in);
                String file;
                file = keyboard.next();
                java.io.File f = new java.io.File(file);    
                //java.io.File f = new java.io.File("D:\\NetBeans\\Filews\\a\\file3.txt");
		System.out.println("File exists: "+f.exists());
		System.out.println("File is readable: "+f.canRead());
		System.out.println("File is writable: "+f.canWrite());
		System.out.println("Is a directory: "+f.isDirectory());
		System.out.println("length of the file: "+f.length()+" bytes");
		
		try
		{
			char ch;
			StringBuffer buff = new StringBuffer("");
			FileInputStream fis = new FileInputStream(file);
			while(fis.available()!=0)
			{
				ch = (char)fis.read();
				buff.append(ch);
			}
			System.out.println("\nContents of the file are: ");
			System.out.println(buff);
			fis.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the specified file...");
		}
		catch(IOException i)
		{
			System.out.println("Cannot read file...");
		}
	}
    
         
         
     }
    
    

    
  
    
    

