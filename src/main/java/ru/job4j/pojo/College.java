package ru.job4j.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        GregorianCalendar date = new GregorianCalendar(2021, Calendar.SEPTEMBER, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy");

        student.setName("Пономарев Иван Иванович");
        student.setGroup("10Э-3");

        System.out.println("Student " + student.getName() + " обучается в группе  " + student.getGroup() + " c " + dateFormat.format(date.getTime()));
    }
}
