package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker onlyOneObj = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getOnlyOneObj() {
        if (onlyOneObj == null) {
            onlyOneObj = new SingleTracker();
        }
        return onlyOneObj;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);

    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
