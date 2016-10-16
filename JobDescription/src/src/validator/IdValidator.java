package validator;

import domain.Entity;
import exception.IdValidatorException;

/**
 * Created by claudiu on 16.10.2016.
 */
public class IdValidator {
    public void validate(int id, int lastId) throws IdValidatorException {
        if (id > lastId) {
            throw new IdValidatorException("This id dosen't exist");
        }
    }
}
