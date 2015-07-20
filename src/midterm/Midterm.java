package midterm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Midterm
{

	public static void main(String[] args)
	{
		// Question 7
		StringBuffer word1, word2;
		word1 = new StringBuffer( "Lisa");
		word2 = word1;
		word2.insert(0, "Mona ");
		System.out.println(word2);

		// Question 8 of 12

		/*Determine the output of the following code when the input is 1, 0, and 12XY */
		Scanner scanner = new Scanner(System.in);
	

		try
		{
		    int num = scanner.nextInt();
		    if (num != 0)
		    {
		    	scanner.close();
		        throw new Exception("Not zero");
		    }
		    System.out.println("I'm happy with the input.");
		}
		catch (InputMismatchException e)
		{
		    System.out.println("Invalid Entry");
		}
		catch (Exception e)
		{
		    System.out.println("Error: " + e.getMessage());
		}
		
		scanner.close();
	}

}
