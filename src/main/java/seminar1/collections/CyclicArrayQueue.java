package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * №6 check
 */
public class CyclicArrayQueue<Item> implements IQueue<Item> {

    public static void main(String[] args) {
        IQueue<Integer> queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.dequeue());
//        }
        for (int i : queue) {
            System.out.println(i);
        }
    }

    private static final int INITIAL_SIZE = 10;

    private Item[] queue;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        queue = (Item[]) new Object[INITIAL_SIZE];
        head = tail = 0;
    }

    @Override
    public void enqueue(Item item) {
        if (size() == queue.length - 1) {
            grow();
        }
        queue[tail] = item;
        tail = (tail + 1) % queue.length;
    }

    @Override
    public Item dequeue() {
        Item item = queue[head];
        head = (head + 1) % queue.length;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        if (head > tail) {
            return queue.length - head + tail;
        } else {
            return tail - head;
        }
    }

    private void grow() {
        changeCapacity((int) (queue.length * 1.5));
    }

    private void changeCapacity(int newCapacity) {
        queue = Arrays.copyOf(queue, newCapacity);
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
                Item value = queue[curr];
                curr = (curr + 1) % queue.length;
                return value;
            }
        };
    }
}
