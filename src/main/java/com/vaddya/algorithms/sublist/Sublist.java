package com.vaddya.algorithms.sublist;

import java.util.List;

/**
 * Sublist [start, end) from list
 *
 * @author vaddya
 * @since March 05, 2017
 */
public class Sublist {

    private final List<Integer> list;
    private int start;
    private int end;

    public Sublist(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setBounds(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> getElements() {
        return list.subList(start, end);
    }

    public int getSum() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "from " + start +
                " to " + end +
                ", elements=" + getElements();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sublist)) return false;

        Sublist sublist = (Sublist) o;

        return start == sublist.start &&
                end == sublist.end &&
                list.equals(sublist.list);
    }

    @Override
    public int hashCode() {
        int result = list.hashCode();
        result = 31 * result + start;
        result = 31 * result + end;
        return result;
    }
}