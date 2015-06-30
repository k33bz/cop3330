/**
 * 
 */
package week06quiz;

/**
 * @author matthew
 *
 */
public class Week06Quiz
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// how many loops will execute? 9
		int theSquare = 0;
		int ctr = 1;
		int loopctr = 0;
		
		while(ctr < 10) {
			loopctr++;
			theSquare = ctr * ctr;
			System.out.println("The square of " + ctr + " is " + theSquare);
			ctr = ctr + 1;
		}
		
		System.out.println("Loops: " + loopctr); //9

	}

}
