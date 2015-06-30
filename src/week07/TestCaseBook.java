package week07;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import test.AbstractTestCase;

public class TestCaseBook extends AbstractTestCase
{

	public TestCaseBook()
	{
		super("TestCaseBook");
		builder = new StringBuilder();
		builder.append("Initializing\r\n");
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		decimalFormatter = new DecimalFormat("#.00");
	}
	
	public void demoDateDiff()
	{
		GregorianCalendar g1 = new GregorianCalendar();
		GregorianCalendar g2 = new GregorianCalendar();
		DateDiff df = new DateDiff(); // creates an instance
		long result = DateDiff.getDiffInDays(g1, g2); // this uses the class method getDiffInDays
	}

	@Override
	protected boolean runTest()
	{
		initFilePath();
		//String file = "./src/week07/TestFile.txt";
		boolean result = false;
		boolean overdue = false;
		boolean changeDueDate = false;
		try
		{
			trace("Opening data access for " + m_filePath);
			DataAccess da = new DataAccess(m_filePath);

			ArrayList<Book> books = da.loadData();
			overdue = testOverdueCharge(books);
			changeDueDate = testChangeDueDate(books, da);

			// restore original data
			da.saveData(books);
			
		}
		catch(Exception ex)
		{
			trace("Exception during test: " + ex.getMessage());
			builder.append(ex.getMessage());
		}

		result = overdue && changeDueDate;
		builder.append(String.format("Overdue %s, Due date %s", overdue, changeDueDate));
		return result;
	}

	@Override
	protected String results()
	{
		return builder.toString();
	}

	
	private boolean testChangeDueDate(ArrayList<Book> books, DataAccess da)
	{
		trace(" ** Testing changing due date ** ");
		boolean result = true;
		ArrayList<Book> clones = new ArrayList<Book>();
		for(Book b : books)
		{
			try
			{
				clones.add(b.clone());
			}
			catch(Exception ex)
			{
				trace(" Error cloning book: " + ex.getMessage());
				result = false;
			}
		}
		
		GregorianCalendar testDate = new GregorianCalendar(2012, 7, 4);
		// clone the list so we don't make permanent changes
		for(Book book : clones)
		{
			book.setDueDate(testDate);
		}
		
		da.saveData(clones);
		
		ArrayList<Book> testData = da.loadData();
		
		for(Book b : testData)
		{
			if( !b.getDueDate().equals(testDate))
			{
				result = false;
				break;
			}
		}
		trace(" ** Testing changing due date complete ** ");
		return result;
	}
	
	private boolean testOverdueCharge(ArrayList<Book> books)
	{
		trace(" ** Testing overdue charge ** ");
		boolean result = false;
		for(Book b : books)
		{
			GregorianCalendar returnDate = new GregorianCalendar();
			double charge = b.computeCharge(returnDate);
			Date due = b.getDueDate().getTime();
			Date ret = returnDate.getTime();
			String fmt = String.format("Due: %s, Returned %s, charge %f",
					formatter.format(due), formatter.format(ret), charge);
			trace(fmt);
			if(charge > 0)
			{
				trace(" - Overdue charge: " + decimalFormatter.format(charge));
				result = true;
			}	
		}

		return result;
	}
	/**
	 * Setup the test file path.
	 * Dev environment and runtime environment have different
	 * current directory behavior.
	 * For runtime testing, it is the bin folder
	 * For development, it is the current project folder.
	 * The test will create a new File instance for the current directory.
	 * If the directory is bin, the we use the simple file name for the test
	 * If it isn't we append the .\src\week10\ to the file path.
	 * That way this will work in development and testing.
	 */
	private void initFilePath()
	{		
		File curDir = new File(".");
		File curDir1 = new File(curDir.getAbsolutePath());
		trace("Init file path " + curDir1.getAbsolutePath());
		trace("cur dir: " + curDir1.getName());
		trace("parent dir: " + curDir1.getParent());
		trace("curDir.getParentFile() " + (null == curDir1.getParentFile() ? "null" : curDir1.getParentFile().getName()));
		boolean exists = curDir1.exists();
		boolean isDir = curDir1.isDirectory();
		String bin = curDir1.getParentFile().getName();
		boolean b = bin.equals("bin");
		trace("exists - " + exists + ", isDir - " + isDir + ", " + bin + ", " + b);
		if( exists && isDir && b)
		{
			m_filePath = curDir1.getParentFile().getAbsolutePath() + "\\" + TEST_FILE;
		}
		else
		{
			trace("Using dev path");
			m_filePath = DEV_PATH + TEST_FILE;
		}
		
		trace(m_filePath);
	}

	private StringBuilder builder;
	private SimpleDateFormat formatter;
	private DecimalFormat decimalFormatter;
	private String m_filePath = "";
	private String TEST_FILE = "TestFile.txt";
	private String DEV_PATH = ".\\src\\week07\\";

}
