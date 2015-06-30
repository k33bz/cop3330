/**
 * Class File Header Info Here
 */
package week02;

import java.util.ArrayList;

/**
 * 
 * Testing the ExampleArrayList class for the live session.
 * 
 * @author scottl
 *
 */
public class ExampleTest
{

	/**
	 * Main entry point
	 * @param args Optional command line arguments
	 */
	public static void main(String[] args)
	{
		// Create an instance object of the class 
		ExampleArrayList list = new ExampleArrayList();
		
		// Call the instance method the object
		// We are using our test string as input		
		ArrayList<String> results = list.splitStringOnColon(testString);		
		
		// Display the results
		// This is the "for-each" version of the for loop
		for(String s : results)
		{
			trace(s);
		}
	}
	
	/**
	 * Helper method. This is a class method (denoted by static)
	 * 
	 * @param msg String to display
	 */
	private static void trace(String msg)
	{
		System.out.println(msg);
	}
	
	private static String testString = "My: sample : test code: using colons";

}
