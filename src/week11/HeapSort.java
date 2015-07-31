package week11;

/**
 * HeapSort uses a special data structure called a <i>heap</i>.
 * A heap is a type of tree with some specific characteristics defined.
 * The top most node is called the <i>root node</i> of a heap.
 * Nodes in a heap are indexed 0,1,2,3, and so on in the top-to-bottom, left-to-right order, starting from the root
 * 
 *           0
 *         /   \
 *        1     2
 *       / \   / \
 *      3   4 5   6
 *      
 * A node can have zero, one or two children.
 * The constraints a heap must satisfy are:
 * <ol>
 * <li>Structure constraint: Nodes in a heap must follow the index order. See page 647 in text for examples of non-heaps</li>
 * <li>Value relationship constraint: A value stored in a node MUST be larger than the max value of its left and right children.</li>
 * </ol>
 * 
 * HeapSort is implemented in two phases:
 * <ol>
 * <li>Construction phase: Construct a heap given N elements</li>
 * <li>Extraction phase: Pull out the value in the root successively, creating a new heap with one less element after each extraction loop</li>
 * </ol>
 * 
 * The construct algorithm:
 * The heap is implemented in an array that represents a heap (tree)
 * <ol>
 * <li>Loop through the heap starting at the heap length - 2</li>
 * <li>Set the current index to i and the done flag to false</li>
 *  <ol>
 *   <li>Loop until done</li>
 *   <li>See if the current node has children</li>
 *   <li>If it has children, get the larger child else set the done flag to true</li>
 *   <li>If the current node is smaller than the child, swap the nodes else set the done flag to true</li>
 *  </ol>
 * </ol>
 * 
 * The extract algorithm
 * The heap is implemented in an array that represents a heap (tree)
 * <ol>
 * <li>Create an array to receive the sorted items</li>
 * <li>Loop through the heap starting at the heap length - 2</li>
 * <li>Remove the root node</li>
 * <li>Move the last node to the root</li>
 * <li>Rebuild the heap</li>
 * <li>Next pass</li>
 * 
 * @author scottl
 *
 */
public class HeapSort extends AbstractSort
{
    /**
     * Constructor
     * 
     * @param list
     *            Array of ints
     */
    public HeapSort(int[] list)
    {
        super("HeapSort", list);
    }

    @Override
    public void sort()
    {
        heap = m_list;
        sortedList = new int[m_list.length];

        construct(); // construction phase: construct the heap

        extract(); // extraction phase: extract root nodes

        m_list = sortedList;
    }

    /**
     * Sets the internal array to the passed data.
     * 
     * @param data
     *            an int array to be sorted
     */
    public void setData(int[] data)
    {
        heap = new int[data.length];
        sortedList = new int[data.length];

        for(int i = 0; i < data.length; i++)
        {
            heap[i] = data[i];
            // System.out.println( heap[i] ); //TEMP
        }
    }

    /**
     * Performs the construction phase of the heapsort.
     */
    private void construct()
    {
        int current, maxChildIndex;
        boolean done;

        for(int i = (heap.length - 2) / 2; i >= 0; i--)
        {

            current = i;
            done = false;

            while(!done)
            {

                if(2 * current + 1 > heap.length - 1)
                {
                    // current node has no children, so stop
                    done = true;

                }
                else
                {
                    // current node has at least one child,
                    // get the index of larger child
                    maxChildIndex = maxChild(current, heap.length - 1);

                    if(heap[current] < heap[maxChildIndex])
                    {

                        swap(current, maxChildIndex);
                        current = maxChildIndex;

                    }
                    else
                    { // value relationship constraint
                      // is satisfied, so stop
                        done = true;
                    }
                }
            }

            assert isValidHeap(heap, i, heap.length - 1) : "Error: Construction phase is not working "
                    + "correctly";
        }

        // testPrint(heap.length); //TEMP
    }

    /**
     * Performs the extraction phase of the heapsort
     */
    private void extract()
    {
        int current, maxChildIndex;
        boolean done;

        for(int size = heap.length - 1; size >= 0; size--)
        {

            // remove the root node data
            sortedList[size] = heap[0];

            // move the last node to the root
            heap[0] = heap[size];

            // rebuild
            current = 0;
            done = false;

            while(!done)
            {

                if(2 * current + 1 > size)
                {
                    // current node has no children, so stop
                    done = true;
                }
                else
                {
                    // current node has at least one child, get the index of
                    // larger child
                    maxChildIndex = maxChild(current, size);

                    if(heap[current] < heap[maxChildIndex])
                    {

                        swap(current, maxChildIndex);
                        current = maxChildIndex;

                    }
                    else
                    { // value relationship constraint is satisfied, so stop
                        done = true;
                    }
                }
            }

            assert isValidHeap(heap, 0, size) : "Error: Extraction phase is not working correctly";

            // testPrint( size ); //TEMP
        }
    }

    /**
     * Finds the position of the larger child of a node at position 'location'.
     * 
     * @param location
     *            the position of a node
     * @param end
     *            the position of the last node in this heap
     * 
     * @return the position of a larger child
     */
    private int maxChild(int location, int end)
    {

        int result, leftChildIndex, rightChildIndex;

        rightChildIndex = 2 * location + 2;
        leftChildIndex = 2 * location + 1;

        // Precondition: node at 'location' has at least one child
        assert leftChildIndex <= end : "Error: node at position " + location
                + "has no children.";

        if(rightChildIndex <= end
                && heap[leftChildIndex] < heap[rightChildIndex])
        {

            result = rightChildIndex;

        }
        else
        {
            result = leftChildIndex;
        }

        return result;
    }

    /**
     * Swaps the values in positions loc1 and loc2
     * 
     * @param loc1
     *            the position of the first int
     * @param loc2
     *            the position of the second int
     */
    private void swap(int loc1, int loc2)
    {
        int temp;

        temp = heap[loc1];
        heap[loc1] = heap[loc2];
        heap[loc2] = temp;
    }

    /**
     * Verifies the valid heap.
     * 
     * @param heap
     *            the array containing the heap
     * @param start
     *            the first (root) position of this heap
     * @param end
     *            the last position of this heap
     * 
     * @return true if it is a valid heap; otherwise false
     */
    private boolean isValidHeap(int[] heap, int start, int end)
    {

        for(int i = start; i < end / 2; i++)
        {

            if(heap[i] < Math.max(heap[2 * i + 1], heap[2 * i + 2]))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Integer array for implementing a heap
     */
    private int[] heap;

    /**
     * Integer array for the sorted list
     */
    private int[] sortedList;
}
