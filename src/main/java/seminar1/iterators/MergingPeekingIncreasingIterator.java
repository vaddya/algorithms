package seminar1.iterators;

import java.util.Comparator;
import java.util.Iterator;

/**
 * №11 TODO is doesn't work
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(n + k * log n),
 * n — количество итераторов
 * k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        PeekingIncreasingIterator first = new PeekingIncreasingIterator(100, 4, 3);
        PeekingIncreasingIterator second = new PeekingIncreasingIterator(1, 4, 7);
        MergingPeekingIncreasingIterator merging = new MergingPeekingIncreasingIterator(first, second);
        for (int i = 0; i < 10; i++) {
            System.out.println(merging.next());
        }
    }

    private Comparator<PeekingIncreasingIterator> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());

    private PeekingIncreasingIterator[] iterators;

    public MergingPeekingIncreasingIterator(PeekingIncreasingIterator... peekingIterator) {
        iterators = peekingIterator;
        build();
    }

    private void build() {
        siftDown(); // fixme
    }

    @Override
    public boolean hasNext() {
        return iterators[0].hasNext();
    }

    @Override
    public Integer next() {
        int value = iterators[0].next();
        siftDown();
        return value;
    }

    private void siftDown() {
        int i = 0;
        int size = iterators.length - 1;
        int left = leftOf(i);
        int right = rightOf(i);
        while (left <= size) {
            if (right > size) {
                if (comparator.compare(iterators[i], iterators[left]) > 0) {
                    swap(iterators, i, left);
                }
                break;
            }
            if (comparator.compare(iterators[i], iterators[left]) < 0) {
                if (comparator.compare(iterators[i], iterators[right]) > 0) {
                    swap(iterators, i, left);
                    i = left;
                } else {
                    int min = comparator.compare(iterators[left], iterators[right]) < 0
                            ? left
                            : right;
                    swap(iterators, i, min);
                    i = min;
                }
            } else if (comparator.compare(iterators[i], iterators[right]) < 0) {
                swap(iterators, i, right);
                i = right;
            } else {
                break;
            }
            left = leftOf(i);
            right = rightOf(i);
        }
    }

    private static int leftOf(int i) {
        return i * 2 + 1;
    }

    private static int rightOf(int i) {
        return i * 2 + 2;
    }

    private static void swap(IPeekingIterator[] iterators, int i, int j) {
        IPeekingIterator temp = iterators[i];
        iterators[i] = iterators[j];
        iterators[j] = temp;
    }
}
