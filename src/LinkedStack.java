

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * The linked stack provides the stack used for
 * the discs.
 * @author abey95
 * @version 2016.10.16
 * 
 * @param <T>
 *            the data type of the linked stack
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode;
    private int size;

    /**
     * creates a new LinkedStack object that initializes
     * the topNode and size variables
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }

    /**
     * @return the size of the stack
     */
    public int size()
    {
        return size;
    }

    /**
     * clears the entire stack
     */
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
    }

    /**
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a string representation of this stack. A stack's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty stack is simply [].
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> p = topNode;
        while (p != null)
        {
            if (s.length() > 1)
            {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }

    /**
     * Returns the top entry in the stack without altering
     * the stack
     * @return top entry in the stack
     */
    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        } 
        else
        {
            return topNode.getData();
        }
    }

    /**
     * Returns the top entry in the stack and removes
     * it from the stack
     * @return the top entry in the stack
     */
    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        } 
        else
        {
            T top = peek();
            assert topNode != null;
            topNode = topNode.getNextNode();

            size--;
            return top;
        }

    }

    /**
     * pushes a new entry onto the top of the stack
     * 
     * @param anEntry
     *            the entry to be added
     */
    @Override
    public void push(T anEntry)
    {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;
    }

    /**
     * Node class used in implementation of linkedStack
     */
    private class Node<T>
    {
        private T data;
        private Node<T> next;

        /**
         * default constructor for Node class
         * 
         * @param dataPortion
         *            data for node
         */
        Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        /**
         *
         * second constructor with nextNode parameter
         * 
         * @param dataPortion
         *            data for node
         * @param nextNode
         *            nextNode in chain
         */
        Node(T dataPortion, Node<T> nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * @return the next node in the chain
         */
        Node<T> getNextNode()
        {
            return next;
        }

        /**
         * @return the data for the current node
         */
        T getData()
        {
            return data;
        }

        /**
         * sets the next node in the chain
         */
        void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }

    }

}
