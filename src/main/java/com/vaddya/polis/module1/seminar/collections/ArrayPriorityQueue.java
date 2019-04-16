package com.vaddya.polis.module1.seminar.collections;

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
//        while (!queue.isEmpty()) {
//            System.out.println(queue.extractMin());
//        }
        for (int i : queue) {
            System.out.println(i);
        }
    }

    private static final int DEFAULT_CAPACITY = 10;

    private E[] elementData;
    private int size = 0;
    private Comparator<E> comparator;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elementData = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public ArrayPriorityQueue(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    @Override
    public void add(E key) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = key;
        siftUp();
    }

    @Override
    public E peek() {
        return size != 0 ? elementData[0] : null;
    }

    @Override
    public E extractMin() {
        if (size == 0) return null;
        E element = elementData[0];
        elementData[0] = elementData[--size];
        siftDown();
        if (elementData.length / 4 >= size) {
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
        while (i > 0 && greater(parent, i)) {
            swap(elementData, i, parent);
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
                if (greater(i, left)) {
                    swap(elementData, i, left);
                }
                break;
            }
            if (greater(i, left)) {
                if (!greater(i, right)) {
                    swap(elementData, i, left);
                    i = left;
                } else {
                    int min = greater(left, right)
                            ? right
                            : left;
                    swap(elementData, i, min);
                    i = min;
                }
            } else if (greater(i, right)) {
                swap(elementData, i, right);
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
        changeCapacity((int) (elementData.length * 1.5));
    }

    private void shrink() {
        changeCapacity(elementData.length >> 1);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
//        System.out.println("Capacity changed: " + newCapacity);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO: 11/13/2016 fix
        return new Iterator<E>() {
            private int curr = 0;
            @Override
            public boolean hasNext() {
                return curr < size;
            }

            @Override
            public E next() {
                return elementData[curr];
            }
        };
    }
}
