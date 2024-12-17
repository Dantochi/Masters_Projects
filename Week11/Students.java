
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kolling and David Barnes, modified by Mark Sinclair
 * @version 29 June 2020
 */
// getName()
// changeName() test
// getStudentID() test
// addCredits () test
// getCredits() test
// get LoginName() test
// print() test
// getStudentData() test
public class Students
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     * 
     * @param fullName student's full name
     * @param studentID student's ID number
     */
    public Students(String fullName, String studentID)
    {
        name = fullName;
        if (null == studentID)
            throw new NullPointerException("ID cannot be null");
        else if ("" == studentID)
            throw new NullPointerException("ID cannot be an empty string");
        else
            id = studentID;
        credits = 0;
    }

    /**
     * Return the full name of this student.
     * 
     * @return full name of this student
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     * 
     * @param replacementName new name for this student
     */
    public void changeName(String replacementName)
    {   
        if (null == replacementName)
            throw new NullPointerException("Name cannot be null");
        else if ("" == replacementName)
            throw new NullPointerException("Name cannot be an empty string");
            
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     * 
     * @return student ID of this student
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     * 
     * @param additionalPoints additional credit points
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     * 
     * @return number of credit points
     */
    public int getCredits()
    {
        if (credits<=0)
            throw new NullPointerException("Invalid credits value");
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     * 
     * @return login name of this student
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
    
    /**
     * Return the student's name and ID number as a String
     * 
     * @return the student name and id
     */
    public String getStudentData()
    {
        return name + " (" + id + ")";
    }
}
