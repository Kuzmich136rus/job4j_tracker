package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель, которая описывает модель пользователя банка.
 * Эта модель содержит поля: паспортные данные и ФИО пользователя.
 * @author Nikita Shcherbakov
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор пользователя.
     * @param passport принимает на вход строчный параметр данных паспорта
     * @param username принимает на вход строчный параметр ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттеры и сеттеры для доступа к полям.
     */
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
