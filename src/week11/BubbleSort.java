package week11;

public class BubbleSort extends AbstractSort
{

	public BubbleSort(int[] list)
	{
		super("BubbleSort", list);
		
	}

	@Override
	public void sort()
	{
		int temp;
		int bottom = m_list.length - 1;

		boolean exchanged = true;
		
		while(exchanged) {
			exchanged = false;
			
			for(int i = 0; i < bottom; i++) {
				if(m_list[i] > m_list[i+1]) {
					temp = m_list[i];
					m_list[i] = m_list[i+1];
					m_list[i+1] = temp;
					
					exchanged = true;
				}
			}
			
			bottom--;
			
		}
		
	}

}
