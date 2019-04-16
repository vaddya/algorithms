package com.vaddya.polis.module1.seminar.collections;

import java.util.Iterator;

/**
 * №4.2
 */
public class LinkedQueue<E> implements IQueue<E> {

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // -> [tail -> .. -> .. -> head] ->
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public void enqueue(E element) {
        if (size == 0) {
            head = tail = new Node<>(element, null);
        } else {
            tail = new Node<>(element, tail);
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) return null;
        if (size == 1) {
            return head.item;
        }
        E value = head.item;
        head = findPrev(head);
        size--;
        return value;
    }

    private Node<E> findPrev(Node<E> node) {
        if (node == tail) return null;
        Node<E> curr = tail;
        while (curr.next != null && curr.next != node) {
            curr = curr.next;
        }
        return curr;
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
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E> {

        private Node<E> curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E value = curr.item;
            curr = findPrev(curr);
            return value;
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
