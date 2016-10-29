package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<T> implements IStack<T> {

    public static void main(String[] args) {
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
        for (int i : stack) {
            System.out.println(i);
        }
    }

    private Node<T> head;
    private int size;

    @Override
    public void push(T item) {
        Node<T> curr = new Node<T>(item, head);
        head = curr;
        size++;
        /* TODO: implement it */
    }

    @Override
    public T pop() {
        Node<T> curr = head;
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
    public Iterator<T> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<T> {

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T res = current.item;
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
