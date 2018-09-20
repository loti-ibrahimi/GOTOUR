/*	Created by Loti Ibrahimi on 05-06-2018.
 *	Student Number: W20015453
 * Project Name: GOTOUR, Tourist Attraction manager.
 *
 *	Bugs | Issues | Info
 * 
 * 
 * 	- Code Summary- :
 *  (Code that works)
 * 	# Add: 
 * 	# Remove: 
 * 	# Search/List: 
 * 	# Edit/Update:   
 *  	
 *  
 * - Description -: 
 * 

 * 
 * 
 */

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.beans.XMLEncoder;
//import java.beans.XMLDecoder;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TouristAttractionAPI {
	
	Scanner scan = new Scanner(System.in);
	private Scanner input;
	TourList tourList = new TourList();
	
    TouristAttraction ta;

    
    public TouristAttractionAPI(){
    	input = new Scanner(System.in);
    } 
    
	public static void main (String args[]){
       	TouristAttractionAPI app = new TouristAttractionAPI();
       	System.out.println("");
        System.out.println(" ... GOTOUR ONLINE ...");
        System.out.println("");
       	app.runTouristAttractionAPI();
       	}
	
//=========================================================== MENUS ================================================================================
		
		public void printMenuHeader() {
	        System.out.println("+=======================================================+");
	        System.out.println("|                     * GOTOUR *                        |");
	        System.out.println("|                  Creator: Loti Ibrahimi               |");
	        System.out.println("+=======================================================+");
	        System.out.println("");
	        System.out.println("~ Hi there! Welcome to GOTOUR, the app that lets you store \n all your favourite Tourist Attractions!");
	        System.out.println("");
		}
		
	    
	    public int MainMenu() 
	    {
	    	System.out.println("+========================================================+");
			System.out.println("|                     * Main Menu *                      |");
			System.out.println("+========================================================+");
			System.out.println("");
			System.out.println(" What would you like to do? Please choose an option below:");
			System.out.println("------------");
			System.out.println(" 1) |Add new Tourist Attraction|");
			System.out.println("------------");
			System.out.println(" 2) |Remove an existing Tourist Attraction from list|");
			System.out.println("------------");
			System.out.println(" 3) |Update existing Tourist Attraction|");
			System.out.println("------------");
			System.out.println(" 4) |List all Tourist Attractions w/ Details.|");
			System.out.println(" 5) |List all Tourist Attractions w/ Details Alphabetically.|");
			System.out.println(" 6) |List all Tourist Attractions w/ Details by Cost.|");
			System.out.println("------------");
			System.out.println(" 7) |Export to XML|");
			System.out.println(" 8) |Load existing XML file|");
			System.out.println("------------");
	        System.out.println(" 0) Exit"); 
	        System.out.print("==>> \n ");	
	        int option = input.nextInt();
	        return option; 
		}
	    
//============================================================ RUN MENUS ===========================================================================

	    
		// Running Property Menu
		public void runTouristAttractionAPI(){
			printMenuHeader();
			int option = MainMenu();
				while (option != 0) {
					switch (option) {
	                	case 1:
	                		addTouristAttraction();
	                		break;
	                	case 2:
	                		removeTouristAttraction();
	                		break;
	                	case 3:
	                		editTouristAttraction();
	                		break;
	                	case 4:
	                		listTouristAttractions();
	                		break;
	                	case 5:
	                		listTouristAttractionsAlphb();
	                		break;
	                	case 6:
	                		listTouristAttractionsCost();
	                		break;
	                	case 7:
	                		exportToXML();
	                		break;
	                	case 8:
	                		loadFromXML();
	                		break;
	                	default:
	                		noSuchChoiceErrorMessage();
	                        break;
						}
					//entered this in to reset option count, a case problem occured
					option = MainMenu(); 
				}
				//the user choose option 0, so exit the program
				System.out.println("Exiting... see you soon!");
		    	System.exit(0);
	        }

		


//=======================================================================================================================================================
		
		//Method for Menu inputs
		
