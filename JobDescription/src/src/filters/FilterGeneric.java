package filters;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by claudiu on 11.11.2016.
 */
public class FilterGeneric {
    public static <E> List<E> filter(List<E> list, Predicate<E> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static <E> List<E> filterAndSort(List<E> list, Predicate<E> predicate, Comparator<E> comparator) {
        return list.stream()
                .filter(predicate)
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
