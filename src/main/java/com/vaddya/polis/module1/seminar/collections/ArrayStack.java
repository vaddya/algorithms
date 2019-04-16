package com.vaddya.polis.module1.seminar.collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * №2
 */
public class ArrayStack<E> implements IStack<E> {

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

    private E[] elementData;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E item) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = item;
    }

    @Override
    public E pop() {
        if (elementData.length / 4 >= size) {
            shrink();
        }
        return size > 0 ? elementData[--size] : null;
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
//        System.out.println("Capacity changed: " + newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public E next() {
            return elementData[--currentPosition];
        }

    }

}
