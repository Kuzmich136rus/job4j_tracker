package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.print(this.food);
        System.out.println(this.name);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are cat's food.");
        Cat gav = new Cat();
        gav.name = "Gav";
        gav.eat("kotleta - ");
        gav.show();
        System.out.println("There are cat's food.");
        Cat black = new Cat();
        black.name = "cat without name";
        black.eat("fish - ");
        black.show();
    }
}
