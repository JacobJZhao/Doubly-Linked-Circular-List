public class Person
{
    //private fields
    private String firstName;
    private String lastName;
    private String ID;
    
    /**
     * Constructor that creates a new Person
     * IncorrectLengthException is thrown when @param ID isn't nine digits long
     * @param First name of the Person as a String
     * @param Last name of the Person as a String
     * @param ID of the Person as a String
     */
    public Person(String first, String last, String ID) throws IncorrectLengthException{
        try {
            firstName = first;
            lastName = last;   
        
            if(ID.length() != 9) {
                throw new IncorrectLengthException("ID not nine digits long; ID set to null");
            }
            
            this.ID = ID;
        }
        catch(IncorrectLengthException e) {
            System.out.println(e);
            this.ID = null;
        }
    }
    
    /**
     * Returns the Person's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Returns the Person's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns the Person's ID
     */
    public String getID() {
        return ID;
    }
    
    /**
     * toString method
     * Returns as "firstname lastname, ID"
     */
    public String toString() {
        return firstName + " " + lastName + ", " + ID;
    }
}
