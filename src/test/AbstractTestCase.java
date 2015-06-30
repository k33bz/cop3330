package test;

import java.io.PrintStream;

/**
 * Abstract base class for a test case
 * This is the base class for test cases used in this class.
 * 
 * Each TestCase must inherit from this class.
 * 
 * @author scottl
 *
 */
public abstract class AbstractTestCase
{
	/**
	 * Default constructor
	 */
	protected AbstractTestCase(String name)
	{
		m_testName = name;
		m_stream = System.out; // Standard out
	}
	
	/**
	 * Subclasses must implement this abstract method
	 */
	public boolean run()
	{
		boolean result = runTest();
		
		return result;
	}
	
	/**
	 * Subclass must implement this method to execute the test
	 * 
	 * @return true if successful, otherwise false
	 */
	protected abstract boolean runTest();
	
	/**
	 * Subclasses provide the results of their test.
	 * 
	 * @return The formatted results from the subclass
	 */
	protected abstract String results();
	
	/**
	 * 
	 * @return TestCase Name
	 */
	public String getName()
	{
		return m_testName;
	}
	
	public void setPrintStream(PrintStream stream)
	{
		m_stream = stream;
	}
		
	/**
	 * Trace the msg to a PrintStream
	 * Provides the method for tests to report status
	 * @param msg
	 */
	protected void trace(String msg)
	{
		m_stream.println("    "  + msg);
	}	
	
	protected String m_testName;
	protected PrintStream m_stream;
}
