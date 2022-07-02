package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Пономарев Иван Иванович");
        student.setGroup("10Э-3");
        student.setDate(LocalDate.of(2021, 9, 1));

        System.out.println("Студент " + student.getName() + " обучается в группе  " + student.getGroup() + " c " + student.getDate());
    }
}
