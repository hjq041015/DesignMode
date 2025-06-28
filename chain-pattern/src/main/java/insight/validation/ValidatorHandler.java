package insight.validation;

import insight.excption.ValidatorException;

public interface ValidatorHandler {
    void validate(Object value, ValidatorContext context) throws ValidatorException;
}