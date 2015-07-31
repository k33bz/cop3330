package week11;

import java.util.ArrayList;
import java.util.Random;
import test.AbstractTestCase;

public class TestCaseBinarySearch extends AbstractTestCase
{
	public TestCaseBinarySearch()
	{
		super("TestCaseBinarySearch");
	}
	
	@Override
	protected boolean runTest()
	{
		boolean result = true;
		StringBuffer buffer = new StringBuffer();
		
		trace("Fixed test");
		if( fixedTest() )
		{
			trace("-- success!");
		}
		else
		{
			trace("-- failed!");
			result = false;
		}
		
		trace("Test large list");
		Random rand = new Random();
        int runs = 30; // number of test runs
        long totaltime = 0; // sums the time to do each search
        int testDataSize = 10000; // number of items to search
        
        trace("Binary Test");
        long startTime = System.nanoTime();
        int[] list = generateTestData(rand, testDataSize);
        for(int i = 0; i < runs; i++)
        {
            int searchValue = rand.nextInt(testDataSize); // A random value to
                                                          // search for
            String msg = String.format("Run %d: searching for - %d,", i, searchValue);
            
            long start = System.nanoTime();
            test(list, searchValue);
            long end = System.nanoTime();

            long elapsed = end - start;

            if(i > 0)
            {
                totaltime += elapsed; // skip the first one, it is always long
                                      // compared to the rest of the tests
            }
            
            buffer.append(String.format("%s %d ns\n", msg, elapsed));
        }

        long endTime = System.nanoTime();
        double ave = (double)totaltime / (double)runs;
        long totalTestTime = endTime - startTime;

        buffer.append("Completed Binary Test: execution time - "
                + totalTestTime + "ms\nSearch time average - " + ave + " ns\n");
        m_result = buffer.toString();
        return result;
	}
	
	/**
	 * Tests using a fixed list of known values
	 * @return true if test is successful
	 */
	private boolean fixedTest()
	{
		boolean result = false;
		int[] array = new int[]{2,4,6,10,11,13,15,17,21,22,23,31,32,33,35,37,39,40,50,55,57,60,61,63,67,70,72,74,75,77};
		
		int expected = 37;
		IntBinarySearch binarySearch = new IntBinarySearch();

		switch(binarySearch.search(array,  expected))
		{
			case FOUND:
				result = true;
				break;
			case NOT_FOUND:
				result = false;
				break;
		}		
				
		return result;
	}

	@Override
	protected String results()
	{
		return m_result;
	}
	

	/**
	 * Uses IntBinarySearch to find the specified value
	 * 
	 * @param list List to search
	 * @param searchValue integer value to find
	 * @return AbstractSearch.RESULT enumeration NOT_FOUND or FOUND
	 */
    private AbstractSearch.RESULT test(int[] list, int searchValue)
    {
    	AbstractSearch.RESULT searchResult = AbstractSearch.RESULT.NOT_FOUND;
    	
        IntBinarySearch search = new IntBinarySearch();

        if(search.search(list, searchValue) == AbstractSearch.RESULT.FOUND)
        {
            searchResult = AbstractSearch.RESULT.FOUND;
        }
        
        return searchResult;
    }

    /**
     * Needs to be sorted for binary search to work
     * 
     * @return
     */
    private int[] generateTestData(Random rand, int size)
    {
        int[] list = new int[size];
        for(int i = 0; i < list.length; i++)
        {
            list[i] = rand.nextInt(size);
        }

       SelectionSort sort = new SelectionSort(list);
        sort.sort();

        return sort.getList();
    }

    String m_result = "";
}
