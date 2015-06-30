package core;

import java.util.ArrayList;
import java.util.Collections;

public class Board
{
	
	final private int NUMBER_OF_DICE = 16;
	//final private int NUMBER_OF_SIDES = 6;
	private int grid = 4;
	private ArrayList<String> arrBoard = new ArrayList<String>();
	private ArrayList<Die> dice = new ArrayList<Die>();

	public Board(ArrayList<String> boggleData)
	{
		/*
		 * Create constructor with one parameter of type ArrayList;
		 * set the member variable of type ArrayList that stores all
		 * the Boggle data equal to the parameter in the method signature
		 */
		arrBoard = boggleData;
	}
	
	private void populateDice() {
		//TODO: See below
		/*
		 * Create method populateDice with return type void and an empty parameter list; the method should do the following:
		1.	 Declare an variable of type class Die
		2.	Loop through the 16 dice:
			a.	Create an instance of class Die using the no-argument constructor
			b.	Loop through the 6 sides of the die:
				i.	Add each of the 6 letters to the die ArrayList representing the die letters by calling method addLetter in class Die 
			c.	Display the letters of each die by calling method displayAllLetters() in class Die on a separate row
		3.	Add each die instance to the ArrayList declared specifically for class Die
		 */
		
		for(int i = 0; i < NUMBER_OF_DICE; i++) {
			dice.add(new Die());
			String[] letters = arrBoard.get(i).split(" ");
			for(int j = 0; j < letters.length; j++) {
			dice.get(i).addLetter(letters[j]);
			}
		}
	}
	
	public ArrayList<Die> shakeDice() {
		
		//TODO: See Below
		/*
		 * Create method shakeDice with return type ArrayList and an empty parameter list; the method should do the following:
		1.	Loop through the 16 dice, for each Die:
			a.	Call method getLetter in class Die
			b.	Display the current letter of each Die in a 4 X 4 grid
			c.	Return the ArrayList of Boggle dice with each letter set
		 */
		
		populateDice();
		
		//for (int i = 0; i < dice.size(); i++) {
		//	dice.get(i).getLetter();
			
		//}
		
		for(int i = 0; i < dice.size(); i++) {
			if(i < 10) {
				System.out.print("dice  " + i + ": ");
			} else {
				System.out.print("dice " + i + ": ");
			}
			dice.get(i).displayAllLetters();
			System.out.print("\n");
		}
		
		
		//draw grid
		int counter;
				
		counter = 0;
		System.out.println("\nBoggle Board:");
		for(int cur_row = 0;cur_row < grid; cur_row++){
			for(int cur_col = 0; cur_col < grid; cur_col++) {
				System.out.print(dice.get(counter).getLetter() + " ");
				counter++;
			}
			System.out.print("\n");
		}
		
		//this should randomize out the letters instead of putting each dice in
		//the same square
		//i would do that by storing each dice.getLetter into an ArrayList<String> allDiceRolled
		//and then Collection.shuffle(allDiceRolled)
		
		/*
		ArrayList<String> allDiceRolled = new ArrayList<String>();
		for(int i=0;i<dice.size();i++) {
			allDiceRolled.add(dice.get(i).getLetter());
		}
		Collections.shuffle(allDiceRolled);
		counter = 0;
		System.out.println("\nRandom Boggle Board:");
		for(int cur_row = 0;cur_row < grid; cur_row++){
			for(int cur_col = 0; cur_col < grid; cur_col++) {
				System.out.print(allDiceRolled.get(counter) + " ");
				counter++;
			}
			System.out.print("\n");
		}
		*/
		
		return dice;
	}
}
