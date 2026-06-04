import java.util.*;
/**
 * Write a description of class PassTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassTester
{
    public static void main(String[] args)
    {
        Pass p1 = new Pass(001,"Oyenike" ,25.05,5,100);
       
        // write your tests here
        //Tests the methods for each data included in Pass information
        System.out.println("Visitor's Name: " + p1.getname());
        System.out.println("PassID: " + p1.getpassId());
        System.out.println("Credit: " + p1.getcredit());
        System.out.println("Luxury Rating: " + p1.getluxuryrating());
        System.out.println("Points: " + p1.getpoints());
        System.out.println(" ");
        
        //Tests the method to add credits 
        System.out.println("****Adding 25 Credits****");
        p1.addcredits(25); // adds 25 credits
        System.out.println("New Credit Balance After Adding: "+ p1.getcredit()); //prints out the credit balance after adding credits
        System.out.println(" ");
        
        //Tests the method to deduct credits
        System.out.println("****Deducting 30 Credits****");
        p1.deductcredits(30); //deducts 30 credits
        System.out.println("New Credit Balance After Deducting: "+ p1.getcredit()); //prints out the credit balance after deducting
        System.out.println(" ");
        
        //Tests the method to use Ferry
        System.out.println("Using Ferry(Cost is 3 credits, and a reward of 1 point)");
        p1.useferry(); //deducts 3 credits and adds 1 point
        System.out.println("New Credit Balance After Booking a Ferry: " + p1.getcredit());
        System.out.println("New Points Balance Booking a Ferry: " + p1.getpoints());
        System.out.println(" ");
        
        //Tests method that converts 5 points to 1 credits only once
        System.out.println("Converting 5 Points to 1 Credit ");
        p1.convertpointstocredit1(); //deducts 5 points and adds 1 credit
        System.out.println("New Credit Balance: " + p1.getcredit());
        System.out.println("New Point Balance: " + p1.getpoints());
        System.out.println(" ");
        
        //Tests second method that converts 5 points to 1 credits multiple times in a loop
        System.out.println("Converting All Points to Credits");
        System.out.println("Old Credit Balance: " + p1.getcredit());
        System.out.println("Old Point Balance: " + p1.getpoints());
        p1.convertpointstocredit2(5); //divides all the available points by 5, the result is the number of points that is added
        System.out.println("New Credit Balance after point Redemption: " + p1.getcredit());
        System.out.println("New Point Balance: " + p1.getpoints());
        System.out.println(" ");
        
        //Tests method that converts 5 points to 1 credits multiple times in a loop
        System.out.println("Testing Reward Points for 10 credits spent");
        System.out.println("Old Point Balance: " + p1.getpoints());
        p1.addPointsForCreditsSpent(10);
        System.out.println("New Point Balance: " + p1.getpoints());
        System.out.println(" ");
        
        //Tests the Tostring method that displays Pass Information
        System.out.println(p1.toString());        
    }
}


