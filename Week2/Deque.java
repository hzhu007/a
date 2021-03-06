import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class Node
    {
        Item value = null;
        Node next  = null;
        Node last  = null;
    }
    private Node head, tail;
    private int size;

    public Deque()                           // construct an empty deque
    {
        head = tail = null;
        size = 0;
    }
    public boolean isEmpty()                 // is the deque empty?
    {
        return size == 0;
    }
    public int size()                        // return the number of items on the deque
    {
        return size;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node newNode = new Node();
        newNode.value = item;
        newNode.next = head;
        if (head != null) head.last = newNode; // if not empty, update original head
        head = newNode;                        // update head regardless empty or not
        if (tail == null) tail = newNode;      // if empty
        size++;
    }
    public void addLast(Item item)           // add the item to the end
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node newNode = new Node();
        newNode.value = item;
        newNode.last = tail;
        if (tail != null) tail.next = newNode; // if not empty, update orignal tail
        tail = newNode;                        // update tail regardless empty or not
        if (head == null) head = newNode;      // if empty
        size++;
    }
    public Item removeFirst()                // remove and return the item from the front
    {
        if (size == 0) throw new java.util.NoSuchElementException();
        Item removedValue = head.value;
        head = head.next;
        if (head != null) // not empty
            head.last = null;
        else              // empty
            tail = null;
        size--;
        return removedValue;
    }
    public Item removeLast()                 // remove and return the item from the end
    {
        if (size == 0) throw new java.util.NoSuchElementException();
        Item removedValue = tail.value;
        tail = tail.last;
        if (tail != null) // not empty
            tail.next = null;
        else              // empty
            head = null;
        size--;
        return removedValue;
    }
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = head;
        public boolean hasNext()
        {
            return current != null;
        }
        public Item next()
        {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item currValue = current.value;
            current = current.next;
            return currValue;
        }
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    public static void main(String[] args)   // unit testing
    { }
}
