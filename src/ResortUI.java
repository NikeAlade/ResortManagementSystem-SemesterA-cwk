import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{  
    private Scanner reader = new Scanner(System.in);
    private FIRE fortunate = new Resort("Fortunate Islands");
    
    private void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllResort();}
            else if (choice == 2){listAllPasses();}
            else if (choice == 3){listOneIsland();}
            else if (choice == 4){tryTravel();}
            else if (choice == 5){findLocationOfPass();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){viewPass();}
            else if (choice == 8){updateCredits();}                        
            else if (choice == 9){convertPts();}

            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all passes on all islands");
        System.out.println("3. List all passes on one island");
        System.out.println("4. Say if pass can travel on the ferry");
        System.out.println("5. Find location of pass");
        System.out.println("6. Move a pass by ferry");
        System.out.println("7. View pass");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");

        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }
    
    // This one has been done for you 
    private void listAllResort()
    {
        System.out.println(fortunate.toString()); 
    }
    
    // provide the code here  
    private void listAllPasses()
    {
        System.out.println(fortunate.getAllPassesOnAllIslands()); //prints out all the passes on all islands
    }
   
    // provide the code here 
    private void listOneIsland()
    { 
        System.out.println("Enter Island Name");
        String isl = reader.nextLine();
        System.out.println(fortunate.getAllPassesOnIsland(isl)); //prints out the passes on a specific island
    }
       
    // provide the code here
    private void findLocationOfPass()
    {
        System.out.println("Enter Pass Id");
        int PassId = reader.nextInt();
        System.out.println("Visitor with Pass ID " + PassId + " is on " + fortunate.findPassLocation(PassId));
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(fortunate.canTravel(trav,ferry));
    }
    
    // provide the code here
    private void travelNow()
    {
        System.out.println("Enter Pass ID");
        int tId = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter Ferry Code");
        String ferCode = reader.nextLine();
        System.out.println(fortunate.travel(tId,ferCode));
    }
    
    // This one has been done for you
    private void viewPass()
    {
        System.out.println("Enter pass ID number");
        int cId = reader.nextInt();
        System.out.println(fortunate.viewAPass(cId));
    }
     
    // provide the code here
    private void updateCredits()
    {
        System.out.println("Enter Pass ID");
        int ID = reader.nextInt();
        System.out.println("Enter number of credits to add");
        int credits = reader.nextInt();
        reader.nextLine();
        
        fortunate.topUpCredits(ID, credits);  
        System.out.println("Credits Updated"); 
              
    }
         
    // provide the code here
    private void convertPts()
    {
        System.out.println("Enter Pass ID");
        int id = reader.nextInt();
        reader.nextLine();
        
        fortunate.convertPoints(id);
        System.out.println("Points converted ");
    }   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
    
}
