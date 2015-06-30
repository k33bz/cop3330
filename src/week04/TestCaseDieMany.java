package week04;

import test.AbstractTestCase;

public class TestCaseDieMany extends AbstractTestCase
{

	public TestCaseDieMany()
	{
		super("DieManyTestCase");
	}

	@Override
	protected boolean runTest()
	{
		boolean result = true;
		ManySidedDie one = new ManySidedDie(8, false);
		ManySidedDie two = new ManySidedDie(12, true);
		ManySidedDie three = new ManySidedDie(20, false);

		try
		{
			do
			{
				one.roll();
				// two.roll();
				three.roll(); // explicit method call
				String info = String.format(" run %d: %d, %d, %d", m_runs,
						one.getNumber(), two.getNumber(), three.getNumber());
				trace(info);
				if(one.getNumber() == two.getNumber()
						&& two.getNumber() == three.getNumber())
				{
					result = false;
					m_results += "Expected different numbers:" + one.getNumber()
							+ ", " + two.getNumber() + ", " + three.getNumber() + "\n";
				}
				else
				{
					m_results = "DieV2TestCase successful" + "\n";
				}

				two.roll();
			}
			while(m_runs++ < 10);
		}
		catch(Exception ex)
		{
			m_results = "DieV2TestCase Exception" + ex.getMessage() + "\n";
		}

		return result;
	}

	@Override
	protected String results()
	{
		return m_results;
	}

	protected String m_results = "";
	private int m_runs = 0;
}
