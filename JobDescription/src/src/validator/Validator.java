package validator;

import domain.Entity;

/**
 * Created by claudiu on 16.10.2016.
 */
public interface Validator<GenericType> {
    void validate(GenericType item) throws Exception;
}
