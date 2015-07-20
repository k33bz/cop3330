package boggle;

import core.Board;
import inputOutput.ReadDataFile;
import userInterface.BoggleUI;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Boggle 
{
    // Array list to store data value of each die
    private static ArrayList boggleData = new ArrayList();
    
    // name of the data file
    private static String dataFileName = new String("BoggleData.txt");
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // read in the data file
        ReadDataFile data = new ReadDataFile(dataFileName);
        data.populateData();

        // create instance of Board passing the boggleData
        Board board = new Board(data.getData());
        
        dataFileName = "TemporaryDictionary.txt";
        data = new ReadDataFile(dataFileName);
        data.populateData();
        ArrayList<String> dictData = new ArrayList<String>();
        dictData = data.getData();
        /*for (String temp : dictData) {
			System.out.println(temp);
		}*/

        // create instance of BoggleUi passing board as an arguement 
        //BoggleUI boggleUI = new BoggleUI(board);
        BoggleUI boggle2 = new BoggleUI(board,dictData);
    }
    
}