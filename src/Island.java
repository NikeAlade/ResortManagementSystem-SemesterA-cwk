import java.util.*;
/**
 * An island is part of a FIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can be on the  
 * island at any one time. Each island must maintain a list of all people (passes)
 * currently on the island. These lists are updated whenever passes enter or leave 
 * an island,so that it is always possible to say which (passes) are on the island 
 * 
 * 
 * @author (Oyenike Alade) 
 * @version (December 2, 2025)
 */

public class Island 
{
    private int islandNumber;
    private String islandName;
    private int islandRating;
    private int islandCapacity;
    
    private ArrayList<Pass>passes;
    
    /**The constructor creates an island with the island number, name, rating and capacity. 
    It also initializes an empty array list to hold pass objects. 
    * @param islandNumber - the unique island ID
    * @param island name - the name of the island
    * @param islandRating - luxury rating reqired for pass entry
    * @param islandCapacity - the maximum number of passes allowed 
    */
    public Island(int islandNumber, String islandName, int islandRating, int islandCapacity){
    
    this.islandNumber = islandNumber;
    this.islandName = islandName;
    this.islandRating = islandRating;
    this.islandCapacity = islandCapacity;
    this.passes = new ArrayList<>();
    
}

/**
 * This returns the island's number
 * @return island number
 */
public int getislandNumber(){
    return islandNumber;
}

/**
 * This returns the island's name
 * @return island name
 */
public String getislandName(){
    return islandName;
}

/**
 * This returns the island's luxury rating
 * @return island rating
 */
public int getislandRating(){
    return islandRating;
}

/**
 * This returns the total capacity of the island
 * @return the maximum number of the allowed passes
 */
public int getislandCapacity(){
    return islandCapacity;
}

/**
 * This returns the number of passes currently on the island
 * @return number fo passes present
 */
public int getcurrentpasses(){
    return passes.size();
}

/**
 * This checks whether the island has reached it's maximum capacity
 * @return true if the island is full and false if it is not full
 */
public boolean isFull(){
    return passes.size() >= islandCapacity;
}

/**Attempts to add a pass to the island. If th island is ful, the pass
 * will not be added
 * 
 * @param p the Pass attempting to enter
 */
public void enter (Pass p){
    if(isFull()){
        String list = "Island is full. This pass can not be added";
    } else {
        passes.add(p);
    }
}

/**
 * Removes Pass from the island if the pass is found.
 * 
 * @param p the Pass to remove 
 * @return a message to indicate whether pass was successfully removed or failed
 */
public String leave(Pass p)
{
    for (int i = 0; i < passes.size();i++){
        if (passes.get(i).equals(p)){
            passes.remove(i);
            return "Pass removed successfully.";
        }
    }
        return "Pass not found on the Island";
    }

/**
 * Returns a formatted list of all passes that are currently on the island
 * 
 * @return a list of pass names and IDs, or a message if no passes  are present
 */
public String listPasses()
{
if (passes.isEmpty()){
    return "There are currently no passes on the Island";
}
  String list = "Passes on " + islandName + ":\n";
        for (Pass p : passes) {
            list = list + " - " + p.getname() + " (ID: " + p.getpassId() + ")\n";
        }
            {return list;
}
}

/**
 * This displays detailed information about a pas on the island
 * 
 * @param pId ID number of the Pass
 * @return formatted pass information or "not found" message
 */
public String getpassInfo(int pId)
{
    for (Pass p : passes){
        if (p.getpassId() == pId){
            String passInfo = "Pass Details: \n";
             passInfo = passInfo + "Name: " + p.getname() + "\n";
             passInfo = passInfo + "Pass ID: " + p.getpassId() + "\n";
             passInfo = passInfo + "Credit: " + p.getcredit() + "\n";
             passInfo = passInfo + "Luxury Rating: " + p.getluxuryrating() + "\n";
             passInfo = passInfo + "Points: " + p.getpoints() + "\n";
             return passInfo;
        }
    }
    return "Pass with ID " + pId + " not found on the Island.";
}

/**
 * Checks whether a pass with the given ID is currnetly on the island
 * 
 * @param id Pass ID
 * @return true if the pass is present, false if it is absent
 */
public boolean passIsOnIsland(int id){
    for (Pass p : passes) {
         if (p.getpassId() == id){
            return true;
    }
}
    return false;
}

/** 
 * Returns a formatted summary of island information, 
 * including the current passes on the island
 * 
 * @return island details as a string
 */
public String toString(){
    String islandInfo = "Island Number: " + islandNumber + "\n";
    islandInfo = islandInfo + "Island Name: " + islandName + "\n";
    islandInfo = islandInfo + "Luxury Rating: " + islandRating + "\n";
    islandInfo = islandInfo + "Capacity: " + islandCapacity + "\n";
    islandInfo = islandInfo + "Current Passes: " + passes.size() + "\n\n";
    
    islandInfo = islandInfo + listPasses();
    
    return islandInfo;
}


}