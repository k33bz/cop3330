package week03;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Week3 Loan Calculator
 * 
 * This is a guided coding assignment with some of the
 * code filled in and place holders for you to implement
 * 
 * @author scottl
 *
 */
public class LoanCalculator
{
	/**
	 * Constructor
	 * @param loanAmount Amount of the loan
	 * @param interest Loan interest rate
	 * @param period Loan period in years
	 */
	public LoanCalculator(double loanAmount, double interest, int period)
	{
		m_formatter = new DecimalFormat(m_decimalFormat);
		m_loanAmount = loanAmount;
		m_loanInterest = interest;
		m_loanPeriod = period;
	}
	
	
	/* Getter Methods */
	
	public double getLoanMonthlyInterest()
	{
		return m_loanMonthlyInterest;
	}

	public String getLoanMonthlyPayment() 
	{
		return m_formatter.format(m_loanMonthlyPayment);
	}


	public String getLoanTotalPayment()
	{
		return  m_formatter.format(m_loanTotalPayment);
	}


	public int getLoanNumberOfPayments()
	{
		return m_loanNumberOfPayments;
	}
	
	/**
	 * Calculate the monthly loan interest,
	 * number of payments, the monthly payment
	 * and the total payment.
	 * Refer to page 133 of your text, middle of the page for the formulas to
	 * calculate 
	 */
	public void calculate()
	{
		m_loanNumberOfPayments = m_loanPeriod * MONTHS_IN_YEAR;
		
		m_loanMonthlyInterest = m_loanInterest / (100 * MONTHS_IN_YEAR); //annual interest rate in decimal format
		
		m_loanMonthlyPayment = ( m_loanMonthlyInterest + ( m_loanMonthlyInterest / ( Math.pow( ( 1 + m_loanMonthlyInterest ) , ( m_loanNumberOfPayments ) ) - 1 ) ) ) * m_loanAmount;
		
		m_loanTotalPayment = ( ( m_loanMonthlyInterest * m_loanAmount ) / ( 1 - Math.pow( ( 1 + m_loanMonthlyInterest ) , ( -1 * m_loanNumberOfPayments ) ) ) ) * m_loanNumberOfPayments;
			
	}	

	private static String m_decimalFormat = "0.00";
	private DecimalFormat m_formatter;
	private double m_loanAmount;
	private double m_loanInterest;
	private int m_loanPeriod;
	private double m_loanMonthlyInterest;
	private double m_loanMonthlyPayment;
	private double m_loanTotalPayment;
	private int m_loanNumberOfPayments;
	private final int MONTHS_IN_YEAR = 12;
}
