package week02;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * @author matthew kastro
 *
 */
public class StringExclamation
{
	public ArrayList<String> splitByExclamation(String stringTest)
	{
		return new ArrayList<String>(Arrays.asList((stringTest.split("\\s*!\\s*"))));
	}

}
