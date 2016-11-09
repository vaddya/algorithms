package seminar1.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * №10 todo
 */
public class ArrayPriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elementData;
    private int size;
    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        /* TODO: implement it — O(n) */
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayPriorityQueue(Comparator<T> comparator) {
        this();
        /* TODO: implement it — O(n) */
        this.comparator = comparator;
    }

    @Override
    public void add(T key) {
        /* TODO: implement it — O(log n) */

    }

    @Override
    public T peek() {
        /**
         * TODO: implement it — O(1)
         * Посмотреть на минимальный элемент
         */
        return null;
    }

    @Override
    public T extractMin() {
        /**
         * TODO: implement it — O(log n)
         * Достать минимальный элемент
         *  и перестроить кучу
         */
        if (size == 0) return null;
        T element = elementData[0];
        elementData[0] = elementData[size--];
        siftDown();
        if (elementData.length / 4 >= size) {
            shrink();
        }
        return elementData[0];
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
        /**
         * TODO: implement it — O(log n)
         * Просеивание вверх —
         *  подъём элемента больше родителей
         */
    }

    private void siftDown() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вниз
         *  спуск элемента меньше детей
         */
    }

    private void grow() {
        changeCapacity((int) (elementData.length * 1.5));
    }

    private void shrink() {
        changeCapacity(elementData.length >> 1);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
        System.out.println("Change capacity: " + newCapacity);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0
                ;
    }

    @Override
    public Iterator<T> iterator() {
        /* TODO: implement it */
        return null;
    }
}
