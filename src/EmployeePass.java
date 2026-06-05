
/**
 * Write a description of class EmployeePass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeePass extends Pass
{
    private int employeeNumber;
    private String jobDescription;
    
    /**Employees always start with rating 10 and no credits. 
     * @param passId         unique ID for the pass
     * @param name           employee name
     * @param employeeNumber unique employee number
     * @param jobDescription description of their role
     */
    public EmployeePass(int passId, String name, int employeeNumber, String jobDescription)
    {
        super(passId, name, 0, 10, 0);
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
    }
    
    /**
     * This returns the employee's number
     */
    public int getemployeeNumber(){
        return employeeNumber;
    }
    
    /**
     * This returns the job description
     */
    public String getjobDescription(){
        return jobDescription;
    }
    
    /**Unlike Visitors, employees do not get charged for ferry travels but they get one point
     */
    public void useFerry(){
        addPointsForCreditsSpent(1); 
    }
    
    /** @override
     * Print details about the employee's pass.
     */public String toString()
    {
        return super.toString() +
               "\nPass Type:       Employee" +
               "\nEmployee No:     " + employeeNumber +
               "\nJob:             " + jobDescription;
    }
}

