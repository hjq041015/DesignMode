package insight.validation;

import insight.excption.ValidatorException;

import java.util.ArrayList;
import java.util.List;

public class ValidatorContext {
    private final List<String> errorMessages = new ArrayList<>();

    private boolean stop = false;

    private int index = 0;

    private Object value;

    public ValidatorContext(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void addErrorMessage(String message) {
        errorMessages.add(message);
    }

    public void stop() {
        this.stop = true;
    }

    public boolean isStop() {
        return stop;
    }

    public void doNext() {
        index++;
    }

    public int currentIndex() {
        return index;
    }


    public void throwExceptionIfNecessary() throws ValidatorException {
        if (errorMessages.isEmpty()) {
            return;
        }
        throw new ValidatorException(errorMessages.toString());
    }



}