//=======================================================================================================================================================
		
		private void addTouristAttraction() {
			System.out.println("+===========================+");
			System.out.println(" Please enter place name: ");
			String name = input.nextLine();
			name = input.nextLine();		// Known input bug, requires [enter] x2 to display next. 
			
			System.out.println("Please enter the date " + name + " was established:");
			String estb = input.nextLine();
			
			System.out.println("Please enter a description of " + name + ": ");
			String dscrip = input.nextLine();
			
			System.out.println("Please enter the location of " + name + ":");
			String location = input.nextLine();
//			location = input.nextLine();
			
			System.out.println("Cost of Entry (in €):");
			String coe = input.nextLine();
				
			tourList.addTA(name, estb, dscrip, location, coe);
		}
		
		
		public void removeTouristAttraction(){
	        // finds Movie, then will execute removal.
	        tourList.removeTAByName(taFinderTool()); // brings in movieFinderTool() which checks the user input to see if move chosen for removal is valid.
	    }
		
		
		// Bug with outputs... 
		public void editTouristAttraction() {
			System.out.println("+=======================================================+"); 
			System.out.println(" Please enter the Tourist Attraction you wish to update: "); 
			String taName = input.nextLine();    
			taName = input.nextLine();		
			
			TouristAttraction ta = tourList.findTAByName(taName);
			System.out.println(ta.toString()); //displays the detail of the chosen movie (if found).
			
			if (ta != null) {
				ta = null; // Removes the Tourist Attraction found
				
				// Prompts to add the new Tourist Attraction. (basically update to new Tourist Attraction)
				System.out.println("+===========================+");
				System.out.println(" Update Tourist Attraction name: ");
				String name = input.nextLine();
				name = input.nextLine();		// Known input bug, requires [enter] x2 to display next. 
				
				System.out.println("Update the date " + name + " was established:");
				String estb = input.nextLine();
				
				System.out.println("update the description of " + name + ": ");
				String dscrip = input.nextLine();
				
				System.out.println("Update the location of " + name + ":");
				String location = input.nextLine();
				location = input.nextLine(); 
				
				System.out.println("Cost of Entry (in €):");
				String coe = input.nextLine();
					
				tourList.addTA(name, estb, dscrip, location, coe);
	        }
		}
		
		
		// List out all Tourist Attractions w/ details.
		private void listTouristAttractions() {
	        if (!tourList.isEmpty()){
	            for (TouristAttraction ta : tourList) {
	            	System.out.println("+=====================================+");
	            	System.out.println("|          TOURIST ATTRACTION         |");
	            	System.out.println("+=====================================+");
	                System.out.println(ta.toString());
	                System.out.println("---------------------------------------");
	            System.out.println("-=========================================-");
	            }
	        }
	    }
		
		
		//????????
		// List out all Tourist Attractions w/ details in alphabetical order.
		private void listTouristAttractionsAlphb() {
	        if (!tourList.isEmpty()){
	            for (TouristAttraction ta : tourList) {
	            	System.out.println("+==================================================+");
	            	System.out.println("|          TOURIST ATTRACTION - Alphabetically     |");
	            	System.out.println("+==================================================+");
	                System.out.println(ta.toString());
	                System.out.println("----------------------------------------------------");
	            System.out.println("-======================================================-");
	            }
	        }
	    }
		
		// List out all Tourist Attractions w/ details.
		private void listTouristAttractionsCost() {
	        if (!tourList.isEmpty()){
	            for (TouristAttraction ta : tourList) {
	            	System.out.println("+==========================================+");
	            	System.out.println("|          TOURIST ATTRACTION - Cost       |");
	            	System.out.println("+==========================================+");
	                System.out.println(ta.toString());
	                System.out.println("--------------------------------------------");
	            System.out.println("-==============================================-");
	            }
	        }
	    }
		
		// XML Import/export Incomplete...
		// XML Export
		public void exportToXML() {
			try {
				FileOutputStream fos = new FileOutputStream(new File("./ta.xml"));
				XMLEncoder encoder =  new XMLEncoder(fos);
				encoder.writeObject(tourList);
				encoder.close();
				fos.close();
			}
			
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
			
		
		// XML Load
		private void loadFromXML() {
			
		}
	
//=======================================================================================================================================================
		// Simple tools created, to be used (Cuts down on repetition) by creating general methods.
//=======================================================================================================================================================
		
		// Scans input to see if valid input.
		private String scanStringTool() {
	        boolean validInput = false; // Empty input of no entry, i.e "" (validInput) is set as false.  
	        String input = ""; 
	        while (!validInput) {
	            try {
	                input = scan.nextLine();  // If input is not a validInput, i.e not empty, e.g "Break". 
	                validInput = true;  // Set validInput as true.
	            } catch (Exception e) {
	                scan.nextLine(); // Checks to see if input is validInput, i.e empty, e.g "". 
	                System.out.println(" Bad Entry - please try again.");  // If its empty, it prompts user to try again with new input.
	            }
	        }
	        return input;
	    }
			
		
		// Tool used to find Tourist Attractions, cuts down on code repetition.
	    public String taFinderTool(){
	        System.out.println("+=========================================+");
	        System.out.println("Please enter the name of Tourist Attraction you seek:");
	        System.out.print("==> ");
	        return scanStringTool();
	    }
   
	   
	 // Returns an error message if user has selected a non-existent option.
	    private void noSuchChoiceErrorMessage() {
	        System.out.println("! Selection Error, please try again. !");
	    }
}