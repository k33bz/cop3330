package core;

import java.util.ArrayList;
import java.util.Random;

public class Die
{
	final private int NUMBER_OF_SIDES = 6;
	private ArrayList<String> letter = new ArrayList<String>();
	private int indexLetter;
	
	public Die(){
		
	}
	
	private void randomLetter() {
		//1.	Declare an variable of type class Random
		Random random = new Random();
		//2.	Generate a random number based on the seed value of the number of die sides
		//random.setSeed((long)NUMBER_OF_SIDES);
		//3.	Set member variable representing the current letter to the data stored at the index of the random number
		indexLetter = random.nextInt(NUMBER_OF_SIDES);
		//System.out.println(String.format("random #: %d",indexLetter));

	}
	
	public String getLetter() {
		randomLetter();
		return letter.get(indexLetter);
	}
	
	public void addLetter(String l) {
		//1.	Add the passed in value to the ArrayList representing the letters on the die
		letter.add(l);
	}
	//Create method displayAllLetters with a return type of void and an empty parameter list; the method should:
	//1.	Loop through all sides of the die and display the data
	public void displayAllLetters() {
		for (String l : letter) {
			System.out.print(String.format(" %s",l));
		}
	}
}
