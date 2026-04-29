package src.com.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(12);
        arrayDeque.add(14);
        arrayDeque.addLast(16);
        arrayDeque.addFirst(8);

        System.out.println("First Element "+arrayDeque.peekFirst());
        System.out.println("Last Element " + arrayDeque.peekLast());

        System.out.println("Removing First Element " + arrayDeque.pollFirst());
        System.out.println("Removing Last Element " + arrayDeque.pollLast());

        if (arrayDeque.remove(12)){
            arrayDeque.addFirst(8);
            arrayDeque.addFirst(6);
        }

        for (Iterator<Integer> it = arrayDeque.descendingIterator();
                                    it.hasNext(); ) {
            int i = it.next();
            System.out.print(i + " ");

        }
        System.out.println(arrayDeque);
    }
}
