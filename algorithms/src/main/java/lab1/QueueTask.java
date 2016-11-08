package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/6125
 *
 * @author vaddya
 */
public class QueueTask {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            Queue queue = new Queue();
            String request;
            while (!"exit".equals(request = in.next())) {
                switch (request) {
                    case "push":
                        queue.push(in.nextInt());
                        writer.println("ok");
                        break;
                    case "pop":
                        writer.println(queue.pop());
                        break;
                    case "front":
                        writer.println(queue.front());
                        break;
                    case "size":
                        writer.println(queue.size());
                        break;
                    case "clear":
                        queue.clear();
                        writer.println("ok");
                        break;
                    default:
                        break;
                }
            }
            writer.println("bye");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Queue {

        private static final int INITIAL_SIZE = 101;
        private int[] queue = new int[INITIAL_SIZE];
        private int head = 0;
        private int tail = 0;

        public void push(int item) {
            queue[tail] = item;
            tail = (tail + 1) % queue.length;
        }

        public int pop() {
            int item = queue[head];
            head = (head + 1) % queue.length;
            return item;
        }

        public int front() {
            return queue[head];
        }

        public int size() {
            if (head > tail) {
                return queue.length - head + tail;
            } else {
                return tail - head;
            }
        }

        public void clear() {
            head = tail = 0;
            queue = new int[INITIAL_SIZE];
        }
    }
}