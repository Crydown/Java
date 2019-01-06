/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5_Ex2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import static java.lang.reflect.Array.set;
import java.util.Set;

/**
 *
 * @author Ciprian
 */
public class Dictionary implements java.io.Serializable{
    
    String word, definition;
    
    public static void add(HashMap dict){
        
        String word, definition;
        
        Scanner keyboard = new Scanner(System.in);
        
        
        System.out.println("Introduce word");
        word = keyboard.next();
         System.out.println("Introduce definition");
        definition = keyboard.next();
        
        dict.put(word, definition);
        
        
    } 
    
    static void view_menu()
	{

		System.out.println("\n\n-------------------------------------");
        System.out.println("|   Dictionary Interaction Menu     |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("|   Select number and press enter   |");
        System.out.println("|       to perform operation        |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                                   |");
        System.out.println("| 1.) Introduce word                |");
        System.out.println("| 2.) Search word                   |");
        System.out.println("| 3.) Print whole dictionary        |");
        System.out.println("| 4.) Exit                          |");
        System.out.println("| 5.) Save on disk                  |");
        System.out.println("| 6.) Restore dictionary            |");
        System.out.println("-------------------------------------");
	}
    
       static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String args[]){
        
        
        HashMap<String,String> dictionary = new HashMap <String,String>(20);
        //Adding vocabulary into the dictionary
		dictionary.put("newfag", "Any new person, or thing, to enter a site.");
		dictionary.put("oldfag", "An Oldfag is  is a user of an online community who has been with the community a considerable amount of time");
		dictionary.put("sage","A word originating from the popular Japanese forum website 2chan.\n Sage (pronounced \"sah-geh\") - from the Japanese word \"sageru\",\n"+
		 "refers to replying to a post using the word \"sage\" in the email field in order to increase the number of replies without age-ing (or bumping) the post.\n"+
		  "This can be used as a courtesy, allowing one to quietly add comments that may not be interesting enough to warrant pushing the thread to the top. It can also be used as a way to show displeasure with the post being replied to.");
		dictionary.put("lurk","On a messageboard or anything similar, to browse the board very often, but without ever posting anything.");
		dictionary.put("over9000","A phrase that people use for something of impressive power, skill or just general fun.");
        
        boolean programOn = true;
        
        view_menu();
        
        String input;
        int no;
        String filename;
        
        
        
        
        
        
        do{
            
        System.out.println("Introduce option!");    
        no = keyboard.nextInt(); 
        
        switch(no){
            
            case 1:
//            System.out.println("Introduce word ");
//            input = keyboard.nextLine();
            Dictionary.add(dictionary);
            break;
            
            case 2:
                System.out.println("Introduce word");
                input = keyboard.next();
                
                    if ( dictionary.containsKey(input) ) {
				String definition = dictionary.get(input);
				System.out.println("input: \n" + definition);
			}else
                        {
				System.err.println("Word not found");
			}
            
                    
                 break;
                 
            case 3:
                Iterator it = dictionary.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " ----> " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
                
                
                
                
                break;
                
            case 4:                System.out.println("Program Exited!");
					programOn = false;
					break;
                                        
            case 5:     
                        System.out.println("Saving dictionary on disk to D:\\NetBeans\\dict.ser");
                        saveOnDisk(dictionary,"D:\\NetBeans\\dict.ser");
                        break;
                        
            case 6: 
                     
                        System.out.println("Restoring dictionary");
                        restore();
                        break;
                        }
        }while(programOn);
        

    }
    
     
    public static void saveOnDisk(HashMap<String,String> dict, String filename){
        
        
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(dict); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
    
    
    
    }
    
    
    public static void restore(){

    // HashMap<String, String> map = new HashMap<String, String>(20);

    HashMap<String, String> map = null;
    
      try
      {
         FileInputStream fis = new FileInputStream("D:\\NetBeans\\dict.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized HashMap..");
      // Display content using Iterator
     
      Set set = map.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key: "+ mentry.getKey() + " & Value: ");
         System.out.println(mentry.getValue());
      }
       
    }
     
    }

