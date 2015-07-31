package week10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CollectionExample
{
	public static void main(String[] args)
	{
		trace("Collection Example!\n");
		
		demoPrimitiveArray();
		trace("---------");
		
		demoClassArray();
		trace("---------");
		
		demoHashSet();
		trace("---------");
		
		// Passing arrays as parameters
		double[] doubleArray = new double[]{1.1,2.3,4.3,4.5,6.5};
		Person[] persons = new Person[] { new Person("Mickey"), new Person("Donald"), new Person("Daisy")};
		demoParameterPassing(doubleArray, persons);
		trace("---------");
		
		demo2dArray();
	}
	
	public static void demoPrimitiveArray()
	{
		trace("demoPrimitiveArray");
		double[] doubleArray = new double[]{1.1, 2.3, 4.3, 4.5, 6.5};
		double sum = 0.0;
		
		for(double d : doubleArray)
		{
			sum += d;		
		}
		
		trace("Array size: " + doubleArray.length);
		trace("Sum: " + sum);
	}

	public static void demoClassArray()
	{
		trace("demoClassArray");
		Person[] persons = new Person[] { new Person("Mickey"), new Person("Donald"), new Person("Daisy")};
		Person[] persons2 = { new Person("Mickey1"), new Person("Donald1"), new Person("Daisy1")};
		trace("Array size: " + persons.length);
		trace("Array size: " + persons2.length);
		
		for(Person p : persons)
		{
			trace(p.getName());	
		}
		
		for(Person p : persons2)
		{
			trace(p.getName());	
		}
	}
	
	public static void demoHashSet()
	{
		trace("demoHashSet");
		int size;
		HashSet<String> collection = new HashSet<String>();
		String str1 = "Yellow";
		String str2 = "White";
		String str3 = "Green";
		String str4 = "Blue";
		
		Iterator<String> iterator;
		collection.add(str1);
		collection.add(str2);
		collection.add(str3);
		collection.add(str4);
		trace("Collection data: ");
		
		iterator = collection.iterator();
		while(iterator.hasNext())
		{
			trace(iterator.next() + " ");
		}
		System.out.println();
		size = collection.size();
		if(collection.isEmpty())
		{
			trace("Collection is empty");
		}
		else
		{
			trace("Collection size: " + size);
		}
		
		System.out.println();
	}
	
	public static void demoParameterPassing(double[] doubleList, Person[] personList)
	{
		trace("demoParameterPassing");
		double[] doubleArray = doubleList;
		double sum = 0.0;
		
		for(double d : doubleArray)
		{
			sum += d;		
		}
		
		trace("Sum: " + sum);
		
		Person[] persons = personList;
		trace("Array size: " + persons.length);
		for(Person p : persons)
		{
			trace(p.getName());	
		}		
	}
	
	public static void demo2dArray()
	{
		double[][] payScaleTable = new double[4][5];
		
		Random rand = new Random();
		
		// Initialize the array
		for(int i = 0; i < payScaleTable.length; i++)
		{
			for(int j = 0; j < payScaleTable[i].length; j++)
			{
				payScaleTable[i][j] = rand.nextInt(100);
			}
		}

		// dump the contents of the array

		for(int i = 0; i < payScaleTable.length; i++)
		{
			for(int j = 0; j < payScaleTable[i].length; j++)
			{
				trace(Double.toString(payScaleTable[i][j]));
			}
		}
	}
	
	private static void trace(String msg)
	{
		System.out.println(msg);
	}

}


