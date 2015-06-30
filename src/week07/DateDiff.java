package week07;

import java.util.GregorianCalendar;

public class DateDiff
{
	/**
	 * Calculates the number of days between two dates
	 * If the first date is greater than the second date the result is negative
	 * @param g1 first date
	 * @param g2 second date
	 * @return difference between the dates. A positive date means second date is after the first date
	 */
	public static long getDiffInDays(GregorianCalendar g1, GregorianCalendar g2)
	{
		  long milliseconds1 = g1.getTimeInMillis();
		  long milliseconds2 = g2.getTimeInMillis();
		  long diff = milliseconds2 - milliseconds1;
//		  long diffSeconds = diff / 1000;
//		  long diffMinutes = diff / (60 * 1000);
//		  long diffHours = diff / (60 * 60 * 1000);
		  long diffDays = diff / (24 * 60 * 60 * 1000);
		  
		  return diffDays;
	}
}
