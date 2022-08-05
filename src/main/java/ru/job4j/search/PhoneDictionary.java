package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> searchByName = person -> person.getName().equals(key);
        Predicate<Person> searchBySurname = person -> person.getSurname().equals(key);
        Predicate<Person> searchByPhone = person -> person.getPhone().equals(key);
        Predicate<Person> searchByAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine = searchByName.or(searchBySurname.or(
                searchByPhone.or(searchByAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
