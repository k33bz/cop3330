package week02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demonstrates the use of SimpleDateFormat class and some basic formatting rules
 * 
 * @author scottl
 * @
 */
public class SampleDateFormat
{
	/**
	 * Default constructor
	 */
	public SampleDateFormat()
	{
		m_formatter = new SimpleDateFormat(m_dateFormat);
	}
	
	/**
	 * 
	 * @param d Input Date object instance to format
	 * @return Date formatted as a string
	 */
	public String formatDate(Date d)
	{
		String formattedString = m_formatter.format(d);
		return formattedString;
	}
	
	public static String m_dateFormat = "dd MMMM yyyy";
	public SimpleDateFormat m_formatter;
}
