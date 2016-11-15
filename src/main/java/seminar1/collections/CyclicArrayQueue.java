package seminar1.collections;

import java.util.Iterator;

/**
 * №6
 */
public class CyclicArrayQueue<Item> implements IQueue<Item> {

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
//        while (!array.isEmpty()) {
//            System.out.println(array.dequeue());
//        }
        for (int i : queue) {
            System.out.println(i);
        }
    }

    private static final int INITIAL_SIZE = 10;

    private Item[] array;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        array = (Item[]) new Object[INITIAL_SIZE];
        head = tail = 0;
    }

    @Override
    public void enqueue(Item item) {
        if (size() == array.length - 1) {
            grow();
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
    }

    @Override
    public Item dequeue() {
        if (size() < array.length >> 2) {
            shrink();
        }
        Item item = array[head];
        head = (head + 1) % array.length;
        return item;
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
        Item[] newArray = (Item[]) new Object[newCapacity];
        if (tail >= head) {
            System.arraycopy(array, head, newArray, 0, size());
            tail -= head;
            head = 0;
        } else {
            System.arraycopy(array, 0, newArray, 0, tail);
            int delta = array.length - head;
            int newHead = newCapacity - delta;
            System.arraycopy(array, head, newArray, newHead, delta);
            head = newHead;
        }
        array = newArray;
//        System.out.println("Capacity changed: " + newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int curr = head;

            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public Item next() {
                Item value = array[curr];
                curr = (curr + 1) % array.length;
                return value;
            }
        };
    }
}
