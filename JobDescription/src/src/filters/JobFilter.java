package filters;

import domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by claudiu on 11.11.2016.
 */
public class JobFilter extends FilterGeneric {
    public static List<Job> getJobsByType(List<Job> jobs, String type) {
        Predicate<Job> fullTimePredicate = job -> job.getType().equals(type);
        return FilterGeneric.filter(jobs, fullTimePredicate);
    }
}
