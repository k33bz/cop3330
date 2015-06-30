package week07;

import java.util.ArrayList;

import test.AbstractTestCase;

public class TestCaseDataAccess extends AbstractTestCase
{
	public TestCaseDataAccess()
	{
		super("TestCaseDataAccess");
		builder = new StringBuilder();
	}

	@Override
	protected boolean runTest()
	{
		String file = "./src/week07/TestFile.txt";
		boolean result = false;
		try
		{
			trace("Opening data access for " + file);
			DataAccess da = new DataAccess(file);

			ArrayList<Book> books = da.loadData();

			if( books.size() == 3 )
			{
				result = true;
			}
			
			da.saveData(books);
			result = true;
		}
		catch(Exception ex)
		{
			builder.append(ex.getMessage());
			trace("Exception in RunTest: " + ex.getMessage());
			result = false;
		}

		return result;
	}

	@Override
	protected String results()
	{	
		return builder.toString();
	}
	
	private StringBuilder builder; 

}
