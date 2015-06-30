package week02;


public class SampleConstructorParameters
{

	/**
	 * 
	 * @param first
	 * @param middle
	 * @param last
	 */
	public SampleConstructorParameters(String first, String middle, String last)
	{
		m_first = first;
		m_middle = middle; 
		m_last = last;
	}
	
	public String formatName()
	{
		return "Mr. " + m_first + " " + m_middle + " " + m_last;
	}
	
	public String formatName2()
	{
		return "Mr. " + m_middle + " " + m_first + " " + m_last;
	}
	
	
	public String mergeNames(String one, String two)
	{
		String merged = one + " " + two;
		return merged;
	}
	
	
	private String m_first;
	private String m_middle;
	private String m_last;
}
