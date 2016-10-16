package validator;

import domain.Job;
import exception.JobException;

import java.util.Arrays;

/**
 * Created by claudiu on 12.10.2016.
 */
public class JobValidator {
    private String[] types = new String[]{"full time", "part time"};
    public void validate(Job job) throws JobException {
        if (job.getName().isEmpty()) {
            throw new JobException("Name can't be empty!");
        }

        if (job.getType().isEmpty()) {
            throw new JobException("Type can't be empty!");
        }

        int a = Arrays.binarySearch(this.types, job.getType().toString());
        if (a > 1) {
            throw new JobException("Type can't be " + job.getType() + " !");
        }

    }
}
