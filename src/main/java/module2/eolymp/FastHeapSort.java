package module2.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/4848
 *
 * @author vaddya
 */
public class FastHeapSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            String[] src = in.nextLine().split(" ");
            int n = src.length;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(src[i]);
            }
            sort(array);
            for (int i : array) {
                writer.print(i + " ");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int size;

    private static void sort(int[] array) {
        size = array.length - 1;
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(array, i);
        }
        for (int i = 0; i < array.length; i++) {
            swap(array, size--, 0);
            siftDown(array, 0);
        }
    }

    private static void siftDown(int[] array, int i) {
        int left = leftOf(i);
        int right = rightOf(i);
        while (left <= size) {
            if (right > size) {
                if (array[i] < array[left]) {
                    swap(array, i, left);
                }
                break;
            }
            if (array[i] < array[left]) {
                if (array[i] > array[right]) {
                    swap(array, i, left);
                    i = left;
                } else {
                    int max = array[left] > array[right]
                            ? left
                            : right;
                    swap(array, i, max);
                    i = max;
                }
            } else if (array[i] < array[right]) {
                swap(array, i, right);
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

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
