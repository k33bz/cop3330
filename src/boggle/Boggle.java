package boggle;

import java.util.ArrayList;
import inputOutput.ReadDataFile;
import core.Board;
public class Boggle
{
	public static void main(String[] args)
	{
		/*
		 * 1.	Create an instance of class ReadDataFile passing the file name variable as an argument 
		 * 2.	Call method populateData() from class ReadDataFile
		 * 3.	Set member variable of type ArrayList equal to method call getData() from class ReadDataFile
		 * 4.	Create an instance of class Board passing the file data in the ArrayList as an argument
		 * 5.	Call method shakeDice() from class Board
		 */
		ArrayList<String> boggleData = new ArrayList<String>();
		String file;
		
		if(args.length == 0) {
			file = "src\\inputOutput\\BoggleData.txt";
		} else {
			file = args[0].toString();
		}
		ReadDataFile boggleDataFile = new ReadDataFile(file);
		
		boggleDataFile.populateData();
		
		boggleData = boggleDataFile.getData();
		
		Board myBoard = new Board(boggleData);
		
		myBoard.shakeDice();
	}
}
