package week06;

public class RepetitionExample
{
	static int[] testData = new int[] { 2, 30, 30, 2, 40, 5, 6, 7, 8, 9, 100, 12, 16, 8 };
	
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        whileLoopExample();
        doLoopExample();
        doLoopBreakExample();
        nestedForExample();
    }

    private static void nestedForExample()
    {
    	// calculate and display the multiplication table for 1-12
    	int max = 12;
    	int min = 1;
    	// top header row
    	System.out.print("       ");
    	for(int i = min; i <= max; i++)
    	{
    		if( i == 9 )
    		{
    			System.out.print(i + "   ");
    		}
    		else if( i < 10)
    		{
    			System.out.print(i + "    ");
    		}
    		else
    		{
    			System.out.print(i + "   ");
    		}
    	}
    	
    	System.out.println();
   		System.out.print("-----------------------------------------------------------");
   		System.out.println();
   		
    	for(int i = min; i <= max; i++) // row number
    	{
    		if( i < 10 )
    		{
    			System.out.print(i + " |");
    		}
    		else
    		{
    			System.out.print(i + "|");
    		}
    		
    		for( int j = min; j <= max; j++)
    		{
    			int product = i*j;
    			System.out.format("%4d", product);
//    			if( product < 10 )
//        		{
//        			System.out.print("    " + product );
//        		}
//    			else if( product < 100)
//    			{
//    				System.out.print("   " + product );
//    			}
//        		else
//        		{
//        			System.out.print("  " + product);
//        		}
    			//System.out.print("  " + i*j);
    		}
    		System.out.println();
    	}
    }
    private static void doLoopBreakExample()
    {
    	System.out.println("doLoopExample");
    	
    	int rounds = testData.length / 2;
        System.out.println("Rounds:  " + rounds);
        RepetitionExample gcdInstance = new RepetitionExample();
        int i = 0;
        do
        {
            int m = testData[2 * i];
            int n = testData[2 * i + 1];
            int gcdResult = gcdInstance.getGcdDo(m, n);
            System.out.print("GCD result for ");
            System.out.print(Integer.toString(m));
            System.out.print(" and " + Integer.toString(n));
            System.out.println(" is " + Integer.toString(gcdResult));
            i++;
            if( i >= rounds) 
            {
            	break;
            }
        }while(true);	   	
    }
    
    private static void doLoopExample()
    {
    	System.out.println("doLoopExample");
    	
    	int rounds = testData.length / 2;
        System.out.println("Rounds:  " + rounds);
        RepetitionExample gcdInstance = new RepetitionExample();
        int i = 0;
        do
        {
            int m = testData[2 * i];
            int n = testData[2 * i + 1];
            int gcdResult = gcdInstance.getGcdDo(m, n);
            System.out.print("GCD result for ");
            System.out.print(Integer.toString(m));
            System.out.print(" and " + Integer.toString(n));
            System.out.println(" is " + Integer.toString(gcdResult));
            i++;
        }while(i < rounds);	
    }

    private static void whileLoopExample()
    {
    	System.out.println("whileLoopExample");
        
        int rounds = testData.length / 2;
        System.out.println("Rounds:  " + rounds);
        RepetitionExample gcdInstance = new RepetitionExample();
        int i = 0;
        while( i < rounds)        
        {
            int m = testData[2 * i];
            int n = testData[2 * i + 1];
            int gcdResult = gcdInstance.getGcd(m, n);
            System.out.print("GCD result for ");
            System.out.print(Integer.toString(m));
            System.out.print(" and " + Integer.toString(n));
            System.out.println(" is " + Integer.toString(gcdResult));
            i++;
        }
    }

    private int getGcd(int m, int n)
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

    private int getGcdDo(int m, int n)
    {
        int r;
        do
        {
        	r = n % m;
            n = m;
            m = r;
        }
        while(r != 0);

        return n;
    }

    private int getGcdBreak(int m, int n)
    {
        int r;
        while(true)
        {
        	r = n % m;
        	if(r == 0)
        	{
        		break;
        	}
        	
            n = m;
            m = r;
        }

        return m;
    }

}
