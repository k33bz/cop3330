package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import test.AbstractTestCase;

/**
 * Tests the Fermi game implementation
 * 
 * @author slachanc
 * 
 */
public class TestCaseCollection extends AbstractTestCase
{
	CollectionAssignment m_collection;

	/**
	 * Constructor
	 */
	public TestCaseCollection()
	{
		super("TestCaseCollection");
	}

	@Override
	protected boolean runTest()
	{
		m_results = "";
		m_collection = new CollectionAssignment();

		boolean test1 = testCalculateSum();
		boolean test2 = calculateProduct();
		boolean test3 = calculateIntegerSum();
		boolean test4 = setPersonAge();
		boolean test5 = copyArrayToList();

		return test1 && test2 && test3 && test4 && test5;
	}

	@Override
	protected String results()
	{
		return m_results;
	}

	private boolean testCalculateSum()
	{
		trace("Testing calculateSum");
		double[] doubleArray = new double[] { 1.1, 2.3, 4.3, 4.5, 6.5 };
		double expected = 0.0;
		for(double d : doubleArray)
		{
			expected += d;
		}

		double actual = m_collection.calculateSum(doubleArray);

		boolean result = expected == actual;
		if(!result)
		{
			trace("Failed - Expected: " + expected + ", actual: " + actual);
		}

		return result;
	}

	private boolean calculateProduct()
	{
		trace("Testing calculateProduct");
		int[] array = new int[] { 1, 1, 2, 3, 4, 3, 4, 5, 6, 5 };
		int expected = 1;
		for(int d : array)
		{
			expected *= d;
		}

		int actual = m_collection.calculateProduct(array);

		boolean result = expected == actual;
		if(!result)
		{
			trace("Failed - Expected: " + expected + ", actual: " + actual);
		}

		return result;
	}

	private boolean calculateIntegerSum()
	{
		trace("Testing calculateIntegerSum");
		Integer[] array = { 1, 1, 2, 3, 4, 3, 4, 5, 6, 5 };
		List<Integer> arrayList = new ArrayList<Integer>();
		for(Integer i : array)
		{
			arrayList.add(i);
		}

		Integer expected = 0;
		for(Integer d : arrayList)
		{
			expected += d;
		}

		Integer actual = m_collection.calculateIntegerSum(arrayList);

		boolean result = expected == actual;
		boolean result2 = expected.equals(actual);
		if(!result)
		{
			trace("Failed - Expected: " + expected + ", actual: " + actual);
		}
		
		if(!result2)
		{
			trace("Failed 2 - Expected: " + expected + ", actual: " + actual);
		}

		return result;
	}

	private boolean setPersonAge()
	{
		trace("Testing setPersonAge");
		boolean result = true;
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Dave"));
		persons.add(new Person("Todd"));
		persons.add(new Person("Barry"));
		persons.add(new Person("Jim"));
		persons.add(new Person("Gerald"));
		persons.add(new Person("Tim"));

		int expected = 45;
		m_collection.setPersonAge(persons, expected);

		for(Person p : persons)
		{
			int actual = p.getAge();
			if(expected != actual)
			{
				trace("Failed - expected: " + expected + ", actual: " + actual);
				result = false;
				break;
			}
		}

		return result;
	}

	private boolean copyArrayToList()
	{
		trace("Testing copyArrayToList");
		boolean result = true;
		Person[] persons = { new Person("Dave", 45), new Person("Todd", 47),
				new Person("Barry", 44), new Person("Jim", 50), new Person("Gerald", 42),
				new Person("Tim", 48) };

		ArrayList<Person> actual = m_collection.copyArrayToList(persons);

		if(persons.length == actual.size())
		{
			for(int i = 0; i < persons.length; i++)
			{
				Person p1 = persons[i];
				Person p2 = actual.get(i);
				if( !p1.equals(p2))
				{
					trace("Failed - Person. Expected: " + p1.getName() + ", " + p1.getAge() + ", actual: " + p2.getName() + ", " + p2.getAge());
					result = false;
					break;
				}
			}
		}
		else
		{
			trace("Failed - array size mismatch. Expected: " + persons.length + ", actual: " + actual.size());
			result = false;
		}
		
		return result;
	}

	private String m_results;
}