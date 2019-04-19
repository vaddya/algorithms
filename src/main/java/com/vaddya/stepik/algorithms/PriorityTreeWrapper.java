package com.vaddya.stepik.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PriorityTreeWrapper {
    private static final String INSERT = "Insert";

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();

            Tree tree = new Tree();

            for (int i = 0; i < n; i++) {
                String command = scan.next();
                if (command.equals(INSERT)) {
                    tree.add(new Node(scan.nextInt()));
                } else {
                    System.out.println(tree.extract());
                }
            }
        }
    }

    public static class Tree {
        private final Queue<Node> nodes = new PriorityQueue<>();

        public void add(Node node) {
            nodes.add(node);
        }

        public Node extract() {
            if (nodes.size() > 0) {
                return nodes.poll();
            }
            return null;
        }
    }

    public static class Node implements Comparable<Node> {
        private final int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
}
