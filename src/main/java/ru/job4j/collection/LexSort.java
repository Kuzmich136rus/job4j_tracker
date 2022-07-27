package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] argLeft = left.split(". ");
        String[] argRight = right.split(". ");
        int numLeft = Integer.parseInt(argLeft[0]);
        int numRight = Integer.parseInt(argRight[0]);
        return Integer.compare(numLeft, numRight);
    }
}
