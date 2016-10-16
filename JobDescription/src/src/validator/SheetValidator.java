package validator;

import domain.Sheet;
import exception.SheetException;

/**
 * Created by claudiu on 16.10.2016.
 */
public class SheetValidator implements Validator<Sheet, SheetException> {
    public void validate(Sheet sheet) throws SheetException {
        if (sheet.getJobId() < 1) {
            throw new SheetException("Invalid job id!");
        }
        if (sheet.getTaskId() < 1) {
            throw new SheetException("Invalid task id!");
        }
    }
}
