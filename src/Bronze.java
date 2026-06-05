
/**
 * Write a description of class Bronze here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bronze extends Pass
{
   private double discountRate;
   private String clubName;
   
   public Bronze(int passId, String name, String clubName, double discountRate,int credit){
       super(passId, name, 0.2, credit, 3);;
       
       this.discountRate = 0.2;
       this.clubName = clubName;
   }
   
   public double getDiscountRate(){
       return discountRate;
   }
   
   public void useFerry()
    {
        deductcredits(3);
    }
}