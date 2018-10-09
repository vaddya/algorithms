package module2.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Сортировка времени
 * https://www.e-olymp.com/ru/problems/972
 *
 * @author vaddya
 */
public class TimeSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[][] array = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = in.nextInt();
                }
            }
            array = sort(array);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.print(array[i][j]);
                    writer.print(j == 2 ? '\n' : ' ');
                }
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[][] sort(int[][] array) {
        for (int i = array[0].length - 1; i >= 0; i--) {
            array = mergeSort(array, i);
        }
        return array;
    }

    private static int[][] mergeSort(int[][] array, int n) {
        int[][] temp = new int[array.length][array[0].length];
        mergeSort(array, temp, 0, array.length - 1, n);
        return array;
    }

    private static void mergeSort(int[][] array, int[][] temp, int left, int right, int n) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, temp, left, mid, n);
        mergeSort(array, temp, mid + 1, right, n);
        merge(array, temp, left, mid, right, n);
    }

    private static void merge(int[][] array, int[][] temp, int left, int mid, int right, int n) {
        System.arraycopy(array, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = temp[j++];
            } else if (j > right) {
                array[k] = temp[i++];
            } else if (temp[i][n] <= temp[j][n]) {
                array[k] = temp[i++];
            } else if (temp[i][n] > temp[j][n]) {
                array[k] = temp[j++];
            }
        }
    }

}
