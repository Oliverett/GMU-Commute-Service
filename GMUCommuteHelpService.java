/* MIS 350 Project M4
 12/6/2023
 Project Team 2
 This program is a Service that gives user 3 options for help. 1:
 A comparison of different car models on how much money they spend on gas 
 per commute to GMU. 2: Display GMU shuttle times based on user preference shuttle
 3: A comparison between Personal car, Uber, and Taxi on on how much money they spend on gas 
 per commute to GMU.
*/


import java.util.Scanner;

public class GMUCommuteHelpService {
    private static Scanner input = new Scanner(System.in);
    // private static double commuteMpw;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Welcome output
        System.out.println("-----------------------------------------------------");
        System.out.println("WECLOME TO OUR GEORGE MASON UNIVERSTIY COMMUTE HELPER!");
        System.out.println("-----------------------------------------------------");

        boolean flag = true; 
        while (flag) {

           System.out.println("\n\n--------------SERVICES MENU--------------");
           System.out.println("1. COMPARE CAR-MODEL COMMUTE COSTS");
           System.out.println("2. GET MASON-SHUTTLE ROUTE INFORMATION");
           System.out.println("3. COMPARE TRANSPORTATION-METHOD COSTS ");
           System.out.println("4. EXIT ");
           System.out.println("-----------------------------------------");
          
           System.out.print("\nSELECT A SERVICE (1-4): ");
           if (input.hasNextInt()) {
            int userService = input.nextInt(); 
            
            switch(userService){
               case 1: displayCommuteCost(); break; 
               case 2: displayShuttleInfo(); break;
               case 3: methodComparison(); break;
               case 4: flag = false; break; 
               default: System.out.println("\n****Invalid service number. Please try again.****"); break;
            }   
            
            } else {
               System.out.println("\n\n****INVALID INPUT****");
               input.nextLine();
            }
      
        }
    }

    public static void displayCommuteCost() {
         
        // Models & there mpg 
        double suvMpg = 29.0;
        double coupeMpg = 24.0;
        double sedanMpg = 31.7;
        double pickupMpg = 20.6;
        double minivanMpg = 22.0;
        double parkingPermitCostpw = 0;
        
        
        // Current Gas prices
        double gasPrice = 3.20;
        
        // USER prompts for visitsperweek, commutempw etc. 
        System.out.println("\n-----------------------------------------------------");  
        System.out.print("How many times do you drive to George Mason each week: ");
        int visitsPerWeek = input.nextInt();

        input.nextLine();

        System.out.println("\n---------------------------------------------------");
        System.out.print("How many miles away is your home from George Mason: ");
        double milesPerCommute = input.nextDouble() * 2;
        double commuteMpw = milesPerCommute * visitsPerWeek;
        
        System.out.println("\n-----------------------------------------");  
        System.out.print("How many weeks is your current Semester: ");
        double weeksInSem = input.nextDouble();
        
           // user prompt for type of parking permit and costs
           System.out.println("\n-----------------------------------------");  
           System.out.print("What type of Parking Permit do you have?");
           System.out.println("\n-----------------------------------------");
           System.out.println("1. Daily");
           System.out.println("2. Weekly");
           System.out.println("3. Semesterly");
           System.out.println("4. None");
           System.out.print("Please enter the number corresponding to your Permit: ");
         
           
           if (input.hasNextInt()) {
               int parkingPermitType = input.nextInt();

           
                 switch (parkingPermitType) {
                    case 1:System.out.print("\nHow much does your 'Daily' permit costs: "); 
                    parkingPermitCostpw = input.nextDouble() * visitsPerWeek; break;
                    
                    case 2:System.out.print("\nHow much does your 'Weekly' permit costs: ");
                    parkingPermitCostpw = input.nextDouble(); break;
                    
                    case 3:System.out.print("\nHow much does your 'Semesterly' permit costs: ");
                    parkingPermitCostpw = (input.nextDouble() / weeksInSem); break;
                    
                    case 4: break;  
      
                 } 
                  
                  
           } else {
               System.out.println("\n\n****INVALID INPUT****");
               input.nextLine();
          
                    
        }
        boolean flag = true; 
        while (flag) {
 
           System.out.println("\n---------------------");
           System.out.println("Select a type of car:");
           System.out.println("---------------------");
           System.out.println("1. SUV");
           System.out.println("2. Coupe");
           System.out.println("3. Sedan");
           System.out.println("4. Pickup Truck");
           System.out.println("5. Minivan");
           System.out.println("6. Exit to Menu");
           System.out.print("Please enter the number corresponding to your choice: ");
           
           double currentCommuteCostpw = 0;
           
           if (input.hasNextInt()) {
               int carModel = input.nextInt();
           
                 // switch for car model user inputs. Displays the commute cost per week
                 switch (carModel) {
                   case 1:
                       currentCommuteCostpw = ((commuteMpw / suvMpg) * gasPrice) + parkingPermitCostpw;
                       System.out.println("\n------------------------------------------------------------");
                       System.out.printf("|With an 'SUV' your current Commute Cost is $%.2f per Week|\n", currentCommuteCostpw);
                       System.out.println("------------------------------------------------------------");
                       System.out.println();
                       System.out.println("Here is how your Model adds up Compared to others:");
                       break;
                   case 2:
                       currentCommuteCostpw = ((commuteMpw / coupeMpg) * gasPrice) + parkingPermitCostpw;
                       System.out.println("\n-------------------------------------------------------------");
                       System.out.printf("|With a 'Coupe' your current Commute Cost is $%.2f per Week|\n", currentCommuteCostpw);
                       System.out.println("-------------------------------------------------------------");
                       System.out.println();
                       System.out.println("Here is how your Model adds up Compared to others:");
                       break;
                   case 3:
                       currentCommuteCostpw = ((commuteMpw / sedanMpg) * gasPrice) + parkingPermitCostpw;
                       System.out.println("\n-------------------------------------------------------------");
                       System.out.printf("|With a 'Sedan' your current Commute Cost is $%.2f per Week|\n", currentCommuteCostpw);
                       System.out.println("-------------------------------------------------------------");
                       System.out.println();
                       System.out.println("Here is how your Model adds up Compared to others:");
                       break;
                   case 4:
                       currentCommuteCostpw = ((commuteMpw / pickupMpg) * gasPrice) + parkingPermitCostpw;
                       System.out.println("\n--------------------------------------------------------------------");
                       System.out.printf("|With a 'Pickup Truck' your current Commute Cost is $%.2f per Week|\n", currentCommuteCostpw);
                       System.out.println("--------------------------------------------------------------------");
                       System.out.println();
                       System.out.println("Here is how your Model adds up Compared to others:");
                       break;
                   case 5:
                       currentCommuteCostpw = ((commuteMpw / minivanMpg) * gasPrice) + parkingPermitCostpw;
                       System.out.println("\n---------------------------------------------------------------");
                       System.out.printf("|With a 'Minivan' your current Commute Cost is $%.2f per Week|\n", currentCommuteCostpw);
                       System.out.println("---------------------------------------------------------------");
                       System.out.println();
                       System.out.println("Here is how your Model adds up Compared to others:");
                       break;
                   case 6: flag = false; return;    
                   
                   default: System.out.println("Invalid car model selection.");
                 
            
           
                 }  
              // Commute cost per week
              double suvCommuteCostpw = ((commuteMpw / suvMpg) * gasPrice) + parkingPermitCostpw;
              double coupeCommuteCostpw = ((commuteMpw / coupeMpg) * gasPrice) + parkingPermitCostpw;
              double sedanCommuteCostpw = ((commuteMpw / sedanMpg) * gasPrice) + parkingPermitCostpw;
              double pickupCommuteCostpw = ((commuteMpw / pickupMpg) * gasPrice) + parkingPermitCostpw;
              double minivanCommuteCostpw = ((commuteMpw / minivanMpg) * gasPrice) + parkingPermitCostpw;
              
              // Commute cost per semester
              double suvCommuteCostps = (((commuteMpw / suvMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem;
              double coupeCommuteCostps = (((commuteMpw / coupeMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem;
              double sedanCommuteCostps = (((commuteMpw / sedanMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem;
              double pickupCommuteCostps = (((commuteMpw / pickupMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem;
              double minivanCommuteCostps = (((commuteMpw / minivanMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem;
      
              System.out.println("----------------------------------------------------------------------------------------------------------------");
              System.out.println("|\t\tModel Type\t\t|\t\tSUV\t\t\t|\t\tCoupe\t\t|\t\tSedan\t\t|\t\tPickup Truck\t\t|\t\tMinivan\t\t|");
              System.out.println("----------------------------------------------------------------------------------------------------------------");
              System.out.printf("|\t\t$ Per week\t\t|\t\t$%4.2f  \t\t|\t\t$%5.2f\t|\t\t$%5.2f\t|\t\t$%11.2f\t\t|\t\t$%6.2f\t\t|\n",suvCommuteCostpw, coupeCommuteCostpw, sedanCommuteCostpw, pickupCommuteCostpw, minivanCommuteCostpw);
              System.out.println("----------------------------------------------------------------------------------------------------------------");
              System.out.printf("|\t\t$ Per Semester\t|\t\t$%4.2f\t\t|\t\t$%5.2f\t|\t\t$%5.2f\t|\t\t$%11.2f\t\t|\t\t$%6.2f\t\t|\n",suvCommuteCostps, coupeCommuteCostps, sedanCommuteCostps, pickupCommuteCostps, minivanCommuteCostps);
              System.out.println("----------------------------------------------------------------------------------------------------------------");
          
          
            
          } else {
               System.out.println("\n\n****INVALID INPUT****");
               input.nextLine();

        }
      }
    }
    
    // method for case #2 in main method. Displays GMU shuttle times
    public static void displayShuttleInfo() {
    
      boolean flag = true; 
      while (flag) {
    
         System.out.println("\n-----------------------------------------------------------------------");
         System.out.println("The Mason Shuttle is a Free Transportation Method for all GMU Students!\n");
         System.out.println("-------------------------");
         System.out.println("\tSelect a Bus Route:\t");
         System.out.println("-------------------------");
         System.out.println("1. Fairfax/ Mason Square");
         System.out.println("2. Fairfax/ SciTech (Prince William)");
         System.out.println("3. Gunston Mason Go-Bus");
         System.out.println("4. Sandy Creek/ Vienna Metro");
         System.out.println("5. West Campus Shuttle");
         System.out.println("6. Return to Menu:");
         System.out.println("-------------------------");
         System.out.println("\n--------------------------------------------------------");
         System.out.print("Please enter (1-6) your Shuttle Route for its Timings: ");
           
         
         if (input.hasNextInt()) {
            int shuttleChoice = input.nextInt();
           
            // switch to display users prefered Shuttle times
            switch (shuttleChoice) {
               case 1:
                 System.out.println("\n\n-------------------------------------");
                 System.out.println("Monday – Thursday (Every 60 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Sandy Creek: 7:15am - 10:25 pm");
                 System.out.println("Hazel Hall: 7:15am - 11:05 pm");
                 System.out.println("\n-------------------------------------");
                 System.out.println("Friday (Every 60 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Sandy Creek: 7:15am - 7:35 pm");
                 System.out.println("Hazel Hall: 7:15am - 8:25 pm");
                 System.out.println("\n(No Weekend Service)");
                 System.out.println("-------------------------------------");
                 break;
               
               case 2:
                 System.out.println("\n\n-------------------------------------");
                 System.out.println("Monday-Thursday (Every 40 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Sandy Creek: 6:00am - 10:15pm");
                 System.out.println("Colgan Hall: 6:00am - 11:35pm");
                 System.out.println("\n-------------------------------------");
                 System.out.println("Friday (Every 80 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Sandy Creek: 6:00am - 10:30pm");
                 System.out.println("Colgan Hall: 6:00am - 10:30pm");
                 System.out.println("\n-------------------------------------");
                 System.out.println("Saturday-Sunday (Every 2 hours)");
                 System.out.println("-------------------------------------");
                 System.out.println("Sandy Creek: 10:00am - 4:00pm");
                 System.out.println("Colgan Hall: 11:00am - 5:00pm");
                 System.out.println("-------------------------------------");
                 break;
               
               case 3:
                 System.out.println("\n\n-------------------------------------");
                 System.out.println("Monday – Friday (Every 75 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Fair Lakes: 7:15am - 10:40pm");
                 System.out.println("Sandy Creek: 8:05am - 10:15pm");
                 System.out.println("\n-------------------------------------");
                 System.out.println("Saturday – Sunday (Every 75 minutes)");
                 System.out.println("-------------------------------------");
                 System.out.println("Fair Lakes: 12:15pm - 7:45pm");
                 System.out.println("Sandy Creek: 1:05am - 7:20pm");
                 System.out.println("-------------------------------------");
                 break;
               case 4:
                 System.out.println("\n\n-----------------------------------------");
                 System.out.println("Monday – Friday (Every 30 minutes)");
                 System.out.println("-----------------------------------------");
                 System.out.println("Sandy Creek: 7:00am - 11:00pm");
                 System.out.println("Vienna Metro: 7:00am - 11:10pm");
                 System.out.println("\n(Service every 30 minutes Monday-Friday\nbetween7:00 am-4:00 pm; service 20 minutes\nafter 4:00 pm.)");
                 System.out.println("\n-----------------------------------------");
                 System.out.println("Saturday – Sunday (Every 60 minutes)");
                 System.out.println("-----------------------------------------");
                 System.out.println("Sandy Creek: 10:00am - 11:00pm");
                 System.out.println("Vienna Metro: 10:30am - 11:30pm");
                 System.out.println("-----------------------------------------");
                 break;
               case 5:
                 System.out.println("\n\n-----------------------------------------");
                 System.out.println("Monday-Thursday (Every 20 minutes)");
                 System.out.println("-----------------------------------------");
                 System.out.println("West Campus: 7:00am - 10:20pm");
                 System.out.println("Presidents Park: 7:20am - 10:40pm");
                 System.out.println("\n-----------------------------------------");
                 System.out.println("Friday (Every 40 minutes)");
                 System.out.println("-----------------------------------------");
                 System.out.println("West Campus: 7:00am - 10:20pm");
                 System.out.println("Presidents Park: 7:20am - 10:40pm");
                 System.out.println("\n(Service every 20 minutes Monday-Thursday\nbetween 8:00 am-8:00 pm; service 40\nminutes otherwise.)");
                 System.out.println("-----------------------------------------");
                 break;
                     
               case 6: flag = false; break;
               
               
           
            }
           
        } else {
               System.out.println("\n\n****INVALID INPUT****");
               input.nextLine();   
         
        }      
     
    
      }
    
    }
    // Method for case #3. A comparison between car, uber, and taxi
    public static void methodComparison() {
        Scanner input = new Scanner(System.in);
        
        // car model MPG
        double suvMpg = 29.0;
        double coupeMpg = 24.0;
        double sedanMpg = 31.7;
        double pickupMpg = 20.6;
        double minivanMpg = 22.0;
        
        // parking permit per week and per semester
        double parkingPermitCostpw = 0;
        double parkingPermitCostps = 0;
        
        // total car costs per week and semester
        double carCommuteCostpw = 0;
        double carCommuteCostps = 0;
        
        // Current Gas prices
        double gasPrice = 3.20;
        
        // Current Taxi fare / tip percentage (15%)
        double taxiFare = 3.50;
        double tipPercentage = 0.15;
        double tAddFees = 0.50;
        
        // Current Uber fare
        double uberFare = 2.00;
        double uAddFees = 5.00;
        
 
        System.out.println("\n-----------------------------------------------------");  
        System.out.print("How many times do you drive to George Mason each week: ");
        double visitsPerWeek = input.nextDouble();

        System.out.println("\n---------------------------------------------------");
        System.out.print("How many miles away is your home from George Mason: ");
        double milesPerCommute = input.nextDouble() * 2;
        double commuteMpw = milesPerCommute * visitsPerWeek;
        
        System.out.println("\n-----------------------------------------");  
        System.out.print("How many weeks is your current Semester: ");
        double weeksInSem = input.nextDouble();
        
        // user prompt for type of parking permit and costs
           System.out.println("\n---------------------------------------------");  
           System.out.print("What type of Parking Permit do you want to Compare?");
           System.out.println("\n---------------------------------------------");
           System.out.println("1. Daily");
           System.out.println("2. Weekly");
           System.out.println("3. Semesterly");
           System.out.println("4. None");
           System.out.print("Please enter the number corresponding to your Permit: ");
         
           
           if (input.hasNextInt()) {
               int parkingPermitType = input.nextInt();

                 // switch to calculate permit costs
                 switch (parkingPermitType) {
                    case 1:System.out.print("\nHow much does your 'Daily' permit costs: "); 
                    parkingPermitCostpw = input.nextDouble() * visitsPerWeek; break;
                    
                    case 2:System.out.print("\nHow much does your 'Weekly' permit costs: ");
                    parkingPermitCostpw = input.nextDouble(); break;
                    
                    case 3:System.out.print("\nHow much does your 'Semesterly' permit costs: ");
                    parkingPermitCostpw = input.nextDouble() / weeksInSem; break;
                    
                    case 4: break;  
      
                 } 
        
        
        boolean flag = true; 
        while (flag) {

           
           // output menu for user to select which type of car to compare
           System.out.println("\n------------------------------");
           System.out.println("Select a type of car to Compare:");
           System.out.println("-------------------------------");
           System.out.println("1. SUV");
           System.out.println("2. Coupe");
           System.out.println("3. Sedan");
           System.out.println("4. Pickup Truck");
           System.out.println("5. Minivan");
           System.out.println("6. Exit to Menu");
           System.out.print("\nPlease enter the number corresponding to your choice: ");
           
           
           if (input.hasNextInt()) {
              int carChoice = input.nextInt();
   
              // switch to do the commute costs for car model user wants to compare
              switch (carChoice) {
                 case 1:
                     carCommuteCostpw = ((commuteMpw / suvMpg) * gasPrice) + parkingPermitCostpw;
                     carCommuteCostps = (((commuteMpw / suvMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem; break;
                 
                 case 2:
                     carCommuteCostpw = ((commuteMpw / coupeMpg) * gasPrice) + parkingPermitCostpw;
                     carCommuteCostps = (((commuteMpw / coupeMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem; break;
                 
                 case 3:
                     carCommuteCostpw = ((commuteMpw / sedanMpg) * gasPrice) + parkingPermitCostpw;
                     carCommuteCostps = (((commuteMpw / sedanMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem; break;
      
                 case 4:
                     carCommuteCostpw = ((commuteMpw / pickupMpg) * gasPrice) + parkingPermitCostpw;
                     carCommuteCostps = (((commuteMpw / pickupMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem; break;
      
                 case 5:
                     carCommuteCostpw = ((commuteMpw / minivanMpg) * gasPrice) + parkingPermitCostpw;
                     carCommuteCostps = (((commuteMpw / minivanMpg) * gasPrice) + parkingPermitCostpw) * weeksInSem; break;
                     
                 case 6: flag = false; return;    
                  
      
                 default: System.out.println("****Invalid car model selection.****"); break;
              }
              
              } else {
                  System.out.println("\n\n****INVALID INPUT****");
                  input.nextLine(); 
              }
              
              
              // uber commute cost calculation per week and semester
              double tipAmount = tipPercentage * (taxiFare * commuteMpw);
              
              double taxiComCostpw = (taxiFare * commuteMpw) + tipAmount + tAddFees;
              double taxiComCostps = ((taxiFare * commuteMpw) + tipAmount + tAddFees) * weeksInSem;
              
              // uber commute cost calculation per week and semester
              double uberComCostpw = (uberFare * commuteMpw) + uAddFees;
              double uberComCostps = ((uberFare * commuteMpw) + uAddFees) * weeksInSem;
              
              // table output for comparison
              System.out.println("\n\nHere is how the Transportation Methods Compare:");
              System.out.println("----------------------------------------------------------------------------------------");
              System.out.println("|\t\tTransportation Type\t\t|\t\tPersonal Vehicle\t\t|\t\tUber\t\t|\t\tTaxi\t\t|");
              System.out.println("----------------------------------------------------------------------------------------");
              System.out.printf("|\t\t$ Per week\t\t\t\t\t|\t\t$%16.2f\t\t|\t\t$%2.2f\t|\t\t$%4.2f\t|\n",carCommuteCostpw, uberComCostpw, taxiComCostpw);
              System.out.println("----------------------------------------------------------------------------------------");
              System.out.printf("|\t\t$ Per Semester\t\t\t\t|\t\t$%16.2f\t\t|\t\t$%4.2f\t|\t\t$%4.2f\t|\n",carCommuteCostps, uberComCostps, taxiComCostps);
              System.out.println("----------------------------------------------------------------------------------------");
                
           }     
      
         } 
       
   }

}
