package insight.validation;

import insight.excption.ValidatorException;

public class LengthValidatorHandler implements ValidatorHandler{

    private final int Length;

    public LengthValidatorHandler(int length) {
        this.Length = length;
    }


    @Override
    public void validate(Object value, ValidatorContext context) throws ValidatorException {
        if (value instanceof String stringValue) {
            if (stringValue.length() != Length) {
                context.addErrorMessage("你的字符串长度"+ stringValue.length() + "不等于目标长度" + Length);
            }
        }
    }
}