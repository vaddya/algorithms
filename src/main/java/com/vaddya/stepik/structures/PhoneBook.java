package com.vaddya.stepik.structures;

import java.util.Scanner;

/**
 * Телефонная книга
 * <p>
 * Реализовать структуру данных, эффективно обрабатывающую запросы вида
 * add number name, del number и find number.
 * Вход. Последовательность запросов вида add number name, del number и find number,
 * где number — телефонный номер, содержащий не более семи знаков, а name — короткая строка.
 * Выход. Для каждого запроса find number выведите соответствующее имя или сообщите,
 * что такой записи нет.
 */
public class PhoneBook {
    private static final int MAX_NUMBER = 10_000_000;
    private static final String ADD = "add";
    private static final String DEL = "del";
    private static final String FIND = "find";
    private static final String NOT_FOUND = "not found";

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            PhoneBook phoneBook = new PhoneBook();
            int n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                switch (scan.next()) {
                    case ADD:
                        phoneBook.add(scan.nextInt(), scan.next());
                        break;
                    case DEL:
                        phoneBook.del(scan.nextInt());
                        break;
                    case FIND:
                        String name = phoneBook.find(scan.nextInt());
                        System.out.println(name != null ? name : NOT_FOUND);
                        break;
                }
            }
        }
    }

    private final String[] store = new String[MAX_NUMBER];

    public void add(int number, String name) {
        store[number] = name;
    }

    public void del(int number) {
        store[number] = null;
    }

    public String find(int number) {
        return store[number];
    }
}
