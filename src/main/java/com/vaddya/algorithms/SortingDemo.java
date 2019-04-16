package com.vaddya.algorithms;

import com.vaddya.algorithms.sorting.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static com.vaddya.algorithms.Utils.gen;
import static com.vaddya.algorithms.Utils.isSorted;

/**
 * Sorting com.vaddya.algorithms demonstration
 *
 * @author vaddya
 */
public class SortingDemo {

    private static final Class<?>[] sorting = new Class<?>[]{
            BubbleSort.class,
            SelectionSort.class,
            InsertionSort.class,
            ShellSort.class,
            HeapSort.class,
            MergeSort.class,
            QuickSort.class,
            CountingSort.class,
            MSD.class,
            LSD.class
    };

    public static void run(int[] source) {
        System.out.println("Source");
        System.out.println(Arrays.toString(source) + "\n");
        int passed = 0;
        int failed = 0;
        try {
            for (Class<?> clazz : sorting) {
                int[] array = source.clone();
                clazz.getMethod("sort", int[].class).invoke(null, array);
                if (isSorted(array)) {
                    System.out.print("(passed) ");
                    passed++;
                } else {
                    System.out.print("(failed) ");
                    failed++;
                }
                System.out.println(clazz.getSimpleName());
                System.out.println(Arrays.toString(array));
            }
            System.out.println("\n" + passed + " passed, " + failed + " failed");
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run(gen(50));
    }
}