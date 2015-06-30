package week02;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * 
 * @author Matthew Kastro
 *
 */
public class DateFormat
{
	// Example of a class-scoped attribute
	private static String m_dateFormat = "dd MMMM yyyy"; //ex: 30 December 1999
	private static SimpleDateFormat m_formatter;
	
	public DateFormat() {
		/**
		 * Default constructor
		 */
		m_formatter = new SimpleDateFormat(m_dateFormat);
		
	}

	public String formatDate(Date testDate)
	{
		return m_formatter.format(testDate);
	}

	public String getCurrentDate()
	{
		//return current date
		Calendar c = GregorianCalendar.getInstance();
		Date d = c.getTime();
		return formatDate(d);
	}
	
	

}
