package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFined() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Nikita", "Shcherbakov", "1153051", "Voronezh")
        );
        ArrayList<Person> persons = phone.find("msk");
        assertTrue(persons.isEmpty());
    }
}