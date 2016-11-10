package seminar1.collections;

import java.util.Iterator;

/**
 * №8
 */
public class LinkedDeque<Item> implements IDeque<Item> {

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

    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    @Override
    public void pushFront(Item element) {
        if (size++ == 0) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.next = new Node<>(element, null, head);
            head = head.next;
        }
    }

    @Override
    public void pushBack(Item element) {
        if (size++ == 0) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.prev = new Node<>(element, tail, null);
            tail = tail.prev;
        }
    }

    @Override
    public Item popFront() {
        if (size == 0) return null;
        Item value = head.item;
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
    public Item popBack() {
        if (size == 0) return null;
        Item value = tail.item;
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
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node<Item> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Item next() {
                Item value = curr.item;
                curr = curr.prev;
                return value;
            }
        };
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node<Item> next, Node<Item> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
