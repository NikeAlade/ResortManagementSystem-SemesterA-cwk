  import java.util.*;
/**This class implements the WIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/25
 **/
 
 /**
  * Constructor for the Resort class
  * 
  * This constructor sets up the entire resort by creating a location for it 
  * Creates an array list to store all islands
  * Loads all island and ferry objects into the system
  * Loads all pass objects into the system
  * Automatically places every pass onto the base island (Island 0) 
  * so that the resort is consistent and stays organized
  * 
  * This setup makes sure that when the resort object is created, 
  * all the reqired elements of the system are available and usable
  */
public class Resort implements FIRE   // do not change this header
{

    private String location;
    // Other fields (including collections)
    private ArrayList<Island> islands;
    private ArrayList<Ferry> ferries;
    private ArrayList<Pass> passes;

    /** constructor
     * Some code has been provided 
     */
    public Resort(String loc) 
    {
        location = loc;
        
        islands = new ArrayList<>(); //array list to store islands
        ferries = new ArrayList<>(); //array list to store ferries
        passes = new ArrayList<>(); //array list to store passes
        
        loadIslandsAndFerries(); // adds all the island to the array list 
        loadPasses(); // adds all the passes to the array list
        
        // Ensure all passes are added to Base Island
        // you may do this here or in one of the above method
        
        Island base = islands.get(0);
        for (int i = 0; i < passes.size(); i++) {
        islands.get(0).enter(passes.get(i)); // puts all the passes on the base Island
        }
    }
    
    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString()
    {
        String s = "Resort " + location + "\n\n";
        
        for (Island isl : islands){
            s = s + isl.toString() + "\n";
        }
        s = s + "\nFerries:\n";
        for (Ferry f : ferries){
        s = s + f.toString() + "\n";
        }
        return s;
    }

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
        public String getAllPassesOnAllIslands()
        {
            String s = "\nLocation of Passes\n";
            for (Island i : islands){
            s = s + "\n" + i.getislandName() + ": ";
            
            String passList = i.listPasses();
            if (passList.isEmpty()) 
            s = s + "No passes\n";
            else 
            s = s + passList + "\n";
        }
            return s;
        } 

    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd -the id of the pass
     * @return the name of the Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd)
    {
        for (Island i : islands){
            if (i.passIsOnIsland(cd)){
                return i.getislandName();
            }
        }
        return "Not found";
    }
    
    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd)
    {
        Pass p = getPass(cd);
        if (p == null){
        return "Not found";
    } else{
        return p.toString(); //test to see if this will bring the to string details of pass or the ISland  of pass 
    }    
}

/** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        for (int i = 0; i < islands.size(); i++){
            if (islands.get(i).getislandName().equalsIgnoreCase(isl)){
                return i;
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl)
    {
        String s = "\nPasses on " + isl + ":\n";
        
        Island island = getIsland(isl);
        if (island == null) {
            return "Island not found";
        }
        
        String passesHere = island.listPasses();
        if (passesHere.isEmpty ()){
            s = s + "No passes + \n";
        } else { 
            s = s + passesHere + "\n";
        }    
        return s;
    } 

     /**Returns true if a Pass is allowed to journey using a ferry, false otherwise
      * A journey can be made if:  
      * the rating of the pass  >= the rating of the destination island
      * AND the destination island is not full
      * AND the pass has sufficient credits (a journey costs 3 credits)
      * AND the pass is currently in the source island 
      * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {   
        Pass p = getPass(cdId);
        Ferry f = getFerry(ferCode);
        
        if (p == null || f == null) 
        {
            return false;
        }
        
        Island from = f.getfromIsland();
        Island to = f.gettoIsland();
        
        if (!from.passIsOnIsland(cdId)) {
            return false;
        }                   

        if (p.getluxuryrating() < to.getislandRating()) { 
            return false;
        }
        
        if (p.getcredit() < 3) {
            return false;
        }

        if (to.isFull()) {
          return false;  
        }

    return true;
}
        
    /**Returns the result of a pass requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the pass  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. Pass 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPassId, String ferCode )
    {   //other checks optional

        String s = "";
        
        Pass p = getPass(pPassId);
        Ferry f = getFerry(ferCode);
        
        if (p == null){
            return "Pass not found";
        }
        
        if (f == null){
            return "Ferry not found";
        }
        
            s = f.processPass(p);
            
            return s;
        }
        
    

         
    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds)
    {
        Pass p = getPass(id);
        if(p !=null){
        p.addcredits(creds);
    }
}
   
 /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id)  
    {
         Pass p = getPass(id);
        if(p !=null){
        p.convertpointstocredit1();
    } else{
        System.out.println("Pass Not found"); 
    }
    } 

    //***************private methods**************
    private void loadPasses()
    {
     passes = new ArrayList<>();
     
     passes.add(new Pass(1000,"Lynn", 10, 5, 3)); //LISTS FIELDS IN THE ORDER OF PASS ID, NAME, CREDITS, LUXURY RATING and POINTS
     passes.add(new Pass(1001,"May", 30, 3, 10));
     passes.add(new Pass(1002,"Nils", 0, 10, 0));
     passes.add(new Pass(1003,"Olek", 12, 1, 4));
     passes.add(new Pass(1004,"Pan", 3, 3, 1));
     passes.add(new Pass(1005,"Quin", 30, 1, 10));
     passes.add(new Pass(1006,"Raj", 5, 4, 1));
     passes.add(new Pass(1007,"Sol", 20, 7, 6));
     passes.add(new Pass(1008,"Tel", 30, 6, 1));
     passes.add(new Pass(1231, "Dean", 20, 5,0)); //new pass added for demo
     
     //Demostration of task 7. Includes subclasses which inherit from the parent class "Pass"
     passes.add(new VisitorPass(2001, "Oyenike Alade", 15, 3, 5, "Nigeria"));
     passes.add(new BusinessPass(2002, "Nike", 4)); 
     passes.add(new EmployeePass(2003, "Monsurat", 7685, "Receptionist"));
     passes.add(new Bronze(6666,"Basia", "Budget", 0.15, 20));
    }
    
    private void loadIslandsAndFerries()
    {
        islands = new ArrayList<>();
        ferries = new ArrayList<>();
        
        Island i0 = new Island(0, "Base", 0, 100);
        islands.add(i0);
        
        Island i1 = new Island(1, "Yorke", 1, 100);
        islands.add(i1);
        
        Island i2 = new Island(2, "Bounty", 3, 10);
        islands.add(i2);
        
        Island i3 = new Island(3, "Twirl", 5, 2);
        islands.add(i3);
        
        Island i4 = new Island(4, "Aero", 1, 1);
        islands.add(i4);
        
        Island i5 = new Island(5, "Crunchie", 2, 20);
        islands.add(i5); //new Island added for demo

        
        //Add Ferries
        ferries.add(new Ferry("ABC1", i0, i1, 3)); //Base to Yorke
        ferries.add(new Ferry("BCD2", i1, i0, 3)); //Yorke to Base
        
        ferries.add(new Ferry("CDE3", i1, i2, 3)); //Yorke to Bounty
        ferries.add(new Ferry("DEF4", i2, i1, 3)); //Bounty to Yorke
        
        ferries.add(new Ferry("EFG5", i3, i1, 3)); //Twirl to Yorkie
        ferries.add(new Ferry("JKL8", i2, i3, 3)); //Bounty to Twirl
        
        ferries.add(new Ferry("GHJ6", i1, i4, 3)); //Yorke to Aero
        ferries.add(new Ferry("HJK7", i4, i1, 3)); //Aero to Yorke
        
        ferries.add(new Ferry("JJJ", i2, i5, 3)); //Bounty to Crunchie
        ferries.add(new Ferry("HHH", i5, i3, 3)); //Crunchie to Twirl
    }
  
    /** Returns the pass with the pass id specified by the parameter
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id)
    {
        for (Pass p : passes){
            if(p.getpassId() ==id){
                return p;
            }
        }
        return null;
    }
    
    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        for (Island i : islands){
            if (i.getislandName().equalsIgnoreCase(islandName)){
                return i;
            }
        }
        return null;
    }
    
    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
        for (Ferry f : ferries){
            if (f.getjourneyCode().equalsIgnoreCase(fer)){
                return f;
            }
        }
        return null;
        }
    }

