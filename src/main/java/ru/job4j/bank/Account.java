package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель, которая описывает банковский счет.
 * Эта модель содержит поля: реквизиты и баланс.
 * @author Nikita Shcherbakov
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Конструктор аккаунта.
     * @param requisite принимает на вход строчный параметр реквизиты и
     * @param balance числовой парметр баланс в формате числа с плавающей точкой
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттеры и сеттеры для доступа к полям.
     */
    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение методов equals и hashCode.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
