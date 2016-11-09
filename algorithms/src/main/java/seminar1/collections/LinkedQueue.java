package seminar1.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * №4.2 todo
 */
public class LinkedQueue<Item> implements IQueue<Item> {

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
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    @Override
    public void enqueue(Item item) {
        if (size++ == 0) {
            head = tail = new Node<Item>(item);
        } else {
            tail = new Node<>(item, tail);
        }
    }

    @Override
    public Item dequeue() {
        if (size == 0) return null;
        if (size-- == 1) {
            return head.item;
        }
        Node<Item> curr = tail;
        while (curr.next != head) {
            curr = curr.next;
        }
        Item value = head.item;
        head = curr;
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
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {

        Node<Item> next = head;
        Node<Item> lastReturned;
        int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Item next() {

        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
