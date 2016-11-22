package module1.seminar.collections;

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
        for (int i : deque) {
            System.out.println(i);
        }
    }

    private static final int INITIAL_SIZE = 10;

    private E[] elementData;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        elementData = (E[]) new Object[INITIAL_SIZE];
        head = tail = 0;
    }

    @Override
    public void pushFront(E element) {
        if (size() == elementData.length - 1) {
            grow();
        }
        head = head == 0
                ? elementData.length - 1
                : head - 1;
        elementData[head] = element;
    }

    @Override
    public void pushBack(E element) {
        if (size() == elementData.length - 1) {
            grow();
        }
        elementData[tail] = element;
        tail = (tail + 1) % elementData.length;
    }

    @Override
    public E popFront() {
        if (size() < elementData.length >> 2) {
            shrink();
        }
        E value = elementData[head];
        head = head == elementData.length - 1
                ? 0
                : head + 1;
        return value;
    }

    @Override
    public E popBack() {
        if (size() < elementData.length >> 2) {
            shrink();
        }
        tail = tail == 0
                ? elementData.length - 1
                : tail - 1;
        return elementData[tail];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return tail >= head
                ? tail - head
                : elementData.length - head + tail;
    }

    private void grow() {
        changeCapacity((int) (elementData.length * 1.5));
    }

    private void shrink() {
        changeCapacity(elementData.length >> 1);
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        E[] newQueue = (E[]) new Object[newCapacity];
        if (tail >= head) {
            System.arraycopy(elementData, head, newQueue, 0, size());
            tail -= head;
            head = 0;
        } else {
            System.arraycopy(elementData, 0, newQueue, 0, tail);
            int delta = elementData.length - head;
            int newHead = newCapacity - delta;
            System.arraycopy(elementData, head, newQueue, newHead, delta);
            head = newHead;
        }
        elementData = newQueue;
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
                E value = elementData[curr];
                curr = (curr + 1) % elementData.length;
                return value;
            }
        };
    }
}
