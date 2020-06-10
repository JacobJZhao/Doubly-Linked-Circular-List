import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DLCListTest
{
    private DLCList<Person> list;
    private Person p1;
    private Person p2;
    private Person p3;
    private Person extra;
    private int dynamicListLength;
    
    /**
     * Default constructor for test class DLCListTest
     */
    public DLCListTest()
    {
        list = new DLCList<Person>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws IncorrectLengthException
    {        
        p1 = new Person("Jacob", "Zhao", "123456789");
        p2 = new Person("John", "Doe", "123459876");
        p3 = new Person("Jack", "Rockhelm", "987654321");
        list.addLast(p1);
        list.addLast(p2);
        list.addLast(p3);
        
        dynamicListLength = 3;
        extra = new Person("Testy", "McGee", "abc123def");
    }
    
    /**
     * Tests the getLast method and the addLast methods
     * addLast method is indirectly tested through setUp
     */
    @Test
    public void testAddAndGetLast() {
        assertTrue(list.getLast().equals(p3));
    }
    
    /**
     * Tests the getFirst and the addFirst methods
     */
    @Test
    public void testAddAndGetFirst() {
        list.addFirst(extra);
        dynamicListLength += 1;
        assertTrue(list.getFirst().equals(extra));
    }
    
    /**
     * Tests that the size method's return is consistent with actual size
     * Checked at end of every other test case
     */
    @Test
    public void testSizeConstancy() {
        assertTrue(list.size() == dynamicListLength);
    }
    
    /**
     * Tests the clear method by clearing and adding back a single element
     * testOne tests that the first item in the list is the element
     * testTwo tests that the last item in the list is the element
     * testOne and testTwo, in conjunction, verify that the list got cleared
     */
    @Test
    public void testClear() {
        list.clear();
        list.addLast(extra);
        boolean testOne = list.getFirst().equals(extra);
        boolean testTwo = list.getLast().equals(extra);
        dynamicListLength = 1;
        assertTrue(testOne && testTwo);
    }
    
    /**
     * Tests the deleteFirst method by comparing the first item to the previously-second item
     */
    @Test
    public void testDeleteFirst() {
        list.deleteFirst();
        dynamicListLength -= 1;
        assertTrue(list.getFirst().equals(p2));
    }
    
    /**
     * Tests the deleteLast method by comparing the last item to the previously-second to last item
     */
    @Test
    public void testDeleteLast() {
        list.deleteLast();
        dynamicListLength -= 1;
        assertTrue(list.getLast().equals(p2));
    }
    
    /**
     * Tests the get method
     * testOne tests for an index in the front half of the list
     * testTwo tests for an index in the back half of the list
     */
    @Test
    public void testGetAtIndex() {
        boolean testOne = list.get(0).equals(p1);
        list.addFirst(extra);
        dynamicListLength += 1;
        boolean testTwo = list.get(3).equals(p3);
        assertTrue(testOne && testTwo);
    }
    
    /**
     * Tests the delete method
     */
    @Test
    public void testDeleteAtIndex() {
        list.delete(1);  
        dynamicListLength -= 1;
        assertTrue(list.get(1).equals(p3));
    }
    
    /**
     * Tests the add method
     * Adds to the middle of the list
     */
    @Test
    public void testAddAtIndexMiddle() {
        list.add(1, extra);
        assertTrue(list.get(1).equals(extra));
        dynamicListLength += 1;
    }
    
    /**
     * Tests the add method
     * Adds to the front of the list
     */
    @Test
    public void testAddAtIndexFirst() {
        list.add(0, extra);
        assertTrue(list.getFirst().equals(extra));
        dynamicListLength += 1;
    }
    
    /**
     * Tests the add method
     * Adds to the end of the list
     */
    @Test
    public void testAddAtIndexLast() {
        list.add(3, extra);
        assertTrue(list.getLast().equals(extra));
        dynamicListLength += 1;
    }
    
    /**
     * Tests the contains method
     * testOne should return true
     * testTwo should return false
     */
    @Test
    public void testContains() {
        boolean testOne = list.contains(p3);
        boolean testTwo = list.contains(extra);
        assertTrue(testOne && !testTwo);
    }
    
    /**
     * Tests the set method
     * Sets the middle item to extra
     */
    @Test
    public void testSet() {
        list.set(1, extra);
        assertTrue(list.get(1).equals(extra));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     * Calls testSizeConstancy
     */
    @After
    public void tearDown()
    {
        testSizeConstancy();
        list.clear();
    }
}
