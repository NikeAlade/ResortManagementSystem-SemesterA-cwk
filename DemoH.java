
/**
 * Write a description of class DemoH here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DemoH
{
   public static void main(String[] args){
       Resort nirvana = new Resort("Brilliant Islands");
       
       System.out.println("****Displaying All Ferries, Islands and Passes****");
       System.out.println(nirvana);
       
       System.out.println("\n****Displaying All Passes on All Islands****");
       System.out.println(nirvana.getAllPassesOnAllIslands());
       
       System.out.println("\n****Displaying Specified Request To Travel****");
       System.out.println(nirvana.travel(1001,"ABC1") + "\n");
       System.out.println(nirvana.travel(1002,"ABC1") + "\n");
       System.out.println(nirvana.travel(1004,"ABC1") + "\n");
       System.out.println(nirvana.travel(1004,"CDE3") + "\n");
       
       System.out.println("\n****Displaying All Ferry Travels For Pass ID 1008****");
       System.out.println(nirvana.travel(1008,"ABC1"));
       System.out.println(nirvana.travel(1008,"CDE3"));
       
       System.out.println("\n****Can Pass ID 1008 travel using Ferry CDE3?****");
       System.out.println("Result is: " + nirvana.canTravel(1008,"CDE3"));
       
       System.out.println("\nLocation of 1004");
       System.out.println(nirvana.findPassLocation(1004));
       
    System.out.println("\nDisplaying Passes on Bounty");
    System.out.println(nirvana.getAllPassesOnIsland("Bounty"));
       
       
        
       
       }
}
