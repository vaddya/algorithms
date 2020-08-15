package com.vaddya.stepik.structures;

import java.util.Scanner;

public class TableJoin {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int tableNum = scan.nextInt();
            int queryNum = scan.nextInt();
            Table[] tables = new Table[tableNum];
            for (int i = 0; i < tableNum; i++) {
                tables[i] = new Table(i, scan.nextInt());
            }
            Query[] queries = new Query[queryNum];
            for (int i = 0; i < queryNum; i++) {
                queries[i] = new Query(scan.nextInt(), scan.nextInt());
            }
            int[] maxTables = maxTablesAfterQueries(tables, queries);
            for (int maxTable : maxTables) {
                System.out.println(maxTable);
            }
        }
    }

    /**
     * Объединение таблиц
     * <p>
     * В базе данных есть n таблиц, пронумерованных от 1 до n, над одним и тем же
     * множеством столбцов (атрибутов). Каждая таблица содержит либо реальные записи в
     * таблице, либо символьную ссылку на другую таблицу. Изначально все таблицы содержат
     * реальные записи, и i-я таблица содержит ri записей. Ваша цель — обработать m
     * запросов типа (destination, source).
     */
    public static int[] maxTablesAfterQueries(Table[] tables, Query[] queries) {
        int[] result = new int[queries.length];
        int maxRecords = tables[0].recordNum();
        for (int i = 1; i < tables.length; i++) {
            if (tables[i].recordNum() > maxRecords) {
                maxRecords = tables[i].recordNum();
            }
        }
        for (int i = 0; i < queries.length; i++) {
            Query query = queries[i];
            Table src = tables[query.src - 1];
            Table dst = tables[query.dst - 1];
            src.join(dst);
            if (dst.recordNum() > maxRecords) {
                maxRecords = dst.recordNum();
            }
            result[i] = maxRecords;
        }
        return result;
    }

    public static class Table {
        private final int index;
        private int recordNum;
        private Table ref;

        public Table(int index, int recordNum) {
            this.index = index;
            this.recordNum = recordNum;
        }

        public int recordNum() {
            if (ref != null) {
                return ref.recordNum();
            }
            return recordNum;
        }

        public void join(Table dst) {
            Table srcReal = realTable();
            Table dstReal = dst.realTable();
            if (srcReal.index != dstReal.index) {
                dstReal.recordNum += srcReal.recordNum;
                srcReal.recordNum = 0;
                srcReal.ref = dstReal;
            }
        }

        public Table realTable() {
            if (ref == null) {
                return this;
            }
            ref = ref.realTable();
            return ref;
        }
    }

    public static class Query {
        public final int dst;
        public final int src;

        public Query(int dst, int src) {
            this.dst = dst;
            this.src = src;
        }
    }
}
