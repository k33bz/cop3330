package week02;

public class SampleConstructorTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		SampleConstructorParameters scp = new SampleConstructorParameters("First", "middle", "last");
		
		System.out.println(scp.formatName());
		System.out.println(scp.formatName2());
		
		SampleConstructorParameters scp2 = new SampleConstructorParameters("Scott", "Kevin", "LaChance");
		
		System.out.println(scp2.formatName());
		System.out.println(scp2.formatName2());

		
		SampleConstructorParameters scp3 = new SampleConstructorParameters("Jim", "Tiberius", "Kirk");
		
		System.out.println(scp3.formatName());
		System.out.println(scp3.formatName2());
	}

}
