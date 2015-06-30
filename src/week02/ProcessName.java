package week02;

/**
 *
 * @author matthew kastro 
 * 
 */

public class ProcessName
{
	private String m_firstName;
	private String m_middleName;
	private String m_lastName;

	/**
	 * 
	 * @param firstName first name of the person
	 * @param middleName middle name of the person
	 * @param lastName last name of the person
	 */
	public ProcessName(String firstName, String middleName, String lastName)
	{

		m_firstName		=	firstName;
		m_middleName	=	middleName;
		m_lastName		=	lastName;
	}

	public String getFirstInitialLast()
	{
		return String.format("%s %s. %s", m_firstName, m_middleName.substring(0, 1), m_lastName);
		//return m_firstName + " " + m_middleName.substring(0, 1) + ". " + m_lastName;
	}

	public String getDisplayName()
	{
		return m_lastName + ", " + m_firstName;
	}

}
