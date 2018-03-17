/**
 * The min heap class
 * 
 * @author Abey Yoseph abey95
 * @version 2016.10.31
 * @param <T>
 *            the data type used
 */
public class ArrayMinHeap<T> 
{
    private double[] heap;
    private int maxSize;
    private int size;
    private int[] location;
    private int locationIndex;

    private final static int FRONT = 1;
    /**
     * creates a new ArrayQueue object and initializes the
     * necessary fields
     * 
     */
    public ArrayMinHeap(int maxSize)
    {
        size = 0;
        this.maxSize = maxSize;
        heap = new double[this.maxSize + 1];
        location = new int[maxSize+1];
        locationIndex = 1;
    }
    /**
     * @return the length of the ArrayQueue
     */
    public int getLength()
    {
        return heap.length;
    }

    /**
     * @return the current size of the array queue
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Adds an entry to the back of the queue
     * @param newEntry the entry to be added
     */
    public void insert(double newEntry)
    {
        heap[++size] = newEntry;
        int current = size;
        location[locationIndex++]= size;
 
        while (heap[current] < heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }   
    }   
    /**
     * 
     */
    public double remove()
    {
        double removed = heap[FRONT];
        heap[FRONT] = heap[size]; 
        location[1] = location[size];
        location[size] = 0;
        size--;
        
        minHeapify(FRONT);
        return removed;
    }
    /**
     * create a min heap
     */
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            minHeapify(pos);
        }
    }

    /**
     * @return true if the ArrayQueue has no entries
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /**
     * swap method
     */
    private void swap(int initialPos, int finalPos)
    {
        double temp = heap[initialPos];
        int node1 = location[initialPos];
        int node2 = location[finalPos];
        location[finalPos]= node1;
        location[initialPos] = node2;
        heap[initialPos] =  heap[finalPos];
        heap[finalPos] = temp;
        
    }
    /** 
     * min heapify
     */
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if (heap[pos] > heap[leftChild(pos)]  || heap[pos] > heap[rightChild(pos)])
            {
                if (heap[leftChild(pos)] < heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
     /**
      * decrease key method to decrease key at index with newVal
      */
     public void decreaseKey(int node, double newVal)
     {
         int counter = 0;
         while (location[counter]!= node) {
             counter++;
         }
         int index= counter;
         heap[index] = newVal;
         
         while (index != 0 && heap[parent(index)] > heap[index])
         {
            swap(index, parent(index));
            index = parent(index);
         }
         minHeapify(FRONT);

     }
     /**
      * 
      * @return node at front of location array
      */
     public int getLocation() 
     {
         return location[1];
     }
    /**
     * 
     * @param pos
     * @return
     */
    private int parent(int pos)
    {
        return pos / 2;
    }
    /**
     * 
     * @param pos
     * @return
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    /**
     * 
     * @param pos
     * @return
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    /**
     * 
     * @param pos
     * @return
     */
    private boolean isLeaf(int pos)
    {
        if (leftChild(pos) > size)
        { 
            return true;
        }
        return false;
    }
}
