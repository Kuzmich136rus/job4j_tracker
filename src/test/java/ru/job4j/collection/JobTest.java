package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorDecrByName() {
        Comparator<Job> cmpDecrName = new JobDecrByName();
        int rsl = cmpDecrName.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 1)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDecrByPriority() {
        Comparator<Job> cmpDecrPriority = new JobDecrByPriority();
        int rsl = cmpDecrPriority.compare(
                new Job("Important task", 4),
                new Job("Not Important task", 9)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorIncByName() {
        Comparator<Job> cmpIncName = new JobIncByName();
        int rsl = cmpIncName.compare(
                new Job("Def", 0),
                new Job("Abc", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorIncByPriority() {
        Comparator<Job> cmpIncPriority = new JobIncByPriority();
        int rsl = cmpIncPriority.compare(
                new Job("Task12", 4),
                new Job("Task35", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDecrByName().thenComparing(new JobDecrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByIncNameAndDecrPriority() {
        Comparator<Job> cmpNamePriority = new JobIncByName().thenComparing(new JobDecrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Hard task", 2),
                new Job("Hard task", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whentaskAndPriorityEqualse() {
        Comparator<Job> cmpNamePriority = new JobIncByName().thenComparing(new JobDecrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Test task", 1),
                new Job("Test task", 1)
        );
        assertThat(rsl, equalTo(0));
    }
}