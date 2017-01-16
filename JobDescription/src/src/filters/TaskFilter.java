package filters;

import domain.Task;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by claudiu on 11.11.2016.
 */
public class TaskFilter extends FilterGeneric {

    //    @TODO: validate if is just a letter
    public static List<Task> filterTasksByFirstLetter(List<Task> tasks, String letter) {
        Predicate<Task> predicate = task -> task.getDescription().startsWith(letter);
        Comparator<Task> comparator;
        comparator = (task1, task2) -> {
            return task1.getDescription().compareTo(task2.getDescription());
        };
        return FilterGeneric.filterAndSort(tasks, predicate, comparator);
    }
}
