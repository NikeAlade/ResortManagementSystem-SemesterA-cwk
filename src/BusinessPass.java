
/**
 * Write a description of class BusinessPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusinessPass extends Pass
{
    private int vouchers;
    /**
     * Business Pass always starts with 30 credits and 5 vouchers.
     * The constructor initiates 
     * @param passId- the unique ID of the pass
     * @param name-business traveller name
     * @param luxuryRating-rating chosen at creation time
     */
    public BusinessPass(int passId, String name, int luxuryRating)
    {
        super(passId, name, 30.0, luxuryRating, 0); // start with 30 credits & 0 journey points
        this.vouchers = 5;
    }
    
    /**
     * This returns the number of vouchers available
     */
    public int getvouchers(){
        return vouchers;
    }
    
    /**
     * On each ferry journey:
     * The system Deducts 2 credits, add 3 vouchers and 1 journey point
     */
    public void useFerry()
    {
        deductcredits(2); //deducts two credits
        vouchers = vouchers + 3; // adds two vouches
        addPointsForCreditsSpent(1); // add one points
    }
    
    /**
     * Converts vouchers into credits.
     * 4 vouchers = 1 credit
     */
    public void convertVouchers()
    {
        while (vouchers >= 4)
        {
            vouchers = vouchers - 4; //removes 4 vouchers 
            addcredits(1); // adds one credit for every 4 vouchers removed
        }
    }

    /**@override
     * This Overrides the toString method in the parent class by printing the details of the business pass
     */
    public String toString()
    {
        return super.toString() +
               "\nPass Type:   Business" +
               "\nVouchers:" + vouchers;
    }
}
    
