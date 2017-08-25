import java.util.*;

/**
 * Created by AlinaCh on 03.02.2017.
 */
public class LinkedStack <E> {

    private int capacity;
    private Cursor head;

    private class Cursor {
        private E item;
        private Cursor next;
    }

    public LinkedStack() {
        capacity = 0;
        head = new Cursor();
    }

    public void push(E element) {
        Cursor oldhead = head;
        head = new Cursor();
        head.item = element;
        head.next = oldhead;
        capacity++;
    }

    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack overflow");
        Cursor first = head;
        head = new Cursor();
        head = first.next;
        capacity--;
        return first.item;
    }

    public E peek() {
        return head.item;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public static void main(String[] args) {

    }
}
