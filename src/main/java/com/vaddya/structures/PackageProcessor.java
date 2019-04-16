package com.vaddya.structures;

import java.util.*;

public class PackageProcessor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int n = scan.nextInt();
        List<Package> packages = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            packages.add(new Package(scan.nextInt(), scan.nextInt()));
        }
        process(size, packages);
        for (Package p : packages) {
            System.out.println(p.getProcessStartTime());
        }
    }

    /**
     * Реализовать обработчик сетевых пакетов.
     * <p>
     * Для каждого из данных пакетов необходимо вывести время начала его обработки или −1,
     * если пакет не был обработан (это происходит в случае, когда пакет поступает в момент,
     * когда в буфере компьютера уже находится size пакетов).
     *
     * @param size     Размер буфера
     * @param packages две последовательности (arrival и duration),
     *                 обозначающих время поступлени и длительность обработки пакетов.
     */
    public static void process(int size, List<Package> packages) {
        Queue<Package> queue = new LinkedList<>();
        ListIterator<Package> it = packages.listIterator();
        for (int time = 0; it.hasNext() || !queue.isEmpty(); time++) {
            if (queue.isEmpty()) {
                int arrival = it.next().getArrival();
                it.previous();
                time = time < arrival ? arrival : time;
            }

            while (it.hasNext()) {
                Package p = it.next();
                if (p.getArrival() > time) {
                    it.previous();
                    break;
                }
                if (queue.size() == size) {
                    p.refuseProcess();
                } else {
                    if (p.getDuration() == 0 && (queue.isEmpty() || queue.peek().getProcessTimeLeft() == 0)) {
                        p.startProcess(time);
                    } else {
                        queue.offer(p);
                    }
                }
            }

            boolean ticked = false;
            while (!ticked && !queue.isEmpty()) {
                Package p = queue.peek();
                if (p.getProcessStartTime() == -1) {
                    p.startProcess(time);
                }
                if (p.getProcessTimeLeft() > 0) {
                    p.process();
                    ticked = true;
                }
                if (p.getProcessTimeLeft() == 0) {
                    queue.poll();
                }
            }
        }
    }

    static class Package {

        private int arrival;
        private int duration;
        private int processStartTime;
        private int processTimeLeft;

        Package(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
            this.processStartTime = -1;
            this.processTimeLeft = duration;
        }

        int getArrival() {
            return arrival;
        }

        int getDuration() {
            return duration;
        }

        void refuseProcess() {
            processStartTime = -1;
        }

        void startProcess(int time) {
            processStartTime = time;
        }

        void process() {
            processTimeLeft--;
        }

        int getProcessStartTime() {
            return processStartTime;
        }

        int getProcessTimeLeft() {
            return processTimeLeft;
        }
    }
}
