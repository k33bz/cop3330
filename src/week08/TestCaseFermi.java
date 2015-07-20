package week08;

import java.util.ArrayList;
import java.util.Random;

import test.AbstractTestCase;


/**
 * Tests the Fermi game implementation
 *
 * @author slachanc
 *
 */
public class TestCaseFermi extends AbstractTestCase
{
	/**
	 * Constructor
	 */
	public TestCaseFermi()
	{
		super("TestCaseFermi");
	}

	@Override
	protected boolean runTest()
	{
		boolean result = false;

		trace("Testing base game");
		// Setup Fermi results
		setupFermi("Fermi", "Pico", "Nano");
		trace(" -- fermi setup");

		// Loop until we win or lose
		boolean gameResult = testGame();
		m_results += "Game result: " + gameResult;
		result = gameResult;

		trace("Testing complete");
		trace("");
		trace("Testing customr constructor game");

		// Change Fermi results
		setupFermi("do", "ra", "mi");
		gameResult = testGame();
		m_results += "\r\nGame result: " + gameResult;
		result = gameResult;

		trace("Testing InvalidArgumentException implementation");
		result = testException();

		return result;
	}

	@Override
	protected String results()
	{
		return m_results;
	}

	private boolean testException()
	{
		boolean result = false;

		FermiGame game = new FermiGame(m_fermi, m_pico, m_nano);
		game.newGame();

		// initialize bad guesses
		Guess[] guesses = new Guess[] {new Guess(0), new Guess(10), new Guess(100)};
		try
		{
			// passing in invalid guesses. Expect an exception
			String[] results = game.guess(guesses[0].getGuess(),
					guesses[1].getGuess(), guesses[2].getGuess());
		}
		catch(InvalidArgumentException ex)
		{
			result = true;
			trace(ex.getMessage());
		}

		return result;
	}

	private boolean testGame()
	{
		trace( "-- starting game test");
		boolean result = true;
		Guess[] guesses = generateRandomIntegers();
		boolean fDone = false;
		FermiGame game = new FermiGame(m_fermi, m_pico, m_nano);
		game.newGame();
		int tries = 0;
		try
		{
			while(!fDone)
			{
				trace("getting guesses - one");
				int one = guesses[0].getGuess();
				trace("getting guesses - two");
				int two = guesses[1].getGuess();
				trace("getting guesses - three");
				int three = guesses[2].getGuess();
				
				trace(String.format("Guesses %d, %d, %d", one, two, three));
				String[] results = game.guess(one, two, three);
				
				if(game.isWinner())
				{
					trace("Won game");
					fDone = true;
				}
				else
				{
					trace(String.format("Results: %s, %s, %s", results[0], results[1], results[2]));
					result = evaluateResponse(results, guesses);
				}

				tries++;
				if( tries > 10 )
				{
					fDone = true;
					trace("Forced termination");
				}
			}
		}
		catch(InvalidArgumentException ex)
		{
			trace(ex.getMessage());
			result = false;
		}
		finally
		{

		}

		trace( "-- completed game test " + tries);
		return result;
	}

	private void setupFermi(String a, String b, String c)
	{
		m_fermi = a;
		m_pico = b;
		m_nano = c;

		m_guesses = new Guess[9];

		for(int i = 0; i < m_guesses.length; i++)
		{
			m_guesses[i] = new Guess(i + 1); // make 1-based
		}

		for(int i = 0; i < 10; i++)
		{
			m_used[i] = false;
		}
	}

	/**
	 * This evaluates the existing guesses response. If a Fermi is found, the
	 * guesses array is updated. If a Pico is found, then the number is
	 * retained, but moved to a different guess spot (non-fermi) If a Nano is
	 * found, the the number is regenerated and assigned to a guess spot
	 * (non-fermi)
	 *
	 * @param response
	 *            String array of responses from the game
	 * @param guesses
	 *            int array of guesses provided
	 *
	 * @return true if all the guesses are right and in the right position.
	 */
	private boolean evaluateResponse(String[] response, Guess[] guesses)
	{
		boolean fOne = false, fTwo = false, fThree = false;


		// Evaluate Fermi status (right number, right position
		if(response[0].equals(m_fermi))
		{
			fOne = true;
			guesses[0].setResult(m_fermi);
		}

		if(response[1].equals(m_fermi))
		{
			fTwo = true;
			guesses[1].setResult(m_fermi);

		}

		if(response[2].equals(m_fermi))
		{
			fThree = true;
			guesses[2].setResult(m_fermi);

		}

		if(response[0].equals(m_pico))
		{
			guesses[0].setResult(m_pico);
		}

		if(response[1].equals(m_pico))
		{
			guesses[1].setResult(m_pico);
		}

		if(response[2].equals(m_pico))
		{
			guesses[2].setResult(m_pico);
		}

		if(response[0].equals(m_nano))
		{
			guesses[0].setResult(m_nano);
		}

		if(response[1].equals(m_nano))
		{
			guesses[1].setResult(m_nano);
		}

		if(response[2].equals(m_nano))
		{
			guesses[2].setResult(m_nano);
		}

		// now adjust the guesses
		// move a pico to different spot (but don't replace a fermi
		// and generate a new number for nano
		boolean fValid = updateGuesses(guesses);

		return fOne && fTwo && fThree && fValid;
	}

