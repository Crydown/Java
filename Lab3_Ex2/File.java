/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3_Ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ciprian
 */
public class File {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
        
        System.setProperty("user.dir", "D:\\NetBeans\\Filews");    // set default directory

    
       System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
    
    /*
    File folder = new File("D:\\NetBeans\\Filews");
    File[] listOfFiles = folder.listFiles();
    
    
    for(int i = 0; i < listOfFiles.length;i++){
        if(listOfFiles[i].isFile()){
             System.out.println("File " + listOfFiles[i].getName());
        }
        else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
    }
            
        }
        
    
        
      */
    
   // list1();
   //list2();
   // list3();
   //create();
   // delete();
   
  // rename(new File("D:\\NetBeans\\Filews\\a"));
  // rename();
  //   merge();
  //  info();
    }
    
    public static void list1(){

        System.out.println("Introduce directory ");
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
    
    public static void list3() throws FileNotFoundException{        // list content of file
        
        Scanner s = new Scanner(new java.io.File("D:\\NetBeans\\Filews\\Miike.txt"));
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
        System.out.println("Introduce file path to display from");
        file = keyboard.next();       
        
        System.setProperty("user.dir", file);    // set default directory

    
       System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        
        
    }
    
//    public static void create(){
//        
//       
//        new File("D:\\NetBeans\\Filews").mkdirs();
//        File theDir = new File("new folder");
//
//// if the directory does not exist, create it
//if (!theDir.exists()) {
//    System.out.println("creating directory: " + theDir.getName());
//    boolean result = false;
//
//    try{
//        theDir.mkdir();
//        result = true;
//    } 
//    catch(SecurityException se){
//        //handle it
//    }        
//    if(result) {    
//        System.out.println("DIR created");  
//    }
//}
//    
//    }
    
    public static void create(){
        
        java.io.File dir = new java.io.File("D:\\NetBeans\\Filews\\b\\dsad");
        java.io.File dir2 = new java.io.File("D:\\NetBeans\\Filews\\c");
        dir.mkdir();
        dir2.mkdir();
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
    
//    public static void rename(){
//        
//        File folder = new File("D:\\NetBeans\\Filews\\a");
//        File[] listOfFiles = folder.listFiles();
//        
//        for(int i = 0; i < listOfFiles.length; i++){
//            
//            System.out.println(listOfFiles[i].getName());
//            
//            if(listOfFiles[i].isFile()){
//                System.out.println("HERE");
//                File f = new File("D:\\NetBeans\\Filews\\a"+listOfFiles[i].getName());
//               // f.renameTo(new File("D:\\NetBeans\\Filews\\a\\renamed"));
//                f.renameTo(new File("D:\\NetBeans\\Filews\\a\\"+i+".txt"));
//            }
//           
//            
//            
//        }
//        System.out.println("conversion is done");
//        
//    }
    
    
   public static void rename(){
       
//       String absolutePath = "D:\\NetBeans\\Filews\\a";
//       File dir = new File(absolutePath);
//        File[] filesInDir = dir.listFiles();
//        int i = 0;
//        for(File file:filesInDir) {
//            i++;
//            String name = file.getName();
//            String newName = "my_file_" + i + ".txt";
//            String newPath = absolutePath + "\\" + newName;
//            file.renameTo(new File(newPath));
//            System.out.println(name + " changed to " + newName);
//        }
        
        String path = "D:\\NetBeans\\Filews\\a";
        java.io.File dir = new java.io.File(path);
        int i = 0;
        java.io.File[] files = dir.listFiles();
        for(java.io.File file:files){
            i++;
            
            String newName = "my_file_v2_" + i + ".txt";
            String newPath = path + "\\" + newName;
            file.renameTo(new java.io.File(newPath));
        }
        
        
        
   } 
   
   
     public static void merge() throws FileNotFoundException, IOException{
         
         PrintWriter pw = new PrintWriter("D:\\NetBeans\\Filews\\a\\file3.txt");
         
         BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans\\Filews\\a\\file2.txt"));
         String line = br.readLine();
         
         while (line != null) 
        { 
            pw.println(line);
        //    pw.println("Me wrote this");   --- this is stored in .txt
            line = br.readLine(); 
        } 
         
         br = new BufferedReader(new FileReader("D:\\NetBeans\\Filews\\a\\file2.txt"));
         line = br.readLine();
         
          while (line != null) 
        { 
            pw.println(line); 
            line = br.readLine(); 
        } 
         
         
        pw.flush();
        
        br.close();
        pw.close();
        
        System.out.println("Merged file1.txt and file2.txt into file3.txt"); 
         
     }
     
     public static void info(){
         
      //   String filename = JOptionPane.showInputDialog("Enter filename: ");
	//	File f = new File(filename);
                java.io.File f = new java.io.File("D:\\NetBeans\\Filews\\a\\file3.txt");
		System.out.println("File exists: "+f.exists());
		System.out.println("File is readable: "+f.canRead());
		System.out.println("File is writable: "+f.canWrite());
		System.out.println("Is a directory: "+f.isDirectory());
		System.out.println("length of the file: "+f.length()+" bytes");
		
		try
		{
			char ch;
			StringBuffer buff = new StringBuffer("");
			FileInputStream fis = new FileInputStream("D:\\NetBeans\\Filews\\a\\file3.txt");
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
