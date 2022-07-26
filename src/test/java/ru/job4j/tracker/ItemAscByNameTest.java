package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class ItemAscByNameTest {

    @Test
    public void whenAskByName() {
        List<Item> items = new ArrayList<>();
                items.add(new Item(123, "Juice"));
                items.add(new Item(321, "Games"));
                items.add(new Item(13, "Cars"));
        items.sort(new ItemAscByName());
        List<Item> expected = List.of(
                new Item(13, "Cars"),
                new Item(321, "Games"),
                new Item(123, "Juice")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenDeskByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(123, "Apples"));
        items.add(new Item(321, "Oranges"));
        items.add(new Item(13, "Chocolate"));
        items.sort(new ItemDescByName());
        List<Item> expected = List.of(
                new Item(321, "Oranges"),
                new Item(13, "Chocolate"),
                new Item(123, "Apples")
        );
        assertThat(items).isEqualTo(expected);
    }
}
