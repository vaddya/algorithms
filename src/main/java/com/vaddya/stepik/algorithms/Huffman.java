package com.vaddya.stepik.algorithms;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toMap;

public class Huffman {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            scan.nextInt();

            Map<String, Character> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char character = scan.next().charAt(0);
                map.put(scan.next(), character);
            }
            String encoded = scan.next();
            String decoded = decode(encoded, map);

            System.out.println(decoded);
        }
    }

    /**
     * Восстановите строку по её коду и беспрефиксному коду символов.
     */
    public static String decode(String str, Map<String, Character> tree) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int t = i;
            String curr = str.substring(t, i + 1);
            while (!tree.containsKey(curr)) {
                i++;
                curr = str.substring(t, i + 1);
            }
            res.append(tree.get(curr));
        }
        return res.toString();
    }

    /**
     * По данной непустой строке s длины не более 10^4, состоящей из строчных букв латинского алфавита,
     * постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
     * встречающихся в строке, и размер получившейся закодированной строки.
     */
    public static String encode(String str, Map<Character, String> tree) {
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()) {
            res.append(tree.get(c));
        }
        return res.toString();
    }

    public static Map<Character, String> tree(String str) {
        Map<Character, Integer> map = frequencyMap(str);

        if (map.size() == 1) {
            Map<Character, String> res = new HashMap<>();
            res.put(str.charAt(0), "0");
            return res;
        }

        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new PriorityQueue<>();
        map.forEach((key, value) -> queue.add(Node.from(key, value)));
        while (queue.size() >= 2) {
            Node right = queue.poll();
            Node left = queue.poll();

            right.prefix('0');
            left.prefix('1');

            if (!right.hasChildren()) {
                nodes.add(right);
            }
            if (!left.hasChildren()) {
                nodes.add(left);
            }

            queue.add(Node.from(left, right));
        }

        return nodes.stream()
                .collect(toMap(node -> node.character, node -> node.code.toString()));
    }

    public static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static class Node implements Comparable<Node> {
        private static final Comparator<Node> comparator = comparing((Node node) -> node.frequency)
                .thenComparing(comparing((Node node) -> node.character).reversed());

        private final char character;
        private final int frequency;
        private final Node left;
        private final Node right;
        private final StringBuilder code;

        public static Node from(char character, int frequency) {
            return new Node(character, frequency, null, null);
        }

        public static Node from(Node left, Node right) {
            return new Node('Z', left.frequency + right.frequency, left, right);
        }

        private Node(char character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
            this.code = new StringBuilder();
        }

        public boolean hasChildren() {
            return left != null && right != null;
        }

        public void prefix(Character character) {
            code.insert(0, character);
            if (!hasChildren()) {
                return;
            }
            left.prefix(character);
            right.prefix(character);
        }

        @Override
        public int compareTo(Node o) {
            return comparator.compare(this, o);
        }
    }
}
