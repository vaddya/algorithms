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
        out("Source");
        out(array);

        out("Bubble Sort");
        int[] bubble = array.clone();
        BubbleSort.sort(bubble);
        out(bubble);

        out("Selection Sort");
        int[] selection = array.clone();
        SelectionSort.sort(selection);
        out(selection);

        out("Insertion Sort");
        int[] insertion = array.clone();
        InsertionSort.sort(insertion);
        out(insertion);

        out("Shell Sort");
        int[] shell = array.clone();
        HeapSort.sort(shell);
        out(shell);

        out("Heap Sort");
        int[] heap = array.clone();
        HeapSort.sort(heap);
        out(heap);

        out("Merge Sort");
        int[] merge = array.clone();
        MergeSort.sort(merge);
        out(merge);

        out("Quick Sort");
        int[] quick = array.clone();
        QuickSort.sort(quick);
        out(quick);
    }

    private static void out(String s) {
        System.out.println(s);
    }

    private static void out(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
