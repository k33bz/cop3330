package week11;

import java.util.Arrays;
import java.util.Random;
import test.AbstractTestCase;

public class TestCaseSorting extends AbstractTestCase
{
	public TestCaseSorting()
	{
		super("TestCaseSorting");
	}

	@Override
	protected boolean runTest()
	{
		boolean success = true;
        int runs = 10;

        for(int i = 0; i < runs; i++)
        {
        	success = test();
        }

		return success;
	}

	@Override
	protected String results()
	{
		return m_results;
	}

    private boolean test()
    {
    	boolean result = true;
    	
        int[] testList = getTestList();

        trace(" Processing " + testList.length + " items...");
        // Make copies of the test data so we can compare them afterward
        // Remember, the array list gets passed by reference
        int[] bubbleList = Arrays.copyOf(testList, testList.length);
        int[] selectionList = Arrays.copyOf(testList, testList.length);
        int[] heapList = Arrays.copyOf(testList, testList.length);
        //int[] mySortList = Arrays.copyOf(testList, testList.length);
        //int[] quickList = Arrays.copyOf(testList, testList.length);

        BubbleSort bubble = new BubbleSort(bubbleList);
        SelectionSort selection = new SelectionSort(selectionList);
        HeapSort heap = new HeapSort(heapList);
        //MyClass mySort = new MyClass(mySortList);
        //QuickSort quick = new QuickSort(quickList);

        int[] bubbleSortedList = runTest(bubble);
        int[] selectionSortedList = runTest(selection);
        int[] heapSortedList = runTest(heap);
        //int[] mySortedList = runTest(mySort);
       // int[] quickSortedList = runTest(quick);

        if(!verifySorts(bubbleSortedList, selectionSortedList, heapSortedList))//,
                //quickSortedList))
        {
        	m_results += "Sort routines did not match\r\n";
        }
        
        return result;
    }

    private boolean verifySorts(int[] a, int[] b, int[] c)//, int[] d)
    {
        boolean result = true;

        // verify lengths are the same
        if(a.length != b.length && a.length != c.length && b.length != c.length)
                //&& b.length != d.length)
        {
            result = false;
            String msg = String
                    .format("Lengths different; bubble = %d, selection = %d, heap = %d", //d = %d",
                            a.length, b.length, c.length);//, d[i]);
            //trace(msg);
            m_results = msg + "\r\n";
        }
        else
        {
            for(int i = 0; i < a.length; i++)
            {
                boolean same = a[i] == b[i] && b[i] == c[i]; // using transitive
                if(!same)
                {
                    String msg = String
                            .format("Mismatched value at index %d; bubble = %d, selection = %d, heap = %d", //d = %d",
                                    i, a[i], b[i], c[i]);//, d[i]);
                    //trace(msg);
                    m_results = msg + "\r\n";
                    result = false;
                    break; // early out
                }
            }
        }

        return result;
    }

    private static int[] getTestList()
    {
        Random rand = new Random();
        int size = 10000;
        int[] list = new int[size];

        for(int i = 0; i < size; i++)
        {
            int val = rand.nextInt(size);
            list[i] = val;
        }

        return list;
    }

    private int[] runTest(AbstractSort sorter)
    {
        trace("Testing sort routine " + sorter.getName());
        trace("---------------------------------");
        long start = System.nanoTime();
        sorter.sort();
        long end = System.nanoTime();
        long elapsed = end - start;

        trace(String.format("Processed in: %d\r\n", elapsed));
        trace("=================================");
        return sorter.getList();
    }
	
	private String m_results = "";
}
