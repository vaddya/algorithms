package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * №2
 */
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
    }

    @Override
    public T pop() {
        if (elementData.length / 4 >= size) {
            shrink();
        }
        return size != 0 ? elementData[--size] : null;
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
        changeCapacity((int) (elementData.length * 1.5));
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
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
