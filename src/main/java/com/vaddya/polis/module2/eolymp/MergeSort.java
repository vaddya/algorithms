package com.vaddya.polis.module2.eolymp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/4037
 *
 * @author vaddya
 */
public class MergeSort {

    public static void main(String[] args) {
        try {
            FastScanner in = new FastScanner(new File("input.txt"));
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[][] array = new int[n][2];
            for (int i = 0; i < n; i++) {
                array[i][0] = in.nextInt();
                array[i][1] = in.nextInt();
            }
            sort(array);
            for (int i = 0; i < n; i++) {
                writer.print(array[i][0] + " " + array[i][1] + "\n");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[][] sort(int[][] array) {
        int[][] temp = new int[array.length][2];
        sort(array, temp, 0, array.length - 1);
        return array;
    }

    private static void sort(int[][] array, int[][] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(array, temp, left, mid);
        sort(array, temp, mid + 1, right);
        MergeSort.merge(array, temp, left, mid, right);
    }

    private static void merge(int[][] array, int[][] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = temp[j++];
            } else if (j > right) {
                array[k] = temp[i++];
            } else if (temp[i][0] <= temp[j][0]) {
                array[k] = temp[i++];
            } else if (temp[i][0] > temp[j][0]) {
                array[k] = temp[j++];
            }
        }
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
