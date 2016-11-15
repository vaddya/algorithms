package seminar1.collections;

import java.util.Iterator;

/**
 * №9
 */
public class CyclicArrayDeque<E> implements IDeque<E> {

    public static void main(String[] args) {
        CyclicArrayDeque<Integer> deque = new CyclicArrayDeque<>();
        for (int i = 1; i < 6; i++) {
            deque.pushBack(i); // -5 .. -1 1 .. 5
            deque.pushFront(-i);
        }
        for (int i = 0; i < 4; i++) {
            deque.popBack(); // -1 1
            deque.popFront();
        }
        for (int i = 2; i < 10; i++) {
            deque.pushBack(i); // -9 .. -1 1 .. 9
            deque.pushFront(-i);
        }
//        while (!deque.isEmpty()) {
//            System.out.println(deque.popFront());
//        }
        for (int i : deque) {
            System.out.println(i);
        }
    }

    private static final int INITIAL_SIZE = 10;

    private E[] array;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        array = (E[]) new Object[INITIAL_SIZE];
        head = tail = 0;
    }

    @Override
    public void pushFront(E element) {
        if (size() == array.length - 1) {
            grow();
        }
        head = head == 0
                ? array.length - 1
                : head - 1;
        array[head] = element;
    }

    @Override
    public void pushBack(E element) {
        if (size() == array.length - 1) {
            grow();
        }
        array[tail] = element;
        tail = (tail + 1) % array.length;
    }

    @Override
    public E popFront() {
        if (size() < array.length >> 2) {
            shrink();
        }
        E value = array[head];
        head = head == array.length - 1
                ? 0
                : head + 1;
        return value;
    }

    @Override
    public E popBack() {
        if (size() < array.length >> 2) {
            shrink();
        }
        tail = tail == 0
                ? array.length - 1
                : tail - 1;
        return array[tail];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return tail >= head
                ? tail - head
                : array.length - head + tail;
    }

    private void grow() {
        changeCapacity((int) (array.length * 1.5));
    }

    private void shrink() {
        changeCapacity(array.length >> 1);
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        E[] newQueue = (E[]) new Object[newCapacity];
        if (tail >= head) {
            System.arraycopy(array, head, newQueue, 0, size());
            tail -= head;
            head = 0;
        } else {
            System.arraycopy(array, 0, newQueue, 0, tail);
            int delta = array.length - head;
            int newHead = newCapacity - delta;
            System.arraycopy(array, head, newQueue, newHead, delta);
            head = newHead;
        }
        array = newQueue;
//        System.out.println("Capacity changed: " + newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int curr = head;

            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public E next() {
                E value = array[curr];
                curr = (curr + 1) % array.length;
                return value;
            }
        };
    }
}
