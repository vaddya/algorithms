package com.vaddya.polis.module1.seminar.collections;

/**
 * LIFO + FIFO = Last/First In First Out
 */
public interface IDeque<Item> extends Iterable<Item> {

    void pushFront(Item item);

    void pushBack(Item item);

    Item popFront();

    Item popBack();

    boolean isEmpty();

    int size();

}
