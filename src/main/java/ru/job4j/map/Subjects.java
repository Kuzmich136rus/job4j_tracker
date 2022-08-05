package ru.job4j.map;

import java.util.Objects;

public class Subjects {
    private String name;

    private int score;

    public Subjects(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subjects subjects = (Subjects) o;
        return score == subjects.score && Objects.equals(name, subjects.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
