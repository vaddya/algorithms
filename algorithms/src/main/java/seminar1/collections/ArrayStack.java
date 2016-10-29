package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements IStack<T> {

    public static void main(String[] args) {
        IStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 1; i < 22; i++) {
            arrayStack.push(i);
        }
        while (!arrayStack.isEmpty()) {
            System.out.println(arrayStack.pop());
        }
        System.out.println("Size: " + arrayStack.size());
        for (int i = 1; i < 22; i++) {
            arrayStack.push(i);
        }
        while (!arrayStack.isEmpty()) {
            System.out.println(arrayStack.pop());
        }
        System.out.println("Size: " + arrayStack.size());
    }

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(T item) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = item;
        /* TODO: implement it */
    }

    @Override
    public T pop() {
        /* TODO: implement it */
        if (elementData.length / 4 >= size) {
            shrink();
        }
        if (size != 0) {
            return elementData[--size];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        changeCapacity((int) (elementData.length * 1.5));
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        changeCapacity(elementData.length >> 1);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
        System.out.println("Change capacity: " + newCapacity);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<T> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public T next() {
            return elementData[--currentPosition];
        }

    }

}
