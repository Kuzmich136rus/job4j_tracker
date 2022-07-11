package ru.job4j.tracker;

public class ExiteAction implements UserAction {
    private final Output out;

    public ExiteAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit program ===");
        return false;
    }
}
