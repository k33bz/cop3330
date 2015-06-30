package week04;

import java.util.Random;

public class ManySidedDie
{
	final int MIN_NUMBER = 1;
	final int NO_NUMBER = 0;
	int maxNumber = 6;
	int number;
	Random random = new Random();
	
	public ManySidedDie()
	{
		roll();
	}
	
	public ManySidedDie(int i) {
		maxNumber = i;
	}
	
	public ManySidedDie(int i, boolean b)
	{
		maxNumber = i;
		if(b) {
			roll();
		}
	}

	public int getNumber()
	{
		return number;
	}

	public void roll()
	{
		do {
			number = Math.abs((random.nextInt() % maxNumber) + MIN_NUMBER);
		} while(number == NO_NUMBER);
	}

}
