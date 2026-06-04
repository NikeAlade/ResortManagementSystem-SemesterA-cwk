/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island. A pass can only travel if it meets specific requirements.
 * 
 * This class contains the methods for checking a pass's eligibility to travel and processing it
 * @author (Oyenike Alade) 
 * @version (December 2, 2025)
 */
public class Ferry
{
    private String journeyCode;
    private Island fromIsland;
    private Island toIsland;
    private int cost = 3;
    
    /**
     * This conatructor initiates a new ferry object with the following attributes: 
     * @param journeyCode A unique code that identifies the ferry journey
     * @param fromIsland  The island the ferry departs from
     * @param toIsland The island the ferry travels to
     * @param cost The travel cost in credits
     */
    public Ferry(String journeyCode, Island fromIsland, Island toIsland, int cost){
        this.journeyCode = journeyCode;
        this.fromIsland = fromIsland;
        this.toIsland = toIsland;
    }
    
    /** This returns the journey code for this ferry
     * @return the journey code
     */public String getjourneyCode(){
        return journeyCode;
    }
    
    /**This returns the island that the ferry departs from
     * @return the source island
     */public Island getfromIsland(){
        return fromIsland;
    }
    
    /** This returns the island that the ferry travels to
     * @return the destination island
     */
    public Island gettoIsland(){
        return toIsland;
    }
    
    /**
     * This determines whether a pass is eligible to travel on a specific ferry
     * A pass can not travel if:
     * <ul>
     * <li> Its luxury rating is lower than the required island rating
     * <li> The destination island is full </li>
     * <li> The pass does not have eough credit </li>
     * <li>The pass is not currently located on the source island
     * </ul>
     * 
     * @param p the pass is checked for eligibility
     * @return true if the pass can travel; otherwise it returns false
     */
    public boolean canTravel(Pass p){
        if (p.getluxuryrating() < toIsland.getislandRating()){
            return false;
        }
        if (toIsland.isFull()){
            return false;
        }
        if (p.getcredit() < cost){
            return false;
        }
        if (!fromIsland.passIsOnIsland(p.getpassId())){
            return false;
        }
    //If all the above conditions are met, the Pass can travel
    return true;
    }
    
    /**
     * Attempts to process a Pass to travel on this ferry. 
     * If the Pass cannot travel, the method returns a message explaining the reason.
     * If the travel goes successfully, credits are deducted, points are awarded,
     * and the Pass is moved from the source island to the destination island.
     * 
     * @param p the pass attempting to travel
     * @return a message to show whether it is sucessful or has failed
     */
    public String processPass(Pass p){
        if(!canTravel(p)){
            if (p.getluxuryrating () < toIsland.getislandRating()){
                return "Pass is unable travel because the island luxury rating is too low.";
            }
            if (toIsland.isFull()){
                return "Pass is unable travel because the destination Island has reached full capacity.";
            }
            if (p.getcredit() < cost){
                return "Pass is unable to travel becase there is not enough credit.";
            }
            if (!fromIsland.passIsOnIsland(p.getpassId())){
                return "Pass is unable to travel because it can not be located on the source island.";
            }
        return "Pass can not Travel.";
            }
         else {
             //deducts the travel cost and awards points
             p.deductcredits(cost);
             p.addPointsForCreditsSpent(1);
             
             //update Pass information
             fromIsland.leave(p);
             toIsland.enter(p);
            }
            return "Successful. Pass has been moved from " + fromIsland.getislandName()  + " to " + toIsland.getislandName();
         }
        
         /**
          * This returns a formatted description of the ferry journey
          * @return a string containing the ferry details
          */
         public String toString(){
             String journeyInfo = "Ferry Code: " + journeyCode + "\n";
             journeyInfo = journeyInfo + "From Island: " + fromIsland.getislandName() + "\n";
             journeyInfo = journeyInfo + "To Island: " + toIsland.getislandName() + "\n";
             journeyInfo = journeyInfo + "Passanger Allowed" + "\n";
             
             return journeyInfo;
    }
}
