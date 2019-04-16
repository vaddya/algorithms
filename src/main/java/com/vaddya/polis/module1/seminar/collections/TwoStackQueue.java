package com.vaddya.polis.module1.seminar.collections;

import java.util.Iterator;

/**
 * №5.2
 */
public class TwoStackQueue<E> implements IQueue<E> {

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int i = 5; i > 0; i--) {
            queue.enqueue(i);
        }
        System.out.println("Size: " + queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    private IStack<E> stack1;
    private IStack<E> stack2;

    public TwoStackQueue() {
        stack1 = new ArrayStack<E>();
        stack2 = new ArrayStack<E>();
    }

    @Override
    public void enqueue(E element) {
        stack1.push(element);
    }

    @Override
    public E dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public Iterator<E> iterator() {
        /* TODO: implement it (optional) */
        return null;
    }

}
