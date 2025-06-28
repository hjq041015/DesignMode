package insight.validation;

import insight.excption.ValidatorException;

public class MinValidatorHandler implements ValidatorHandler{

    private final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }


    @Override
    public void validate(Object value, ValidatorContext context) throws ValidatorException {
        if (value instanceof Integer intValue) {
            if (intValue < min) {
                context.addErrorMessage("你的值" + intValue + "小于最小值" + min);
            }
        }
    }
}