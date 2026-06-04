import java.util.*;
/**
 * A Pass class has an id number, name, a luxury rating,
 * number of credits and journey points. It represents a transport pass used by customers
 * in a ferry or a resort system.
 * @author (Oyenike Alade) 
 * @version (December 2, 2025)
 */
public class Pass 
{
   //fields
   private int passId;
   private String name;
   private double credit;
   private int luxuryrating;
   private int points;
   
   /**
     * This constructor initiates a new  Pass object with specified attributes.
     * @param passId - the unique ID number of the pass
     * @param name - the name associated with the pass holder
     * @param credit - the starting credit balance
     * @param luxuryrating - the luxury rating of the pass
     * @param points - the initial journey points
     */
   public Pass(int passId,String name, double credit, int luxuryrating, int points)
   {
       this.passId = passId;
       this.name = name;
       this.credit = credit;
       this.luxuryrating = luxuryrating;
       this.points = points;
   }
   
   // Accessor methods
   /**
    * This returns the unique pass ID
    */
   public int getpassId(){
       return passId;
   }
   
   /**
    * This returns the name of the pass holder
    */
   public String getname(){
       return name;
   }
   
   /**
    * This returns the current credit  balance
    */
   public double getcredit(){
       return credit;
   }
   
   /**
    * This returns the luxury rating associated with the pass
    */
   public int getluxuryrating(){
       return luxuryrating;
   }
   
   /**
    * This returns the current journey points on the pass.
    */
   public int getpoints(){
       return points;
   }
   
   //mutator methods
   /**
    * Adds an amount of credit to the pass.
    * It only accepts positive values.
    * @param amount the amount of credit to add
    */
   public void addcredits(double amount){
   if(amount > 0){
       credit = credit + amount; //adds credit
   }
}

/**
    * It deducts an amount of credit from the pass 
    * using @code credit = credit - amount
    */
   public void deductcredits(int amount){
       if (amount > 0 && credit >= amount){
           credit = credit - amount; //deducts credit
       }
   }
   
   /**
    * It uses the ferry by deducting three credits and awarding one point, 
    * as long as the visitor has enough credits
    */
   public void useferry(){
       if (credit >= 3){
           credit = credit - 3; //deducts 3 credits
           points = points + 1; //adds points
       }
   }
   
   /**
    * If the passenger has 5 points or more, they can convert 5 points into a credit one time
    */
   public void convertpointstocredit1(){
       if (points >= 5){
           points = points - 5; //deducts 5 points
           credit = credit + 1; //adds 1 credit
       } 
       
    }
   
   /**
    * This is a second version of converting points. This particular version
    * coverts all the available points into credits immediately using a while loop until the balance is below the minimum points that can be redeemed. 
    * @param creditspent unused parameter is kept for compatibility with the method specification
    */
   public void convertpointstocredit2(int creditspent){
       while (points >= 5){
           points = points - 5; //deducts 5 points
           credit = credit + 1; //adds 1 credit
       }
   }
   
   /**
    * This awards points based on the credit spent. Every 3 credits earns a visitor 1 pont
    * @param creditSpent amount of credit used
    */
   public void addPointsForCreditsSpent(double creditSpent){
       if (creditSpent > 0){
           int earnedPoints = (int)creditSpent/3; //divides credit spent by 3 
           points = points + earnedPoints; //adds the result of the division to points
       }
   }
   
   /**
    * This returns a readable sumarry of pass information
    * @return formatted pass details
    */
   public String toString(){
       return "****Pass Information**** \n "+ 
       "Pass ID: " + passId + "\n" + 
       "Name:    " + name + "\n" + 
       "Credit:  " + credit + "\n" +
       "Points:  " + points + "\n" +
       "Luxury Rating: " + luxuryrating;
   }
}

