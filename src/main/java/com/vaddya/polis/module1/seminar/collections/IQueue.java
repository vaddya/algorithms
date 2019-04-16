package com.vaddya.polis.module1.seminar.collections;

/**
 * FIFO — First In First Out
 */
public interface IQueue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();

}
