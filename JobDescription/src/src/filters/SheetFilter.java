package filters;

import domain.Sheet;
import domain.Task;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by claudiu on 11.11.2016.
 */
public class SheetFilter extends FilterGeneric {

    public static List<Sheet> filterByTypeAndDescriptionDesc(List<Sheet> sheets) {
        Predicate<Sheet> predicate = sheet -> sheet.getJob().getType().equals("full time");
        Comparator<Sheet> comparator = (sheet1, sheet2) -> {
            return sheet2.getTask().getDescription().compareTo(sheet1.getTask().getDescription());
        };

        return FilterGeneric.filterAndSort(sheets, predicate, comparator);
    }
}
