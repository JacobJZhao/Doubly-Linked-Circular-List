public class IncorrectLengthException extends Exception
{
    //private fields
    private String details;

    /**
     * Constructor for objects of class IncorrectLengthException
     */
    public IncorrectLengthException(String details)
    {
        super(details);
        this.details = details;
    }
}
