package module1.seminar.collections;

import java.util.Iterator;

/**
 * №3
 */
public class LinkedStack<E> implements IStack<E> {

    public static void main(String[] args) {
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private Node<E> head;
    private int size;

    @Override
    public void push(E item) {
        Node<E> curr = new Node<E>(item, head);
        head = curr;
        size++;
    }

    @Override
    public E pop() {
        Node<E> curr = head;
        head = head.next;
        size--;
        return curr.item;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E> {

        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E res = current.item;
            current = current.next;
            return res;
        }

    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
