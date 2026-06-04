
/**
 * Write a description of class VisitorPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VisitorPass extends Pass
{
    private String citizenship;
    /**
     * This is the Visitor class constructor.
     * It uses the superclass constructor to set:
     * passId, name, credits, luxury rating, and journey points.
     * @param passId-the unique pass ID
     * @param name-the name of the visitor
     * @param credit-the number of credits the visitor starts with
     * @param luxuryRating-the visitor's luxury rating
     * @param points-the starting journey points
     * @param citizenship-country the visitor comes from
     */
    public VisitorPass(int passId, String name, double credit, int luxuryRating, int points, String citizenship)
    {
        super(passId, name, credit, luxuryRating, points); //calls the parent constructor
        this.citizenship = citizenship;
    }
    
    /**
     * This returns what country the visitor comes from
     */
    public String getcitizenship(){
        return citizenship;
    }
    
    /**
     * When a visitor travels, they will lose 4 credits and gain 1 journey point as a reward.
     */
    public void useFerry()
    {
        deductcredits(4);       // lose 4 credits
        addPointsForCreditsSpent(1);          // add 1 point 
    }
    
    /**@override
     * This particular method overrides the toString method in the parent class by adding it's own variables
     */
    public String toString() // 
    {
        return super.toString() +
               "\nPass Type:       Visitor" +
               "\nCitizenship: " + citizenship;
    }
}
