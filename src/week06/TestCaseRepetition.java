package week06;

import java.util.Date;

import test.AbstractTestCase;

public class TestCaseRepetition extends AbstractTestCase
{

	protected TestCaseRepetition()
	{
		super("TestCaseRepetition");
	}

	@Override
	protected boolean runTest()
	{
		TimedGcd gcd = new TimedGcd();
		Date start = new Date();
		boolean result = true;
		int run = 1;
		for(TestData test : m_testData)
		{
			trace("test " + run);
			m_result += "\n\ntest " + run++;
			try
			{
				trace(" - executing GCD calculation");
				gcd.start(test.getM(), test.getN());
				m_result += "\nM: " + test.getM();
				m_result += "\nN: " + test.getN();
				m_result += "\nBrute force time: " + gcd.getBruteForceTime();
				m_result += "\nEuclid time: " + gcd.getEuclidTime();
				long brute = gcd.getBruteGcdValue();
				long euclid = gcd.getEuclidGcdValue();
				m_result += "\nBrute GCD: " + gcd.getBruteGcdValue();
				m_result += "\nEuclid GCD: " + gcd.getEuclidGcdValue();
				if(brute != euclid)
				{
					result = false;
					m_result += "\r\nDifferent GCD calculated:\r\nbrute = " + brute;
					m_result += "\r\neuclid = " + euclid;
				}
				trace(" - Completed GCD calculation");
			}
			catch(ArithmeticException ex )
			{
				trace("Error processing");
				m_result += "\r\nError for ";
				m_result += "\r\nM: " + test.getM();
				m_result += "\r\nN: " + test.getN();
				result = false;
			}
		}
		
		Date end = new Date();
		long diff = end.getTime() - start.getTime();
		
		m_result += String.format("\r\nElapses time in sec: %d", diff/1000);
		return result;
	}

	@Override
	protected String results()
	{
		return m_result;
	}

	private String m_result = "";
	private TestData[] m_testData = new TestData[] { 
			new TestData(4567820, 2147483640),
			new TestData(545690876L, 3456901294L),
			new TestData(546587619L, 21474836121L),
			new TestData(951987545L, 21474836651L),
			new TestData(1542354865L, 3216548445L),
			new TestData(10,5)
			};
}

class TestData
{
	public TestData(long m, long n)
	{
		m_M = m;
		m_N = n;
	}

	public long getM()
	{
		return m_M;
	}

	public long getN()
	{
		return m_N;
	}

	private long m_M;
	private long m_N;
}
