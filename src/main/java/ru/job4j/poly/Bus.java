package ru.job4j.poly;

public class Bus implements Transport {
    private double price;

    @Override
    public void drive() {
        System.out.println("Автобус отправляется.");

    }

    @Override
    public void passengers(int numbers) {
        if (numbers > 20 && numbers < 25) {
            drive();
        } else {
            System.out.print("Ждем пассажиров.");
        }
    }

    @Override
    public double refuel(int volume) {
        return volume * price;
    }
}
