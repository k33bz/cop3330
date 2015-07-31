package week10;

import java.util.ArrayList;
import java.util.List;

public class CollectionAssignment
{

	public double calculateSum(double[] data)
	{
		double sum = 0.0;
		
		for(double d : data) {
			sum += d;
		}
		
		return sum;
	}

	public int calculateProduct(int[] data)
	{
		int product = 1;
		
		for(int i : data) {
			product *= i;
		}
		
		return product;
	}

	public Integer calculateIntegerSum(List<Integer> data)
	{
		Integer sum = 0;
		
		for(Integer i : data) {
			sum += i;
		}
		
		return sum;
	}

	public void setPersonAge(List<Person> people, int age)
	{
		for(Person p : people) {
			p.setAge(age);
		}
		
	}

	public ArrayList<Person> copyArrayToList(Person[] persons)
	{
		ArrayList<Person> people = new ArrayList<Person>();
		
		for(Person p : persons) {
			people.add(p);
		}
		
		return people;
	}

}
