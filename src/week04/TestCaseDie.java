package week04;

import test.AbstractTestCase;

public class TestCaseDie extends AbstractTestCase
{
	/**
	 * Default constructor
	 */
	public TestCaseDie()
	{
		super("DieTestCase");
		
		// other initialization code
	}

	@Override
	protected boolean runTest()
	{
		boolean result = true;
		Die one;
		Die two;
		Die three;

        one = new Die();
        two = new Die();
        three = new Die();

        one.roll();
        two.roll();
        three.roll();

        if(one.getNumber() == two.getNumber() && two.getNumber() == three.getNumber())
        {
        	result = false;
        	m_results = "Expected different numbers";
        }
        trace("Results are " + one.getNumber() + "  "
                + two.getNumber() + "  " + three.getNumber());
//        m_results = "Results are " + one.getNumber() + "  "
//                + two.getNumber() + "  " + three.getNumber();
        return result;

	}

	@Override
	protected String results()
	{
		// TODO Auto-generated method stub
		return m_results;
	}

	protected String m_results = "";
}
