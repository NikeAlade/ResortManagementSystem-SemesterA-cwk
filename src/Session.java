
/**
 * Write a description of class Session here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Session
{
    private int sessionNumber;
    private String activityName;
    private int maximumSize;
    private int currentSize;
    private int cost;
    private boolean disabled;
    
    public Session(int sessionNumber, String activityName,int maximumSize, int currentSize,int cost,boolean disabled){
        this.sessionNumber = sessionNumber;
        this.activityName = activityName;
        this.maximumSize = 10;
        this.currentSize = 0;
        this.cost = cost;
        this.disabled = false;
    }
    
    public int getcost(){
        return cost;
    }
    
    public void deductMember(int amountToDeduct){
        if (amountToDeduct >= 1 && currentSize >= amountToDeduct){
           currentSize = currentSize - amountToDeduct; 
       }
    }
    
    public String toString(){
        return "****Session Information**** \n "+ 
       "Session Number: " + sessionNumber + "\n" + 
       "Activity Name:    " + activityName + "\n" + 
       "Maximum Size:  " + maximumSize + "\n" +
       "Current Size:  " + currentSize + "\n" +
       "Cost:  " + cost + "\n" +
       "Disabled: " + disabled;
    }
}
