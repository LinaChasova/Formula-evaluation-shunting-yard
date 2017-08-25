import java.util.*;

/**
 * Created by AlinaCh on 30.01.2017.
 */
public class LinkedQueue <Item> {

    private int capacity;
    private Cursor head;
    private Cursor tail;

    private class Cursor {
        private Item item;
        private Cursor next;
    }

    public LinkedQueue() {
        capacity = 0;
        head = new Cursor();
        tail = new Cursor();
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue overflow");
        return head.item;
    }

    public void enqueue(Item element) {
        if (isEmpty()) {
            head.item = element;
            tail.item = element;
        } else {
            Cursor first = head;
            head = new Cursor();
            head.item = element;
            head.next = first;
        }
        capacity++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue overflow");
        Item current = tail.item;
        if (capacity == 1) {
            head = new Cursor();
            tail = new Cursor();
        } else {
            Cursor search = new Cursor();
            search = head;
            int i = capacity;
            while (i != 2) {
                search = search.next;
                i--;
            }
            tail = new Cursor();
            search.next = null;
            tail = search;
        }
        capacity--;
        return current;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public static void main(String[] args) {

    }
}
