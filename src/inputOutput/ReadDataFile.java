package inputOutput;

import java.io.*;
import java.util.ArrayList;

/*
 * Define class member variables using the specified data types:
1.	Scanner // for reading the file 
2.	String  // for storing the file name
3.	ArrayList  // for storing the data from the file
Create constructor with one parameter of type String representing the name of the data file
1.	Set local variable of type String to the value passed in
Create method populateData with return type void and an empty parameter list; it should do the following:
1.	Create an instance of class URL using the file name of the data file
2.	Create an instance of class File using the URL created above
3.	Initialize member variable of type Scanner based on the File instance created above
4.	Loop through the data file until the end
a.	Add to the ArrayList representing the data in the file each value read from the data file
Create method getData with return type ArrayList and an empty parameter list that returns the ArrayList with the data from the data file

 */

public class ReadDataFile
{
	private String fileName;
	private ArrayList<String> arrBoardData = new ArrayList<String>();
	
	public ReadDataFile(String file)
	{
		fileName = file;
		
	}
	
	public void populateData()
	{
		String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                arrBoardData.add(line);
            }    
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
             //ex.printStackTrace();

        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                   
            //ex.printStackTrace();
        }
	}

	public ArrayList<String> getData()
	{
		return arrBoardData;
	}
}
