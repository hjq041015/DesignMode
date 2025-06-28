package insight.validation;

import insight.excption.ValidatorException;

public class MaxValidatorHandler implements ValidatorHandler{

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }


    @Override
    public void validate(Object value, ValidatorContext context) throws ValidatorException {
        if (value instanceof Integer intValue) {
            if (intValue > max) {
                context.addErrorMessage("你的值" + intValue + "超过了最大值" + max);
                context.stop();
            }
        }
    }
}