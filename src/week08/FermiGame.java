package week08;

import java.util.Random;

public class FermiGame
{
	private static String FERMI = "Fermi";
	private static String PICO = "Pico";
	private static String NANO = "Nano";
	
	private static int MIN = 0;
	private static int MAX = 10;
	
	private String m_fermi = FERMI;
	private String m_pico = PICO;
	private String m_nano = NANO;
	
	private boolean m_wonGame = false;
	
	private int[] m_random;
	
	public FermiGame() {
		//default constructor
		this(FERMI,PICO,NANO);
	}

	public FermiGame(String fermi, String pico, String nano)
	{
		validateParamaters(fermi,pico,nano);
	}

	private void validateParamaters(String fermi, String pico, String nano)
	{
		m_fermi = fermi != null ? fermi : FERMI;
		m_pico = pico != null ? pico : PICO;
		m_nano = nano != null ? nano : NANO;
		
		//pico must be unique
		if(m_fermi == m_pico)
		{
			m_pico = PICO;
		}
		
		//nano must be unique
		if(m_fermi == m_nano || m_pico == m_nano)
		{
			m_nano = NANO;
		}
	}

	public void newGame()
	{
		m_wonGame = false;
		generateRandomIntegers();
		
	}

	private void generateRandomIntegers()
	{
		int rand1, rand2, rand3;
		do {
				Random m_Random = new Random();
				rand1 = m_Random.nextInt(9) + 1;
				rand2 = m_Random.nextInt(9) + 1;
				rand3 = m_Random.nextInt(9) + 1;
		} while(rand1 == rand2 || rand1 == rand3 || rand2 == rand3);
		
		m_random = new int[]{rand1,rand2,rand3};
	}

	public String[] guess(int i, int j, int k) throws InvalidArgumentException {
			
		String result[] = null;
		
		if(validateGuess(i,j,k)) {
			String response1 = testMatch(i,0);
			String response2 = testMatch(j,1);
			String response3 = testMatch(k,2);
			
			if(response1.endsWith(m_fermi) && response2.endsWith(m_fermi) && response3.endsWith(m_fermi)) {
				m_wonGame = true;
			}
			
			result = new String[]{response1,response2,response3};
		}
	
		return result;
	}

	private String testMatch(int guess, int index)
	{
		String response = m_nano;
		
		if(guess == m_random[index]) {
			response = m_fermi;
		} else {
			for(int i = 0; i < m_random.length;i++) {
				if(guess == m_random[i] && i != index) {
					response = m_pico;
					break;
				}
			}
		}
		
		
		return response;
	}

	private boolean validateGuess(int one, int two, int three) throws InvalidArgumentException
	{
		boolean result1 = true;
		boolean result2 = true;
		boolean result3 = true;
				
		String msg = "";
		
		if(!(MIN < one && one < MAX)) {
			result1 = false;
			msg = String.format("Pos %d, Value: %d", 1,one);
		}
		
		if(!(MIN < two && two < MAX)) {
			result2 = false;
			msg = String.format("Pos %d, Value: %d", 2,two);
		}
		
		if(!(MIN < three && three < MAX)) {
			result3 = false;
			msg = String.format("Pos %d, Value: %d", 3,three);
		}
		
		if(!(result1 && result2 && result3)) {
			throw new InvalidArgumentException("Invalid Guess: " + msg);
		}
		
		return true;
	}

	public boolean isWinner()
	{
		return m_wonGame;
	}

}
