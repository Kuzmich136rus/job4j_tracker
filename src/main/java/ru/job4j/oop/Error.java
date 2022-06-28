package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Состояние ошибки: " + active);
        System.out.println("Приоритет ошибки: " + status);
        System.out.println("Сообщение об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        first.printError();
        Error second = new Error(true, 2, "Very interesting error");
        second.printError();
    }

}
