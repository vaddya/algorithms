package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/** todo
 * https://www.e-olymp.com/ru/problems/4036
 *
 * @author vaddya
 */
public class FastQuickSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
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

    private static Random random = new Random(System.currentTimeMillis());

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, left + random.nextInt(right - left));
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
