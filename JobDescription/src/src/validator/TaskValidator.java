package validator;

import domain.Task;
import exception.TaskException;

/**
 * Created by claudiu on 12.10.2016.
 */
public class TaskValidator implements Validator<Task, TaskException> {
    public void validate(Task task) throws TaskException {
        if (task.getDescription().isEmpty()) {
            throw new TaskException("Description can't be empty!");
        }
    }
}
