package week02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class tests the week 2 assignments It tests the DateFormat, ProcessName
 * and StringExclamation classes All classes are part of the package week02
 * 
 * @author scottl
 * 
 */
public class TestHarness
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		boolean testSuccess = true;

		trace("Starting test...");

		trace(" -- setup test data");
		try
		{
			m_testDate.set(1961, 9, 20);
			Date testDate = m_testDate.getTime();
			Date curDate = Calendar.getInstance().getTime();
			String curDateFormat = "dd MMMM yyyy";
			SimpleDateFormat formatter = new SimpleDateFormat(curDateFormat);
			String expectedCurDate = formatter.format(curDate);

			trace(" -- Testing DateFormat");
			DateFormat dateFormat = new DateFormat();
			String testDateString = dateFormat.formatDate(testDate);
			String cureDateString = dateFormat.getCurrentDate();

			// Verify
			if(!testDateString.equals(m_dateVerifyTest))
			{
				trace("  ** DateFormat failed! Got: " + testDateString
						+ " Expected: " + m_dateVerifyTest);
				testSuccess = false;
			}

			// Verify current date
			if(!expectedCurDate.equals(cureDateString))
			{
				trace("  ** Current DateFormat failed! Got: " + cureDateString
						+ " Expected: " + expectedCurDate);
				testSuccess = false;
			}
		}
		catch(Exception ex)
		{
			trace("Exception during DateFormat test: " + ex.getMessage());
			ex.printStackTrace();
			testSuccess = false;
		}

		try
		{
			trace(" -- Testing ProcessName");
			ProcessName name = new ProcessName(m_nameTest[0], m_nameTest[1],
					m_nameTest[2]);
			String formattedName = name.getFirstInitialLast();
			String displayName = name.getDisplayName();

			// Verify
			if(!formattedName.equals(m_nameVerifyTest))
			{
				trace("  ** ProcessName failed! Got: " + formattedName
						+ " Expected: " + m_nameVerifyTest);
				testSuccess = false;
			}

			// Verify
			if(!displayName.equals(m_displayNameVerifyTest))
			{
				trace("  ** ProcessName failed! Got: " + displayName
						+ " Expected: " + m_displayNameVerifyTest);
				testSuccess = false;
			}		
		}
		catch(Exception ex)
		{
			trace("Exception during ProcessName test: " + ex.getMessage());
			ex.printStackTrace();
			testSuccess = false;
		}
		
		try
		{
			trace(" -- Testing StringExclamation");
			StringExclamation exclamation = new StringExclamation();
			ArrayList<String> split = exclamation
					.splitByExclamation(m_stringTest);

			if(split.size() != m_stringVerifyTest.length)
			{
				trace("  ** StringExclamation failed! Got: " + split.size()
						+ " Expected: " + m_stringVerifyTest.length);
				testSuccess = false;

				if(!split.get(0).equals(m_stringVerifyTest[0]))
				{
					trace("  ** StringExclamation failed! Got: " + split.get(0)
							+ " Expected: " + m_stringVerifyTest[0]);
					testSuccess = false;
				}

				if(!split.get(1).equals(m_stringVerifyTest[1]))
				{
					trace("  ** StringExclamation failed! Got: " + split.get(1)
							+ " Expected: " + m_stringVerifyTest[1]);
					testSuccess = false;
				}
			}
		}
		catch(Exception ex)
		{
			trace("Exception during StringExclamation test: " + ex.getMessage());
			ex.printStackTrace();
			testSuccess = false;
		}

		trace("");
		if(testSuccess)
		{
			trace(" ** Success ** ");
		}
		else
		{
			trace(" ** Failed **");
		}
		trace("Test complete");

	}

	static private void trace(String msg)
	{
		System.out.println(msg);
	}

	// Test data
	// DateFormat
	static private String m_dateVerifyTest = "20 October 1961";
	static private Calendar m_testDate = Calendar.getInstance();

	// ProcessName
	static private String[] m_nameTest = new String[] { "Scott", "Kevin",
			"LaChance" };
	static private String m_nameVerifyTest = "Scott K. LaChance";
	static private String m_displayNameVerifyTest = "LaChance, Scott";

	// StringExclamation
	static private String m_stringTest = "Hello from!the second line";
	static private String[] m_stringVerifyTest = new String[] { "Hello from",
			"the second line" };

}
