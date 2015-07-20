/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inputOutput;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class ReadDataFile 
{
    Scanner inputFile;
    String dataFileName;
    ArrayList data = new ArrayList();
    
    public ReadDataFile(String fileName)
    {
        dataFileName = fileName; 
    }
    
    public void populateData()
    {
        try
        {
            //URL url = getClass().getResource("BoggleData.txt");
            URL url = getClass().getResource(dataFileName);
            File file = new File(url.toURI());

            inputFile = new Scanner(file);
            
            while(inputFile.hasNext())
            {
                data.add(inputFile.next());
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        finally
        {
            inputFile.close();
        }
    }    
    
    public ArrayList getData()
    {
        return data;
    }
}