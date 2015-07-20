/**
 * 
 */
package week08;

/**
 * Exception used when guesses are out of range
 * 
 * @author slachanc
 * 
 */
public class InvalidArgumentException extends Exception
{
    /**
     * Serial version
     */
    private static final long serialVersionUID = -4242998573088432171L;

    public InvalidArgumentException()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public InvalidArgumentException(String arg0)
    {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public InvalidArgumentException(Throwable arg0)
    {
        super(arg0);
    }

    /**
     * 
     * @param arg0
     * @param arg1
     */
    public InvalidArgumentException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }

    public InvalidArgumentException(int invalidValue)
    {
        badValue = invalidValue;
    }

    @Override
    public String getMessage()
    {
        return String.format("Bad value: %d", badValue);
    }

    int badValue;
}
