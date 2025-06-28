package insight.validation;

import insight.excption.ValidatorException;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {

    private final List<ValidatorHandler> validatorHandlers = new ArrayList<>();

    public void validate(Object value) throws ValidatorException {
        ValidatorContext context = new ValidatorContext(value);
        while (true) {
            int index = context.currentIndex();
            if (index == validatorHandlers.size()) {
                break;
            }
            ValidatorHandler handler = validatorHandlers.get(index);
            handler.validate(context.getValue(),context);
            if (index == context.currentIndex()) {
                break;
            }
        }

        context.throwExceptionIfNecessary();

    }

    public void addLastValidator(ValidatorHandler handler) {
        validatorHandlers.add(handler);
    }

}