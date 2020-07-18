import java.util.NoSuchElementException;

/**
 * Your implementation of a linked deque.
 *
 * @author Xiying Huang
 * @userid xhuang309
 * @GTID 903089975
 * @version 1.0
 */
public class LinkedDeque<T> {
    // Do not add new instance variables.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    /**
     * Adds the data to the front of the deque.
     *
     * This method must run in O(1) time.
     *
     * @param data the data to add to the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addFirst(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is empty.");
        }
        LinkedNode<T> niu = new LinkedNode<>(data);
        if(size == 0) {
            //LIST EMPTY
            head = niu;
            tail = niu;
            size++;
        } else {
            //LIST NOT EMPTY
            head.setPrevious(niu);
            niu.setNext(head);
            head = niu;
            size++;
        }
    }

    /**
     * Adds the data to the back of the deque.
     *
     * This method must run in O(1) time.
     *
     * @param data the data to add to the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addLast(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is empty.");
        }

        LinkedNode<T> niu = new LinkedNode<>(data);
        if(size == 0) {
            //LIST EMPTY
            head = niu;
            tail = niu;
            size++;
        } else {
            tail.setNext(niu);
            niu.setPrevious(tail);
            tail = niu;
            size++;
        }
    }

    /**
     * Removes the data at the front of the deque.
     *
     * This method must run in O(1) time.
     *
     * @return the data formerly at the front of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Deque "
                    + "is empty, nothing to remove.");
        }
        LinkedNode<T> temp = head;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            head = head.getNext();
            head.setPrevious(null);
            size--;
        }
        return temp.getData();
    }

    /**
     * Removes the data at the back of the deque.
     *
     * This method must run in O(1) time.
     *
     * @return the data formerly at the back of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Deque "
                    + "is empty, nothing to remove.");
        }
        LinkedNode<T> temp = tail;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
        }
        return temp.getData();
    }

    /**
     * Returns the number of elements in the list.
     *
     * Runs in O(1) for all cases.
     * 
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY!
        return size;
    }

    /**
     * Returns the head node of the linked deque.
     * Normally, you would not do this, but it's necessary for testing purposes.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return node at the head of the linked deque
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the tail node of the linked deque.
     * Normally, you would not do this, but it's necessary for testing purposes.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return node at the tail of the linked deque
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}