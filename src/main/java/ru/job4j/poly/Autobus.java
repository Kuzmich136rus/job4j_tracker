package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(nameClass() + " двигается по скоростным трассам.");
    }

    @Override
    public String nameClass() {
        return "Автобус";
    }
}
