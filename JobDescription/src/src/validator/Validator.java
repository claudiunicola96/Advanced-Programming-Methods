package validator;

import domain.Entity;

/**
 * Created by claudiu on 16.10.2016.
 */
public interface Validator<GenericType, ExceptionType extends Throwable> {
    void validate(GenericType item) throws ExceptionType;
}
