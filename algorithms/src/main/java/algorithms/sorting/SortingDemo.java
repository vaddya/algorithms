package algorithms.sorting;

import java.util.Arrays;

/**
 * Sorting algorithms demo
 *
 * @author vaddya
 */
public class SortingDemo {
    private static final int[] array = new int[]{100, 1, 5, 2, 6, 10, 0, 34, 3, 74, 0, 65, 1, 4, 33};

    public static void main(String[] args) {
        print("Source:\n" + Arrays.toString(array));

        print("Bubble Sort");
        int[] bubble = array.clone();
        BubbleSort.sort(bubble);
        print(bubble);

        print("Selection Sort");
        int[] selection = array.clone();
        SelectionSort.sort(selection);
        print(selection);

        print("Heap Sort");
        int[] heap = array.clone();
        HeapSort.sort(heap);
        print(heap);

        print("Merge Sort");
        int[] merge = array.clone();
        MergeSort.sort(merge);
        print(merge);

        print("Quick Sort");
        int[] quick = array.clone();
        QuickSort.sort(quick);
        print(quick);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
