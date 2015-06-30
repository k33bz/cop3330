package week07;

/**
 * This class demonstrates returning an object from a method It has a separate
 * test harness, FractionTestHarness, to demonstrate the usage of the class
 * 
 * An instance represents a fraction
 * @author scottl
 * 
 */
public class Fraction
{
	/**
	 * Constructor
	 * Creates an instance of a fraction
	 * 
	 * @param numerator
	 *            the numerator to set
	 * @param denominator
	 *            the denominator to set
	 */
	public Fraction(int numerator, int denominator)
	{
		setNumerator(numerator);
		setDenominator(denominator);
	}

	/**
	 * Checks the equality of an object
	 * Enumerator and Denominator must be the same.
	 * 
	 * @param obj Object to check equality with
	 * @return true if the fractions are equal. 
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;

		if(obj instanceof Fraction)
		{
			Fraction f = (Fraction)obj;
			if(this.getNumerator() == f.getNumerator()
					&& this.getDenominator() == f.getDenominator())
			{
				result = true;
			}
		}
		return result;
	}

	/**
	 * Reduces a fraction to its simplest form.
	 * 
	 * @return the simplest version of the fraction
	 */
	public Fraction simplify()
	{
		Fraction simple;

		int num = getNumerator();
		int denom = getDenominator();
		int gcd = gcd(num, denom);

		// return a new Fraction object
		simple = new Fraction(num / gcd, denom / gcd);
		return simple;
	}

	/**
	 * Add two fractions
	 * @param frac The fraction to add
	 * @return the sum of this fraction and the provided fraction
	 */
	public Fraction add(Fraction frac)
	{
		int a, b, c, d;
		Fraction sum;

		a = this.getNumerator(); // get the receiving
		b = this.getDenominator(); // object's num and denom

		c = frac.getNumerator(); // get frac's num
		d = frac.getDenominator(); // and denom

		sum = new Fraction(a * d + b * c, b * d);

		return sum;
	}
    
    /**
     * Overloaded method that takes a number
     * @param number Number to divide by
     * @return Fraction that is the result of the division, not simplified
     */
    public Fraction add(int number)
    {
    	return add(new Fraction(number,1));
    }
	
    /**
     * Returns the smaller of the two parameters f1 and f2
     * 
     * @param f1
     *            the first fraction to compare
     * @param f2
     *            the second fraction to compare
     * 
     * @return the smaller of the two parameters
     */
    public static Fraction min(Fraction f1, Fraction f2)
    {

        // convert to decimals and then compare

        double f1_dec = f1.decimal();
        double f2_dec = f2.decimal();

        if(f1_dec <= f2_dec)
        {

            return f1;

        }
        else
        {

            return f2;
        }
    }
    
    /**
     * Returns the quotient of this Fraction divided by the parameter frac. The
     * quotient returned is NOT simplified.
     * 
     * @param frac
     *            the divisor of the division
     * 
     * @return the quotient of this fraction divided by frac
     */
    public Fraction divide(Fraction frac)
    {
        int a, b, c, d;

        Fraction quotient;

        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        quotient = new Fraction(a * d, b * c);

        return quotient;
    }
    
    /**
     * Overloaded method that takes a number
     * @param number Number to divide by
     * @return Fraction that is the result of the division, not simplified
     */
    public Fraction divide(int number)
    {
    	return divide(new Fraction(number,1));
    }
    
    /**
     * Returns the product of this Fraction and the parameter frac. The product
     * returned is NOT simplified.
     * 
     * @param frac
     *            the multiplier of the multiplication
     * 
     * @return the product of this fraction and the parameter frac
     */
    public Fraction multiply(Fraction frac)
    {
        int a, b, c, d;

        Fraction product;

        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        product = new Fraction(a * c, b * d);

        return product;
    }    
    
    /**
     * Overloaded method that takes a number
     * @param number Number to divide by
     * @return Fraction that is the result of the division, not simplified
     */
    public Fraction multiply(int number)
    {
    	return multiply(new Fraction(number,1));
    }
    
    /**
     * Returns the difference of this Fraction and the parameter frac. The
     * difference returned is NOT simplified.
     * 
     * @param frac
     *            the Fraction to subtract from this Fraction
     * 
     * @return the difference of this and frac
     */
    public Fraction subtract(Fraction frac)
    {
        int a, b, c, d;

        Fraction diff;

        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        diff = new Fraction(a * d - b * c, b * d);

        return diff;
    } 
    
    /**
     * Overloaded method that takes a number
     * @param number Number to divide by
     * @return Fraction that is the result of the division, not simplified
     */
    public Fraction subtract(int number)
    {
    	return subtract(new Fraction(number,1));
    }
    
	/**
	 * Returns the fraction as a string in the following format num/denom
	 * 
	 * @return Formatted fraction string
	 */
	public String display()
	{
		return getNumerator() + "/" + getDenominator();
	}

	/**
	 * @return the denominator
	 */
	public int getDenominator()
	{
		return m_denominator;
	}

	/**
	 * @param denominator
	 *            the denominator to set
	 * @throws IllegalArgumentException
	 *             if zero is provided
	 */
	public void setDenominator(int denominator)
	{
		// Precondition check
		if(denominator == 0)
		{
			throw new java.lang.IllegalArgumentException(
					"Denominator cannot be zero");
		}

		this.m_denominator = denominator;
	}

	/**
	 * @return the numerator
	 */
	public int getNumerator()
	{
		return m_numerator;
	}

	/**
	 * @param numerator
	 *            the numerator to set
	 */
	public void setNumerator(int numerator)
	{
		this.m_numerator = numerator;
	}

	/**
	 * Calculates the greatest common denominator
	 * 
	 * @param m
	 * @param n
	 * @return RepetitionExample
	 */
	private int gcd(int m, int n)
	{
		int r = n % m;
		while(r != 0)
		{
			n = m;
			m = r;
			r = n % m;
		}

		return m;
	}
	
    /**
     * Returns the decimal equivalent of this fraction
     * 
     * @return the decimal equivalent of this fraction
     */
    private double decimal()
    {
        // returns the decimal equivalent
        return (double)getNumerator() / getDenominator();
    }
	// Private Data
	private int m_denominator;
	private int m_numerator;
}
