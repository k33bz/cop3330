package week08;

import java.util.Scanner;

public class CmdLine
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		run();
	}

	private static void run()
	{
		FermiGame game;
		m_scanner = new Scanner(System.in);
		m_scanner.useDelimiter("\r\n");
		boolean fDone = false;
		try
		{
			game = new FermiGame();
			game.newGame();
			
			while(!fDone)
			{
				trace("Enter 3 guesses between 1 and 9 inclusive");
				int[] guesses = nextGuess();
				if(guesses[0] < 0)
				{
					fDone = true;
				}
				else
				{
					String[] results = game.guess(guesses[0], guesses[1],
							guesses[2]);
					String output = "";
					for(int i = 0; i < results.length; i++)
					{
						output += results[i] + " ";
					}

					trace(output);
					
					if(game.isWinner())
					{
						fDone = true;
						trace("Winner!");
					}
				}
			}
		}
		catch(Exception ex)
		{
			trace("Error: " + ex.getMessage());
		}
	}

	private static int[] nextGuess()
	{
		String input = m_scanner.next();
		String[] data = input.split(" ");
		int[] guesses = new int[3];

		guesses[0] = Integer.parseInt(data[0]);
		guesses[1] = Integer.parseInt(data[1]);
		guesses[2] = Integer.parseInt(data[2]);

		return guesses;
	}

	private static void trace(String msg)
	{
		System.out.println(msg);
	}

	private static Scanner m_scanner;
}
