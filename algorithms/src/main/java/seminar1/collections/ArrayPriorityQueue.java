package seminar1.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * №10 iterator
 */
public class ArrayPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {

    public static void main(String[] args) {
        ArrayPriorityQueue<Integer> queue = new ArrayPriorityQueue<>();
        for (int i = 5; i > 0; i--) {
            queue.add(i);
        }
        for (int i = 10; i < 15; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.extractMin());
        }
    }

    private static final int DEFAULT_CAPACITY = 10;

    private E[] array;
    private int size = 0;
    private Comparator<E> comparator;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        array = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public ArrayPriorityQueue(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    @Override
    public void add(E key) {
        if (size == array.length) {
            grow();
        }
        array[size++] = key;
        siftUp();
    }

    @Override
    public E peek() {
        return size != 0 ? array[0] : null;
    }

    @Override
    public E extractMin() {
        if (size == 0) return null;
        E element = array[0];
        array[0] = array[--size];
        siftDown();
        if (array.length / 4 >= size) {
            shrink();
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void siftUp() {
        int i = size - 1;
        int parent = parentOf(i);
        while (i > 0 && greater(i, parent)) {
            swap(array, i, parent);
            i = parent;
            parent = parentOf(i);
        }
    }

    private int parentOf(int i) {
        return (i - 1) / 2;
    }

    private void siftDown() {
        int i = 0;
        int left = leftOf(i);
        int right = rightOf(i);
        while (left <= size - 1) {
            if (right > size - 1) {
                if (greater(left, i)) {
                    swap(array, i, left);
                }
                break;
            }
            if (greater(left, i)) {
                if (!greater(right, i)) {
                    swap(array, i, left);
                    i = left;
                } else {
                    int max = greater(left, right)
                            ? left
                            : right;
                    swap(array, i, max);
                    i = max;
                }
            } else if (greater(right, i)) {
                swap(array, i, right);
                i = right;
            } else {
                break;
            }
            left = leftOf(i);
            right = rightOf(i);
        }
    }

    private int leftOf(int i) {
        return i * 2 + 1;
    }

    private int rightOf(int i) {
        return i * 2 + 2;
    }

    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void grow() {
        changeCapacity((int) (array.length * 1.5));
    }

    private void shrink() {
        changeCapacity(array.length >> 1);
    }

    private void changeCapacity(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
//        System.out.println("Capacity changed: " + newCapacity);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? array[i].compareTo(array[j]) > 0
                : comparator.compare(array[i], array[j]) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        /* TODO: implement it */
        return null;
    }
}
