package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void repeatAdd() {
        Citizen citizenOne = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenTwo = new Citizen("387131", "Ivan Petrov");
        Citizen citizenThree = new Citizen("387131", "Usama Ben Laden");
        PassportOffice office = new PassportOffice();
        office.add(citizenOne);
        office.add(citizenTwo);
        assertFalse(office.add(citizenThree));
    }
}
