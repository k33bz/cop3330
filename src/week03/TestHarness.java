package week03;

import java.text.DecimalFormat;

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

		trace(" -- Testing LoanCalculator");
		LoanCalculator loan = new LoanCalculator(m_loanAmount, m_interestRate,
				m_loanPeriod);
		loan.calculate();
		String monthlyPayment = loan.getLoanMonthlyPayment();
		double monthlyInterest = loan.getLoanMonthlyInterest();
		int numberPayments = loan.getLoanNumberOfPayments();
		String totalPayment = loan.getLoanTotalPayment();

		// Verify
		if(!monthlyPayment.equals(m_verifyMonthlyPayment))
		{
			trace("  ** Monthly payment failed! Got: " + monthlyPayment
					+ " Expected: " + m_verifyMonthlyPayment);
			testSuccess = false;
		}

		// Round the double to a consistent number of decimals
		// for comparison
		double rndInterest = roundDecimal(monthlyInterest);
		double rndVerifyInterest = roundDecimal(m_verifyMontylyInterest);
		if(!(rndInterest == rndVerifyInterest))
		{
			trace("  ** Monthly interest failed! Got: " + monthlyInterest
					+ " Expected: " + m_verifyMontylyInterest);
			testSuccess = false;
		}

		if(!(numberPayments == m_getNumberOfPayments))
		{
			trace("  ** Number of payments failed! Got: " + numberPayments
					+ " Expected: " + m_getNumberOfPayments);
			testSuccess = false;
		}

		if(!totalPayment.equals(m_verifyTotalPayment))
		{
			trace("  ** Monthly payment failed! Got: " + totalPayment
					+ " Expected: " + m_verifyTotalPayment);
			testSuccess = false;
		}

		trace(" -- Testing BodyMassIndex");
		BodyMassIndex bmi = new BodyMassIndex();
		for(BmiTestData btd : m_bmiTest)
		{
			double result = bmi.calculateBMI(btd.weight, btd.height);
			double actual = roundDecimal(result);
			double expected  = roundDecimal(btd.expected);
			if(actual != expected)
			{
				trace("  ** BMI failed! Got: " + actual + " Expected: "
						+ expected);
			}
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

	/**
	 * Rounds a decimal using the DecimalFormat class
	 * 
	 * @param d Decimal to round
	 * @return
	 */
	static double roundDecimal(double d)
	{
		DecimalFormat twoDForm = new DecimalFormat("#.######");
		return Double.valueOf(twoDForm.format(d));
	}

	// Test data
	// LoanCalculator
	static private double m_loanAmount = 10000.00;
	static private double m_interestRate = 6.5;
	static private int m_loanPeriod = 5;
	static private String m_verifyMonthlyPayment = "195.66";
	static private double m_verifyMontylyInterest = 0.005416666666666666;
	static private int m_getNumberOfPayments = 60;
	static private String m_verifyTotalPayment = "11739.69";

	// BodyMassIndex
	static class BmiTestData
	{
		public BmiTestData(int w, int h, double e)
		{
			weight = w;
			height = h;
			expected = e;
		}

		public int weight;
		public int height;
		public double expected;
	}

	static private BmiTestData[] m_bmiTest = new BmiTestData[] {
			new BmiTestData(200, 77, 23.713948389273064),
			new BmiTestData(130, 68, 19.764273356401386),
			new BmiTestData(175, 72, 23.731674382716047),
			new BmiTestData(190, 62, 34.74765868886577) };
}
