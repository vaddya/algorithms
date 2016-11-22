package module1.seminar.iterators;

import java.util.Iterator;

/**
 * №7
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(k),
 * k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        IncreasingIterator first = new IncreasingIterator(0, 4, 7);
        IncreasingIterator second = new IncreasingIterator(1, 4, 7);
        MergingIncreasingIterator merging = new MergingIncreasingIterator(first, second);
        while (merging.hasNext()) {
            System.out.println(merging.next());
        }
    }

    private IncreasingIterator first;
    private IncreasingIterator second;

    private Integer fromFirst;
    private Integer fromSecond;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        fromFirst = first.next();
        fromSecond = second.next();
    }

    @Override
    public boolean hasNext() {
        return fromFirst != null || fromSecond != null;
    }

    @Override
    public Integer next() {
        Integer value = null;
        if (fromFirst != null) {
            if (fromSecond != null) {
                if (fromFirst < fromSecond) {
                    value = fromFirst;
                    fromFirst = first.hasNext() ? first.next() : null;
                } else {
                    value = fromSecond;
                    fromSecond = second.hasNext() ? second.next() : null;
                }
            } else { // fromSecond == null
                value = fromFirst;
                fromFirst = first.hasNext() ? first.next() : null;
            }
        } else if (fromSecond != null) { // fromFirst == null
            value = fromSecond;
            fromSecond = second.hasNext() ? second.next() : null;
        }
        return value;
    }
}
