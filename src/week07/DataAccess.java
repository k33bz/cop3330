package week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DataAccess
{
	/**
	 * Constructor
	 * The file format is
	 * DueDate, Title, ChargePerDay, MaximumCharge
	 * 
	 * DueDate has the following format MM/dd/yyyy
	 * Title has no maximum length
	 * ChargePerDay has the following format 0.00
	 * MaximumCharge has the following format 0.00
	 * 
	 * @param filePath Data file path
	 */
	public DataAccess(String filePath)
	{
		m_filePath = filePath;
		m_formatter = new DecimalFormat(m_decimalFormat);
		m_dateFormatter = new SimpleDateFormat(m_dateFormat);
	}
	
	/**
	 * Reads the data from the file and returns
	 * the fully populated list of books
	 * @return List of books
	 */
	public ArrayList<Book> loadData()
	{
		ArrayList<Book> books = new ArrayList<Book>();
		FileReader fs = null;
		BufferedReader reader = null;
		try
		{
			File file = new File(m_filePath);
			
			fs = new FileReader(file);
			reader = new BufferedReader(fs);
			String line = "";
			while((line = reader.readLine()) != null)
			{
				// Get a new book instance
				Book b = getBook(line);
				books.add(b);
			}
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if( reader != null) try{reader.close();}catch(IOException ex){}
		}
		
		return books;
	}
	
	/**
	 * Saves the list of books to the file
	 * @param books
	 */
	public void saveData(ArrayList<Book> books)
	{
		FileWriter fs = null;
		BufferedWriter writer = null;
		
		try
		{
			File file = new File(m_filePath);
			
			fs = new FileWriter(file);
			writer = new BufferedWriter(fs);
			
			for(Book b : books)
			{
				// prep the line
				String line = prepBookInfo(b);
				
				// write the line
				writer.write(line);				
			}
			
			writer.flush();

		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if( writer != null) try{writer.close();}catch(IOException ex){}
		}
	}
	
	private String prepBookInfo(Book b)
	{
		String date = m_dateFormatter.format(b.getDueDate().getTime());
		String title = b.getTitle();
		String charge = m_formatter.format(b.getChargePerDay());
		String max = m_formatter.format(b.getMaxCharge());
		
		return String.format(m_bookFormat, date, title, charge, max);
	}
	
	private Book getBook(String bookInfo)
	{
		String[] info = bookInfo.split(",");
		String[] date = info[0].split("/");
		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		GregorianCalendar d = new GregorianCalendar(year, month - 1, day);
		String title = info[1];
		double charge = Double.parseDouble(info[2]);
		double max = Double.parseDouble(info[3]);
		
		return new Book(d, title, charge, max);
		
	}
	
	
	private String m_filePath;
	private DecimalFormat m_formatter;
	private static String m_decimalFormat = "0.00"; 
	private SimpleDateFormat m_dateFormatter;
	private static String m_dateFormat = "MM/dd/yyyy"; 
	private static String m_bookFormat = "%s,%s,%s,%s\r\n";
	
}
