import queue.EmptyQueueException;

/**
 * The ArrayQueue class creates a circular implementation
 * of an ArrayQueue.
 * 
 * @author Abey Yoseph abey95
 * @version 2016.10.31
 * @param <T>
 *            the data type used
 */
public class ArrayQueue<T>
{
    private T[] queue;
    private int enqueueIndex; // back index
    private int dequeueIndex; // front index
    private int size;


    /**
     * creates a new ArrayQueue object and initializes the
     * necessary fields
     * 
     */
    public ArrayQueue(int maxSize)
    {
        T[] tempQueue = (T[]) new Object[maxSize+1];
        queue = tempQueue;
        dequeueIndex = 0;
        enqueueIndex = maxSize;
        size = 0;
    }

    /**
     * @return the length of the ArrayQueue
     */
    public int getLength()
    {
        return queue.length;
    }

    /**
     * @return the current size of the array queue
     */
    public int getSize()
    {
        return size;
    }
    /**
     * Removes the front entry in the ArrayQueue
     * 
     * @return the front entry
     * @throws EmptyQueueException
     *             if ArrayQueue is empty
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        } 
        else
        {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = incrementIndex(dequeueIndex);
            size--;
            return front;
        }
    }

    /**
     * Adds an entry to the back of the queue
     * @param newEntry the entry to be added
     */
    public void enqueue(T newEntry)
    {
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = newEntry;
        size++;
    }

    /**
     * Retrieves the front entry of the queue
     * 
     * @return the front entry
     * @throws EmptyQueueException
     *             if ArrayQueue is empty
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        } 
        else
        {
            return queue[dequeueIndex];
        }
    }
    /**
     * Retrieves the back entry of the queue
     * 
     * @return the back entry
     * @throws EmptyQueueException
     *             if ArrayQueue is empty
     */
    public T getBack()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        } 
        else
        {
            return queue[enqueueIndex];
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
     * Increment the index
     * @param index the index to be increased 
     * @return the new increased index
     */
    private int incrementIndex(int index) 
    {
        return ((index + 1) % queue.length);
    }

}
