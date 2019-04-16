package com.vaddya.polis.module1.seminar.collections;

import java.util.Iterator;

/**
 * №8
 */
public class LinkedDeque<E> implements IDeque<E> {

    public static void main(String[] args) {
        LinkedDeque<Integer> deque = new LinkedDeque<>();
        for (int i = 0; i < 5; i++) {
            deque.pushFront(i);
            deque.pushBack(-i);
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.popFront());
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            deque.pushFront(-i);
            deque.pushBack(i);
        }
        for (int i : deque) {
            System.out.println(i);
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public void pushFront(E element) {
        if (size++ == 0) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.next = new Node<>(element, null, head);
            head = head.next;
        }
    }

    @Override
    public void pushBack(E element) {
        if (size++ == 0) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.prev = new Node<>(element, tail, null);
            tail = tail.prev;
        }
    }

    @Override
    public E popFront() {
        if (size == 0) return null;
        E value = head.item;
        if (size-- == 1) {
            tail = head = null;
            return value;
        } else {
            head.prev.next = null;
            head = head.prev;
        }
        return value;
    }

    @Override
    public E popBack() {
        if (size == 0) return null;
        E value = tail.item;
        if (size-- == 1) {
            tail = head = null;
            return value;
        } else {
            tail.next.prev = null;
            tail = tail.next;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E value = curr.item;
                curr = curr.prev;
                return value;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
