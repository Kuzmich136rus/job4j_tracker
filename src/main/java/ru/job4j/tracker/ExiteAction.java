package ru.job4j.tracker;

public class ExiteAction implements UserAction {
    @Override
    public String name() {
        return "Exit menu";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
