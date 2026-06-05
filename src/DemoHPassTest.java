
/**
 * Write a description of class DemoHPassTest here.
 *
 * @author (Oyenike Alade)
 * @version (a version number or a date)
 */
public class DemoHPassTest
{
   public static void main(String[] args){
       
       Pass myPass = new Pass(686,"Vijay", 9, 7, 0);
       
       myPass.addcredits(2); 
       System.out.println("The current amount of credit is: " + myPass.getcredit() + "\n");
       
       
       System.out.println("*****Displaying Pass Information*****");
       System.out.println(myPass.toString());
       
       
   }
}
