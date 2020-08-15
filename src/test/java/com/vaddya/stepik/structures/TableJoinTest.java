package com.vaddya.stepik.structures;

import com.vaddya.stepik.structures.TableJoin.Query;
import com.vaddya.stepik.structures.TableJoin.Table;
import org.junit.Assert;
import org.junit.Test;

public class TableJoinTest {

    @Test
    public void testMaxTablesAfterQueries() {
        Table[] tables = new Table[]{t(1, 1), t(2, 1), t(3, 1), t(4, 1), t(5, 1)};
        Query[] queries = new Query[]{q(3, 5), q(2, 4), q(1, 4), q(5, 4), q(5, 3)};
        int[] maxTables = TableJoin.maxTablesAfterQueries(tables, queries);
        int[] expected = new int[]{2, 2, 3, 5, 5};
        Assert.assertArrayEquals(expected, maxTables);
    }

    private Table t(int i, int r) {
        return new Table(i, r);
    }

    private Query q(int d, int s) {
        return new Query(d, s);
    }
}