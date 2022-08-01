package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
       String[] wordObj1 = o1.split("/");
       String[] wordObj2 = o2.split("/");
       int rsl = wordObj2[0].compareTo(wordObj1[0]);
       if (rsl == 0) {
           rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
