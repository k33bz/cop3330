package week04;

import java.util.Random;

public class DieVer2
{
	final int MAX_NUMBER = 6;
	final int MIN_NUMBER = 1;
	int number;
	Random random = new Random();

	public DieVer2() {
		roll();
	}
	
	public int getNumber() {
		return number;
	}
	
	private void roll() {
		number = Math.abs((random.nextInt() % MAX_NUMBER) + MIN_NUMBER);
	}
}
