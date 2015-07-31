package week10;

/**
 * Represents a Person
 * Basic class to support week10 assignment
 * 
 * @author scottl
 *
 */
public 	class Person
{
	// Constructor
	public Person(String name)
	{
		// call the other constructor with a default age
		this(name, 0);
	}
	
	/**
	 * The main constructor
	 * 
	 * @param name Person name
	 * @param age Person age
	 */
	public Person(String name, int age)
	{
		m_name = name;
		m_age = age;
	}
	
	// Setters/Getters
	public String getName() {return m_name;}
	public int getAge() {return m_age;}
	public void setAge(int age) { m_age = age;}
	
	/**
	 * This overrides the Object.equals method so
	 * we can accurately determine whether the person object
	 * is equal at the data level (name and age).
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean equal = false;
		
		if( obj instanceof Person) // must be an instance of a Person object
		{
			Person p = (Person)obj; // cast to a person object
			
			// Use the Person methods to determine equality.
			// remebmer to use equals for strings
			boolean equalName = this.getName().equals(((Person)p).getName());
			boolean equalAge = this.getAge() == p.getAge();
			equal = equalName && equalAge;
		}
		
		return equal;
	}
	
	private String m_name;
	private int m_age;
}