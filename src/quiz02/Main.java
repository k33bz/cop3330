package quiz02;

public class Main
{
	public static enum OperatingSystem {WIN7, Win_XP, OSX, LINUX, UNIX}
	public static void main(String[] args)
	{
		System.out.println(getValue()); //1
		
		if (15 < 8) //false
			System.out.println("One"); //this line is only used for the if statement since { } is missing
			System.out.println("Two");
			System.out.println("Three");
		System.out.println("Four");
		/* Expected output:
		 * Two
		 * Three
		 * Four
		 */
		
		OperatingSystem myOS = OperatingSystem.WIN7;
		System.out.println(myOS); //WIN7

	}
	
	//getValue
	public static String getValue()
	{
		   int value = 1;
		      switch(value)
		      {
		    	  case 0: return "0";
		    	  case 1: return "1";
		    	  case 2: return "2";
		      }
		      
		         return "3";
	}
	//endgetvalue
	
}
