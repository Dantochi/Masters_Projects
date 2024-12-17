

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentsTest
{
    private Students students1;

    

    /**
     * Default constructor for test class StudentsTest
     */
    
    public StudentsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        students1 = new Students("Tochukwu", "12334");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testConstructor()
    {
        Students students1 = new Students("Tochukwu", "1456639");
        assertNotNull(students1);
    }

    @Test
    public void testGameName()
    {
        Students students1 = new Students("Fred", "123456");
        assertEquals("Fred", students1.getName());
    }

    @Test
    public void testGetCredits()
    {
        Students students1 = new Students("Daniel", "147852");
        students1.addCredits(5);
        assertEquals(5, students1.getCredits());
    }

    @Test
    public void testGetStudentID()
    {
        Students students1 = new Students("John", "123456");
        assertEquals("123456", students1.getStudentID());
    }

    @Test
    public void testChangeName()
    {
        Students students1 = new Students("Dennis", "123456");
        students1.changeName("Mary");
        assertEquals("Mary", students1.getName());
    }

    @Test
    public void testLoginName()
    {
        Students students1 = new Students("Jack", "147852");
        assertEquals("Jack147", students1.getLoginName());
    }
    
    @Test
    public void testNullName()
    {
        try{
            students1.changeName(null);
            fail("Expected NullPointerException to be thrown");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    }
    
    @Test
    public void testFullName(){
        try{
            students1.changeName(null);
            fail("Expected NullPointerException to be thrown");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    
    }
}






