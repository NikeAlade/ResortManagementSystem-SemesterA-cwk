
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        FIRE fortunate = new Resort("Fortunate Islands");
        Scanner enter = new Scanner(System.in);
        
        // Write all of your tests here
        //Test 1: Prints Entire Resort Details. 
        //The expectation is that it will display all island and available passes
        System.out.println("********************************");
        System.out.println("Test 1: Print Entire Resort Details");
        System.out.println("********************************");
        System.out.println("All Island and Passes are listed below:"); //prints all the island and passes
        System.out.println(fortunate.toString() + " \n");
        
        //Test 2: This test lists all the passes on all Island
        //The expectation is that all the passes should be on Base initially

        System.out.println("********************************");
        System.out.println("Test 2: All Passes on all Island are listed below. Note that all Passes will initially be on the base Island");
        System.out.println("********************************");
        System.out.println(fortunate.getAllPassesOnAllIslands()  + " \n");
        
        //Test 3: This Tests lists all the Passes on a specific Island provided by the user
        //
        System.out.println("********************************");
        System.out.println("Test 3: Enter Island Name");
        System.out.println("********************************\n");
        String isl = enter.nextLine(); // asks for the island name
        System.out.println("\nShowing All the Passes on: " + isl + "\n");
        System.out.println(fortunate.getAllPassesOnIsland(isl) + "\n");
        
        //Test 4: This test finds the location of a known pass
        System.out.println("******************************** ");
        System.out.println("Test 4: Find location of a known pass");
        System.out.println("********************************\n");
        System.out.println("Pass 1001 is on: " + fortunate.findPassLocation(1001) + " \n"); //prints out the Island where the pass is located
        
        //Test 5: This test shows the full details of a pass. Here we are testing for a valid pass and an invalid pass
        System.out.println("********************************");
        System.out.println("TEST 5: View Pass Details");
        System.out.println("********************************\n");

        System.out.println("Expected: Full details for pass 1001, such as name, credits, rating, points.\n");
        System.out.println(fortunate.viewAPass(1001)); // prints full details for a pass

        System.out.println("\nTesting with an INVALID Pass ID (9999):");
        System.out.println("Expected: 'Not found'");
        System.out.println(fortunate.viewAPass(2007) + "\n"); //Pass ID 2007 does not exist so it should return not found
       
        
        // Test 6: Tests the canTravel method to see if it is valid & invalid
        System.out.println("********************************");
        System.out.println("TEST 6: Check if Pass Can Travel");
        System.out.println("********************************\n");

        System.out.println("Enter Pass ID:");
        int PassId = enter.nextInt();
        enter.nextLine(); //asks to input ID
        
        System.out.println("Enter Ferry Code:");
        String travel = enter.nextLine(); //asks to ferry code

        System.out.println("\nChecking travel permission for Pass " + PassId + " on Ferry " + travel + "\n");
        System.out.println("Result: " + fortunate.canTravel(PassId, travel) + "\n");

        System.out.println("Testing invalid ferry code WITH 'XYZ'. Expected = false\n");
        System.out.println("Result " + fortunate.canTravel(1000, "XYZ"));
        System.out.println("Unable to Travel\n");
        
        //Test 7: This tests the method to process a travel request
        System.out.println("********************************");
        System.out.println("Test 7: Perform a ferry journey (travel)");
        System.out.println("********************************\n");
        
        System.out.println("Enter Pass ID");
        int pId = enter.nextInt();
        enter.nextLine();
        System.out.println("Enter Journey ID");
        String fCode = enter.nextLine();
        
        System.out.println("Attempting travel: " + pId + " via ferry " + fCode  + " \n");
        System.out.println(fortunate.travel(pId,fCode) + " \n");
        
        System.out.println("Pass ID " + pId + " should now be on " + fortunate.findPassLocation(pId) + " \n");
        
        
        //Test 8a: This is a test to attempt travel with insufficient credits
        System.out.println("********************************");
        System.out.println("Test 8a: Try to travel with insufficient credits ");
        System.out.println("********************************\n");
        
        System.out.println("Error message");
        System.out.println(fortunate.travel(1002, "ABC1")); //Pass 1002 has 0 credits but needs three credits to trvel so this will fail
        
        //Test 8b: This is a test to attempt travel to wrong Ferry code
        System.out.println("\n********************************");
        System.out.println("Test 8b: Travel with wrong Ferry code 'A0'");
        System.out.println("********************************\n");
        
        System.out.println("Error message");
        System.out.println(fortunate.travel(1008, "A0")); //Ferry code does not exist so it should return with an error message
        
        //Test 8c: Attempts to travel with wrong pass ID
        System.out.println("\n********************************");
        System.out.println("Test 8c: Try to travel with wrong Pass ID ");
        System.out.println("********************************\n");
        
        System.out.println("Error message");
        System.out.println(fortunate.travel(3000, "ABC1")); //Pass ID 3000 does not exist
        
        //Test 8d: This is a test to attempt travel to an Island with low luxury rating 
        System.out.println("********************************");
        System.out.println("Test 8d: Try to Travel with Valid Pass ID and Journey Code");
        System.out.println("********************************\n");
        
        System.out.println("Result");
        System.out.println(fortunate.travel(1000, "ABC1")); // Pass ID 1000 has a luxury rating of 1005, which is higher than Island Yorkie (ABC1)
        
        
        //Test 9: Tests topping up credit balance
        System.out.println("\n******************************** ");
        System.out.println("Test 9: Credit Top-Up");
        System.out.println("******************************** " + " \n");
        
        System.out.println("Before TopUp:");
        System.out.println(fortunate.viewAPass(1006) + "\n");
        
        System.out.println("\nAdding 20 credits to Pass 1006...");
        fortunate.topUpCredits(1006, 20); //Pass ID 1006 originally has 3 credits, with this addition, it will be updated to 23 credits
        
        System.out.println("\nVerifying that 20 credits has been added:");
        System.out.println(fortunate.viewAPass(1006)); // Should print out the updated pass list with the credit balance showing 23credits
        
        //Test 10: Test to convert points to credits
        System.out.println("\n********************************");
        System.out.println("Test 10: Convert Points to Credits");
        System.out.println("******************************** " + " \n");
        
        System.out.println("Before conversion:");
        System.out.println(fortunate.viewAPass(1001) + "\n"); //Prints pass details including points before conversion

        System.out.println("***Converting journey points***");
        fortunate.convertPoints(1001); // adds points
        
        System.out.println("Journey Points have been converted. See new point balance below");

        System.out.println("\nAfter conversion:");
        System.out.println(fortunate.viewAPass(1001)); //Prints pass details including points after conversion

        
        System.out.println("\n********Testing Ends********");
    }
    
    // No need to change this
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
