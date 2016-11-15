package seminar1.collections;

import java.util.Iterator;

/**
 * №6
 */
public class CyclicArrayQueue<E> implements IQueue<E> {

    public static void main(String[] args) {
        IQueue<Integer> queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i); // 0 .. 29
        }
        for (int i = 0; i < 25; i++) {
            queue.dequeue(); // 25 .. 29
        }
        for (int i = 100; i < 120; i++) {
            queue.enqueue(i); // 25 .. 29 100 .. 119
        }
//        while (!elementData.isEmpty()) {
//            System.out.println(elementData.dequeue());
//        }
        for (int i : queue) {
            System.out.println(i);
        }
    }

    private static final int INITIAL_SIZE = 10;

    private E[] elementData;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        elementData = (E[]) new Object[INITIAL_SIZE];
        head = tail = 0;
    }

    @Override
    public void enqueue(E element) {
        if (size() == elementData.length - 1) {
            grow();
        }
        elementData[tail] = element;
        tail = (tail + 1) % elementData.length;
    }

    @Override
    public E dequeue() {
        if (size() < elementData.length >> 2) {
            shrink();
        }
        E element = elementData[head];
        head = (head + 1) % elementData.length;
        return element;
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
        E[] newElementData = (E[]) new Object[newCapacity];
        if (tail >= head) {
            System.arraycopy(elementData, head, newElementData, 0, size());
            tail -= head;
            head = 0;
        } else {
            System.arraycopy(elementData, 0, newElementData, 0, tail);
            int delta = elementData.length - head;
            int newHead = newCapacity - delta;
            System.arraycopy(elementData, head, newElementData, newHead, delta);
            head = newHead;
        }
        elementData = newElementData;
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
