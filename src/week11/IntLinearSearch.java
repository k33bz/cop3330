package week11;

/**
 * This class implements the linear sort for integers
 * 
 * @author scottl
 * 
 */
public class IntLinearSearch extends AbstractSearch
{
    /**
     * Constructor
     * 
     * @param list
     */
    public IntLinearSearch()
    {

    }

    @Override
    public RESULT search(int[] list, int searchItem)
    {
        return linearSearch(list, searchItem);
    }

    /**
     * linearSearch simply walks from the front to the back until the item is
     * found or
     * 
     * @param number
     * @param searchValue
     * @return
     */
    private RESULT linearSearch(int[] number, int searchValue)
    {
        RESULT result = RESULT.FOUND;

        int loc = 0;

        while(loc < number.length && number[loc] != searchValue)
        {
            loc++;
        }

        if(loc == number.length)
        { 
        	// Not found
            result = RESULT.NOT_FOUND;
        }
        else 
        {
        	m_foundItemIndex = loc;
        }

        return result;
    }
}
