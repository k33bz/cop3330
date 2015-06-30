package week07;

import java.util.ArrayList;

import test.AbstractTestCase;

public class TestCaseFraction extends AbstractTestCase
{
	public TestCaseFraction()
	{
		super("TestCaseFraction");
		builder = new StringBuilder();
		
		// Initialize test data
		m_testData = new ArrayList<FractionTestData>();
		m_testData.add(new FractionTestData(3, 4, 3, 4));
		m_testData.add(new FractionTestData(5, 10, 1, 2));
		m_testData.add(new FractionTestData(8, 24, 1, 3));
		m_testData.add(new FractionTestData(9, 24, 3, 8));
	}

	/**
	 * Run the test cases for each of the numerator/denominator pairs
	 * 
	 */
	@Override
	protected boolean runTest()
	{
		boolean result = true;
		
		trace("Testing simplify");
		for(FractionTestData test : m_testData)
		{
			Fraction f = new Fraction(test.numerator, test.denominator);			
			Fraction actual = f.simplify();
			if( !actual.equals(test.expected))
			{
				result = false;
				builder.append("Failed for fraction " + f.display());
			}
		}
		
		// Test division by zero
		trace("Testing division by zero");
		try
		{
			@SuppressWarnings("unused")
			Fraction zero = new Fraction(9, 0);
			result = false;
			builder.append("Division by zero test failed ");
		}
		catch(IllegalArgumentException ex)
		{
			// successful test
			result = true;
		}
		
		// Test addition
		trace("Testing addition");
		Fraction left = new Fraction(3, 4);
		Fraction right = new Fraction(6, 8);
		Fraction expected = new Fraction(3,2);
		Fraction actual = left.add(right);
		actual = actual.simplify();
		if( !actual.equals(expected))
		{
			result = false;
			builder.append("Failed for fraction. Expected " + expected.display() + " got " + actual.display());
		}
		
		// Test subtraction
		trace("Testing subtraction");
		left = new Fraction(3, 4);
		right = new Fraction(7, 8);
		expected = new Fraction(1,8);
		actual = right.subtract(left);
		actual = actual.simplify();
		if( !actual.equals(expected))
		{
			result = false;
			builder.append("Failed for fraction. Expected " + expected.display() + " got " + actual.display());
		}
		
		// Test multiplication
		trace("Testing multiplication");
		left = new Fraction(3, 4);
		right = new Fraction(7, 8);
		expected = new Fraction(21,32);
		actual = right.multiply(left);
		actual = actual.simplify();
		if( !actual.equals(expected))
		{
			result = false;
			builder.append("Failed for fraction. Expected " + expected.display() + " got " + actual.display());
		}
		
		// Test division
		trace("Testing division");
		left = new Fraction(3, 4);
		right = new Fraction(7, 8);
		expected = new Fraction(7,6);
		actual = right.divide(left);
		actual = actual.simplify();
		if( !actual.equals(expected))
		{
			result = false;
			builder.append("Failed for fraction. Expected " + expected.display() + " got " + actual.display());
		}
		
		return result;
	}

	@Override
	protected String results()
	{
		// TODO Auto-generated method stub
		return builder.toString();
	}

	private ArrayList<FractionTestData> m_testData;	
	private StringBuilder builder;
}

class FractionTestData
{
	public FractionTestData(int numerator, int denominator, int expectedNum, int expectedDen)
	{
		this.numerator = numerator;
		this.denominator = denominator;
		expected = new Fraction(expectedNum, expectedDen);
	}
	
	public int numerator;
	public int denominator;
	
	Fraction expected;
}
