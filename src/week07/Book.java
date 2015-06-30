package week07;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * An instance of this class represents a single library book. To use this class
 * you must
 * 
 * @author Scott LaChance
 */
public class Book
{
	/**
	 * Constructor.
	 * 
	 * @param dueDate
	 *            the due date of this book
	 * 
	 */
	public Book(GregorianCalendar dueDate)
	{
		this(dueDate, CHARGE_PER_DAY);
	}

	/**
	 * Constructor.
	 * 
	 * @param dueDate
	 *            the due date of this book
	 * @param chargePerDay
	 *            charge per overdue day
	 * 
	 */
	public Book(GregorianCalendar dueDate, double chargePerDay)
	{
		this(dueDate, chargePerDay, MAX_CHARGE);
	}

	/**
	 * Constructor.
	 * 
	 * @param dueDate
	 *            the due date of this book
	 * @param chargePerDay
	 *            charge per overdue day
	 * @param maximumCharge
	 *            the maximum possible charge
	 * @param title
	 *            the title of this book
	 * 
	 */
	public Book(GregorianCalendar dueDate, double chargePerDay,
			double maximumCharge)
	{
		this(dueDate, DEFAULT_TITLE, chargePerDay, maximumCharge );
	}

	/**
	 * Constructor.
	 * 
	 * @param dueDate
	 *            the due date of this book
	 * @param chargePerDay
	 *            charge per overdue day
	 * @param maximumCharge
	 *            the maximum possible charge
	 * @param title
	 *            the title of this book
	 * 
	 */
	public Book(GregorianCalendar dueDate, String title, double chargePerDay,
			double maximumCharge)
	{

		setDueDate(dueDate);
		setChargePerDay(chargePerDay);
		setMaximumCharge(maximumCharge);
		setTitle(title);
	}
	
	public Book clone()
	{
		return new Book(getDueDate(), getTitle(), getChargePerDay(), getMaxCharge());
	}

	/**
	 * Computes the overdue charge for the specified return date
	 * 
	 * @param returnDate
	 *            the date the book is/to be returned
	 * 
	 * @return the amount of overdue charge
	 */
	public double computeCharge(GregorianCalendar returnDate)
	{
		//throw new RuntimeException("Not Implemented");
		
		double fine = 0.0;
		
		GregorianCalendar dueDate = getDueDate();
		long days = DateDiff.getDiffInDays(dueDate, returnDate);
		
		System.out.println("DUEDATE: " + dueDate.getTime().toString());
		
		if(days > 0) {
			fine = chargePerDay * days;
			fine = fine > maximumCharge ? maximumCharge : fine;
		}
		
		fine = roundDecimal(fine); //#.##
		return fine;
	}
	
	
	/**
	 * Rounds a decimal using the DecimalFormat class
	 * 
	 * @param d Decimal to round
	 * @return
	 */
	private static double roundDecimal(double d)
	{
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	/**
	 * Returns the per day charge of this book
	 * 
	 * @return the per day charge of this book
	 */
	public double getChargePerDay()
	{
		//throw new RuntimeException("Not Implemented");
		return chargePerDay;
	}

	/**
	 * Returns the due date of this book
	 * 
	 * @return the due date of this book
	 */
	public GregorianCalendar getDueDate()
	{
		//throw new RuntimeException("Not Implemented");
		return dueDate;
	}

	/**
	 * Returns the maximum possible charge of this book
	 * 
	 * @return the maximum possible charge of this book
	 */
	public double getMaxCharge()
	{
		//throw new RuntimeException("Not Implemented");
		return maximumCharge;
	}

	/**
	 * Returns the title of this book
	 * 
	 * @return the title of this book
	 */
	public String getTitle()
	{
		//throw new RuntimeException("Not Implemented");
		return title;
	}

	/**
	 * Sets the per day charge of this book
	 * 
	 * @param charge
	 *            the per day charge of this book
	 */
	public void setChargePerDay(double charge)
	{
		//throw new RuntimeException("Not Implemented");
		this.chargePerDay = charge;
	}

	/**
	 * Sets the due date of this book
	 * 
	 * @param date
	 *            the due date of this book
	 */
	public void setDueDate(GregorianCalendar date)
	{
		//throw new RuntimeException("Not Implemented");
		this.dueDate = date;
	}

	/**
	 * Sets the maximum possible charge for this book
	 * 
	 * @param charge
	 *            the maximum possible charge for this book
	 */
	public void setMaximumCharge(double charge)
	{
		//throw new RuntimeException("Not Implemented");
		this.maximumCharge = charge;
	}

	/**
	 * Sets the title of this book
	 * 
	 * @param title
	 *            the title of this book
	 */
	public void setTitle(String title)
	{
		//throw new RuntimeException("Not Implemented");	
		this.title = title;
	}

	/**
	 * Returns the string representation of this book in the format <title>
	 * <charge per day> <max chanrge> <due date>
	 * 
	 * @return string representation of this book
	 */
	public String toString()
	{

		return String.format("%-30s    $%5.2f    $%7.2f    %4$tm/%4$td/%4$ty",
				getTitle(), getChargePerDay(), getMaxCharge(),
				dueDate.getTime());

		// or you can do the following to get a similar result
		/*
		 * String tab = "\t";
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		 * DecimalFormat df = new DecimalFormat("0.00");
		 * 
		 * return getTitle() + tab + "$ " + df.format(getChargePerDay()) + tab +
		 * "$ " + df.format(getMaxCharge()) + tab +
		 * sdf.format(dueDate.getTime());
		 */
	}

	/** Default charge per day */
	private static final double CHARGE_PER_DAY = 0.50;

	/** Default maximum charge */
	private static final double MAX_CHARGE = 50.00;

	/** Default title of the book */
	private static final String DEFAULT_TITLE = "Title unknown";
	
	/**
	 * Due date of the book
	 * 
	 * @uml.property name="dueDate"
	 */
	private GregorianCalendar dueDate;

	/**
	 * Title of the book (optional)
	 * 
	 * @uml.property name="title"
	 */
	private String title;

	/**
	 * Charge due per overdue day
	 * 
	 * @uml.property name="chargePerDay"
	 */
	private double chargePerDay;

	/**
	 * Maximum charge for the overdue
	 * 
	 * @uml.property name="maximumCharge"
	 */
	private double maximumCharge;	
}
