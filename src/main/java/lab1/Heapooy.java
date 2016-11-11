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
        private int[] array = new int[INITIAL_SIZE];
        private int tail = 1;

        public void push(int value) {
            ensureCapacity();
            array[tail] = value;
            siftUp(tail);
            tail++;
        }

        public int pop() {
            int value = array[1];
            array[1] = array[--tail];
            siftDown(1);
            return value;
        }

        public void siftUp(int i) {
            while (i > 1 && array[i] > array[i / 2]) {
                swap(array, i, i / 2);
                i /= 2;
            }
        }

        public void siftDown(int i) {
            while (i * 2 <= tail) {
                if (i * 2 + 1 > tail) { // right does not exist
                    if (array[i] >= array[i * 2 + 1]) {
                        swap(array, i, i * 2);
                        i *= 2;
                    }
                    break;
                }
                if (array[i] < array[i * 2]) { // curr < left
                    if (array[i] >= array[i * 2 + 1]) { // curr >= right
                        swap(array, i, i * 2);
                        i *= 2;
                    } else { // curr < right
                        int max = array[i * 2] > array[i * 2 + 1]
                                ? i * 2
                                : i * 2 + 1;
                        swap(array, i, max);
                        i = max;
                    }
                } else if (array[i] < array[i * 2 + 1]) { // curr > left, curr < right
                    swap(array, i, i * 2 + 1);
                    i = i * 2 + 1;
                } else { // curr > left, curr > right
                    break;
                }
            }
        }

        private static void swap(int[] array, int i, int j) {
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
