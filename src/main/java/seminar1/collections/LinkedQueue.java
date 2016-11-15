package seminar1.collections;

import java.util.Iterator;

/**
 * №4.2
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
    private int size = 0;

    @Override
    public void enqueue(Item item) {
        if (size == 0) {
            head = tail = new Node<>(item, null);
        } else {
            tail = new Node<>(item, tail);
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (size == 0) return null;
        if (size == 1) {
            return head.item;
        }
        Item value = head.item;
        head = findPrev(head);
        size--;
        return value;
    }

    private Node<Item> findPrev(Node<Item> node) {
        if (node == tail) return null;
        Node<Item> curr = tail;
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
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {

        private Node<Item> curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item value = curr.item;
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
