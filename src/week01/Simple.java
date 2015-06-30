/**
 * My new class to demonstrate a very basic java app
 */
package week01;

/**
 * @author scottl
 *
 */
public class Simple
{
	/**
	 * c:>java -cp . week01.Simple "my argument" my other argument
	 * @param args
	 */
	public static void main(String[] args)
	{		
		Simple mySimple = new Simple();
		System.out.println(mySimple.displayName());
	}
	
	public String displayName()
	{
		return "My name is Scott";
	}

}
