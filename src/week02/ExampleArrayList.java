package week02;

// This statement imports the ArrayList definition into our code
import java.util.ArrayList;

/**
 * This class demonstrates the use of the
 * Java collection ArrayList
 * @author scottl
 *
 */
public class ExampleArrayList
{
	/**
	 * Default constructor
	 * In object oriented programming, the constructor
	 * is a piece of code that is GUARANTEED to execute prior to
	 * the first use of the class by the caller.
	 * This guarantee is critical to the OOP.
	 * 
	 * Note the public modifier makes the constructor visible to 
	 * anyone.
	 */
	public ExampleArrayList()
	{
		// This is collection is called a "generic" collection
		// The type between the < and > defines the allowed type of the data
		// to be added to the list.
		m_list = new ArrayList<String>();
	}
	
	/**
	 * This method splits a user provided string at the location
	 * of a colon ':' character and returns the single string
	 * as multiple strings.
	 * 
	 * @param inputString The string to split
	 * @return An ArrayList of the split string
	 */
	public ArrayList<String> splitStringOnColon(String inputString)
	{
		m_list.clear(); // remove any previous entries
		
		String[] list = inputString.split(":");
		for(int i = 0; i < list.length; i++)
		{
			// Get the next string in the list. 
			// Note, this is zero based
			String s = list[i];
			
			// Add the string, but trim leading and trailing whitespace
			m_list.add(s.trim());
		}
		
		return m_list;
	}
	
	// Private INSTANCE attribute of the class
	private ArrayList<String> m_list;
}
