package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pos : persons) {
            if (pos.getSurname().contains(key) || pos.getPhone().contains(key)
            || pos.getName().contains(key) || pos.getAddress().contains(key)) {
                result.add(pos);
            }
        }
        return result;
    }
}