	private boolean updateGuesses(Guess[] guesses)
	{
		boolean fValid = true;
		ArrayList<Guess> picos = new ArrayList<Guess>();

		for(int i = 0; i < guesses.length; i++)
		{
			if(guesses[i].getResult().equals(m_fermi))
			{
				// do nothing
			}
			else if(guesses[i].getResult().equals(m_pico))
			{
				picos.add(guesses[i]);
			}
		}

		boolean fDone = false;

		for(Guess g : picos)
		{
			int curIndex = -1;
			for(int i = 0; i < guesses.length; i++)
			{
				if(g == guesses[i])
				{
					// same guess
					curIndex = i;
				}

				if(guesses[i].getResult().equals(m_fermi))
				{
					// don't replace a fermi
				}
				else if(guesses[i].getResult().equals(m_pico)
						&& g != guesses[i])
				{
					Guess temp = guesses[i];
					// guessesCopy[i] = g;
					guesses[i] = g;
					guesses[curIndex] = temp;
					fDone = true;
					break;
				}
				else if(guesses[i].getResult().equals(m_nano))
				{
					// replace the m_nano
					Guess temp = guesses[i];
					for(int j = 0; j < guesses.length; j++)
					{
						if( g == guesses[j])
						{
							guesses[j] = temp;
						}
					}

					guesses[i] = g;

					fDone = true;
					break;
				}
			}

			if(fDone)
			{
				break;
			}
		}

		// now process nano
		for(int i = 0; i < guesses.length; i++)
		{
			if(guesses[i].getResult().equals(m_nano))
			{
				guesses[i] = getGuess();
			}
		}

		if(guesses[0] == guesses[1] || guesses[0] == guesses[2] || guesses[1] == guesses[2] )
		{
			String fmt = String.format("%s %s %s", guesses[0], guesses[1], guesses[2]);
			trace("updateGuess failed due to duplicate values: " + fmt);
			fValid = false;
		}

		return fValid;
	}

	private Guess getGuess()
	{
		Guess guess = null;
		for(int i = 0; i < m_guesses.length; i++)// Guess g : m_guesses)
		{
			Guess g = m_guesses[i];
			if(g != null)
			{
				guess = g;
				m_guesses[i] = null;
				break;
			}
		}

		trace("returning guess - " + guess);
		return guess;
	}


	/**
	 * Random integers, must all be unique
	 */
	private Guess[] generateRandomIntegers()
	{
		int rand1;
		int rand2;
		int rand3;
		do
		{
			Random m_Random = new Random();
			rand1 = m_Random.nextInt(9);
			rand2 = m_Random.nextInt(9);
			rand3 = m_Random.nextInt(9);

		}
		while(rand1 == rand2 || rand1 == rand3 || rand2 == rand3);
// Test code for debugging. Enable as needed.
//		rand1 = 5;
//		rand2 = 6;
//		rand3 = 7;
		// m_random = new int[] { rand1, rand2, rand3 };

		// Used for testing to help validate processing
		// System.out.println(String.format("-- %d %d %d", rand1, rand2,
		// rand3));
		Guess[] guess = new Guess[] { m_guesses[rand1], m_guesses[rand2],
				m_guesses[rand3] };

		// null the used ones
		m_guesses[rand1] = null;
		m_guesses[rand2] = null;
		m_guesses[rand3] = null;

		return guess;
	}

	private String m_results = "";

	private String m_fermi = "Fermi";
	private String m_pico = "Pico";
	private String m_nano = "Nano";

	private Guess[] m_guesses;
	private boolean m_used[] = new boolean[] { false, false, false, false,
			false, false, false, false, false, false };

}

class Guess
{
	// This is a 1-based value
	public Guess(int val)
	{
		this(val, "Nano");
	}

	public Guess(int val, String state)
	{
		m_value = val;
		m_result = state;

	}

	public void setResult(String result)
	{
		m_result = result;
	}

	public int getGuess()
	{
		return m_value;
	}

	public String getResult()
	{
		return m_result;
	}

	private String m_result = "Nano";
	private int m_value;
}
