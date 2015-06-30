package week05;

import java.util.Random;

/**
 * This is a guided programming assignment
 * It will use enumerations, arrays, selection and repetition.
 * Review the TestCaseVegas.java code
 * @author scottl
 *
 */
public class LasVegasGame
{	
	/**
	 * Enumeration of valid guesses
	 * @author scottl
	 *
	 */
	public enum GUESS
	{
		BETWEEN,
		NOT_BETWEEN
	}
	/**
	 * Constructor
	 */
	public LasVegasGame()
	{
		m_random = new Random();
	}
	
	public void startSession()
	{
		m_lowInt = 0;  // low number
	    m_hiInt = 0;   // high number
	    m_nextInt = 0; // next random number
	    m_winners = 0; // number of wins
	    m_losers = 0;  // number of losses
	}
	
	/**
	 * Starts a new guessing session
	 * @return An array of two ints. int[0] = lo, int[1]=hi
	 */
	public int[] startGame()
	{
		generateRandomInts();
		
		// Note how we are initializing the return array
		int[] range = new int[]{m_lowInt, m_hiInt};
		return range;
	}
	
	/**
	 * This method uses the &&, !, || and enumerations to determine 
	 * whether the guess is a winner or not.
	 * @param guess
	 * @return
	 */
	public boolean guess(GUESS guess)
	{
		// get the next random it.
		m_nextInt = m_random.nextInt(MAX_RANGE);
				
		// Determine if the user won or lost and update the 
		// won/lost counters
		
		switch(guess)
		{
			case BETWEEN:
				//guess nextInt will be between high and low
				if(m_lowInt < m_nextInt && m_nextInt < m_hiInt) {
					//guessed right
					m_winners++;
					m_gameWon = true;
				} else {
					//guessed wrong
					m_losers++;
					m_gameWon = false;
				}
				break;
			case NOT_BETWEEN:
				//guess nextInt not will be between high and low
				if(!(m_lowInt < m_nextInt && m_nextInt < m_hiInt)) {
					//guessed right
					m_winners++;
					m_gameWon = true;
				} else {
					//guessed wrong
					m_losers++;
					m_gameWon = false;
				}
				break;
			default:
				m_losers++;
				m_gameWon = false;
				break;
		}

		return m_gameWon;
	}

    /**
     * Returns the summary of wins and losses
     * 
     * @return Formatted string of wins and losses
     */
    public String endGame()
    {
        return String.format(END_GAME, m_winners, m_losers);
    }
    
    public int getWinnerCount()
    {
		return m_winners;
    }
    
    public int getLosersCount()
    {
		return m_losers;
    }
	
    /**
     * Generate two random integers and assign
     * them to m_lowInt and m_hiInt respectively
     */
	private void generateRandomInts()
	{
		int random_a = m_random.nextInt(MAX_RANGE);
		int random_b;
		do {
			random_b = m_random.nextInt(MAX_RANGE);
		} while(random_b == random_a);
		
		if(random_a > random_b) {
			m_lowInt = random_b;
			m_hiInt = random_a;
		} else {
			m_lowInt = random_a;
			m_hiInt = random_b;
		}
	}
	
	private int m_lowInt = 0;  // low number
    private int m_hiInt = 0;   // high number
    private int m_nextInt = 0; // next random number
    private int m_winners = 0; // number of wins
    private int m_losers = 0;  // number of losses
    private boolean m_gameWon; // Indicates if
    private Random m_random;
    private static final int MAX_RANGE = 100; // max range 
    private static final String END_GAME = "Winners: %d, Losers: %d";
}
