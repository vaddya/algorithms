package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/4039
 *
 * @author vaddya
 */
public class Heapooy {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            Heap heap = new Heap();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int req = in.nextInt();
                if (req == 0) {
                    heap.push(in.nextInt());
                } else {
                    writer.println(heap.pop());
                }
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Heap {

        private static final int INITIAL_SIZE = 10;
        private int[] array;
        private int tail = 1;

        public Heap() {
            array = new int[INITIAL_SIZE];
        }

        void push(int value) {
            ensureCapacity();
            array[tail] = value;
            siftUp(tail);
            tail++;
        }

        int pop() {
            int value = array[1];
            array[1] = array[--tail];
            siftDown(1);
            return value;
        }

        void siftUp(int i) {
            while (i > 1 && array[i] > array[i / 2]) {
                swap(i, i / 2);
                i /= 2;
            }
        }

        void siftDown(int i) {
            int n = array.length;
            while (i * 2 <= tail) {
                if (i * 2 + 1 > tail) {
                    if (array[i] >= array[i * 2 + 1]) {
                        swap(i, i * 2);
                        i *= 2;
                    }
                    return;
                }
                if (array[i] < array[i * 2]) {
                    if (array[i] >= array[i * 2 + 1]) {
                        swap(i, i * 2);
                        i *= 2;
                    } else {
                        int max = array[i * 2] > array[i * 2 + 1]
                                ? i * 2
                                : i * 2 + 1;
                        swap(i, max);
                        i = max;
                    }
                } else if (array[i] < array[i * 2 + 1]) {
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private void ensureCapacity() {
            if (tail == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
            }
        }
    }
}
