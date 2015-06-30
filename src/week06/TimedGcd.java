package week06;

import java.util.Date;

/**
 * Guided programming class for week 6
 * @author scottl & matthew
 *
 */
public class TimedGcd
{
	static enum ComputationType
	{
		BRUTE_FORCE,
		EUCLID
	}
	/**
	 * Compares the performance of two GCD implementations
	 * @param m Number to calculate GCD on
	 * @param n Number to calculate GCD on
	 */
	public TimedGcd()
	{
	}


	/**
	 * Start the timed calculations.
	 */
	public void start(long m, long n)
	{
		// This updates the internal state of the TimedGcd1 object
		m_bruteForceTime = timeMethod(m, n, ComputationType.BRUTE_FORCE);
		m_euclidTime = timeMethod(m, n, ComputationType.EUCLID);
	}

	public long getBruteForceTime()
	{
		return m_bruteForceTime;
	}

	public long getEuclidTime()
	{
		return m_euclidTime;
	}

	public long getBruteGcdValue()
	{
		return m_bruteForceGcd;
	}

	public long getEuclidGcdValue()
	{
		return m_euclidGcd;
	}

	private long timeMethod(long m, long n, ComputationType type)
	{
		Date startTime;
		Date stopTime;

		startTime = new Date();

		switch(type)
		{
			case BRUTE_FORCE:
				m_bruteForceGcd = bruteForceGcd(m, n);
				break;
			case EUCLID:
				m_euclidGcd = getGcdBreak(m, n);
				break;
		}

		stopTime = new Date();

		return stopTime.getTime() - startTime.getTime();
	}

	private long bruteForceGcd(long m, long n)
	{
		//assume m, n >= 1
		if(m < 1 || n < 1 ) {
			throw new RuntimeException("Out of bounds!");
		}
		
		long gcd = 0;
		long last = Math.min(m, n);
		
		int i = 1;
		
		while ( i <= last) {
			if(m % i == 0 && n % i == 0) { //remainders are both 0, then share a common denominator
				gcd = (long)i;
			}
			i++;
		}
		return gcd;
	}

	/**
	 * Implementation of algorithm on page 326 of text
	 * @param m Number to calcluate GCD for
	 * @param n Number to calcluate GCD for
	 * @return gcd value
	 */
	private long getGcdBreak(long m, long n)
    {
		//assume m, n >= 1
		if(m < 1 || n < 1 ) {
			throw new RuntimeException("Out of bounds!");
		}
		
		//it doesn't matter which m or n is larger
		//the method will return the same value

		long result;
		
		while(true) { //don't forget to add a break so we don't loop forever!
			result = n % m;
			if(result == 0) {
				break;
			}
			
			n = m;
			m = result;
		}
		
		return m;
    }

	private long m_bruteForceTime = 0;
	private long m_euclidTime = 0;
	private long m_bruteForceGcd = 0; //value
	private long m_euclidGcd = 0; //value
}
