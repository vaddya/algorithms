package com.vaddya.stepik.structures;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Processing {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int procNum = scan.nextInt();
            int taskNum = scan.nextInt();
            long[] array = new long[taskNum];
            for (int i = 0; i < taskNum; i++) {
                array[i] = scan.nextLong();
            }
            Work[] works = process(procNum, array);
            for (int i = 0; i < works.length; i++) {
                System.out.println(works[i].processor + " " + (works[i].time - array[i]));
            }
        }
    }

    /**
     * Параллельная обработка
     * <p>
     * По данным n процессорам и m задач определите, для каждой из задач,
     * каким процессором она будет обработана.
     * Вход. Число процессоров n и последовательность чисел t0,..., tm−1,
     * где ti — время, необходимое на обработку i-й задачи.
     * Выход. Для каждой задачи определите, какой процессор и в какое время начнёт её обрабатывать,
     * предполагая, что каждая задача поступает на обработку первому освободившемуся процессору.
     */
    public static Work[] process(int procNum, long[] times) {
        Work[] works = new Work[times.length];
        PriorityQueue<Work> queue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            Work work;
            if (i < procNum) {
                work = new Work(i % procNum, times[i]);
            } else {
                Work finished = queue.poll();
                assert finished != null;
                work = new Work(finished.processor, finished.time + times[i]);
            }
            queue.add(work);
            works[i] = work;
        }
        return works;
    }

    public static class Work implements Comparable<Work> {
        public final int processor;
        public final long time;

        public Work(int processor, long time) {
            this.processor = processor;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            int cmp = Long.compare(time, o.time);
            return cmp != 0 ? cmp : Integer.compare(processor, o.processor);
        }
    }
}
