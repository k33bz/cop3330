package week04;

import test.AbstractTestCase;

public class TestCaseDieV2 extends AbstractTestCase
{
	public TestCaseDieV2()
	{
		super("DieV2TestCase");
	}
	
	@Override
	protected boolean runTest()
	{
		boolean result = true;
		DieVer2 one;
		DieVer2 two;
		DieVer2 three;
		DieVer2 four;

        one = new DieVer2();
        two = new DieVer2();
        three = new DieVer2();
        four = new DieVer2();

        
        //two.roll();
        
        if(one.getNumber() == two.getNumber() && two.getNumber() == three.getNumber() && three.getNumber() == four.getNumber())
        {
        	result = false;
        	m_results = "Expected different numbers:" + one.getNumber() + ", " + two.getNumber() + ", " + three.getNumber()+ ", " + four.getNumber();
        }
        else
        {
        	m_results ="DieV2TestCase successful";
        }
        
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
