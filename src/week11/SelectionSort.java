package week11;

public class SelectionSort extends AbstractSort
{

	public SelectionSort(int[] list)
	{
		super("SelectionSort", list); // m_list = list;
	}

	@Override
	public void sort()
	{
		int minIndex;
		int length = m_list.length;
		int temp;
		int i;
		
		for(int startIndex = 0; startIndex <= length - 2; startIndex++) { //comparisons, skip very last element since it is being compared
			
			minIndex = startIndex;
			
			for(i = startIndex + 1; i < length; i++) {
				if(m_list[i] < m_list[minIndex]) {
					minIndex = i;
				}
			}
			
			//swap elements
			temp = m_list[startIndex];
			m_list[startIndex] = m_list[minIndex];
			m_list[minIndex] = temp;
		}
	}
	
}
