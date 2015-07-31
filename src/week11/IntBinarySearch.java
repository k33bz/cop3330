package week11;

public class IntBinarySearch extends AbstractSearch
{
	@Override
	public RESULT search(int[] array, int searchValue) {
		
		return binarySearch(array, searchValue);
	}
	
	private RESULT binarySearch(int[] array, int searchValue) {
		
		RESULT result = RESULT.FOUND;
		
		int low = 0;
		int high = array.length - 1;
		int mid = (low + high) / 2;
		
		while(low <= high && array[mid] != searchValue) {
			if(array[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
			
			if(low > high) {
				result = result.NOT_FOUND;
			}
			
			m_foundItemIndex = mid;
			return result;
			
		}
		
		return result;
		
	}

}
