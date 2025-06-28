package insight.validation;

import insight.annotation.Length;
import insight.annotation.Max;
import insight.annotation.Min;

import java.lang.reflect.Field;

public class Validator {

    private ValidatorChain bulidValidatorChain(Field field) {
        ValidatorChain chain = new ValidatorChain();
        Max max = field.getAnnotation(Max.class);
           if (max != null) {
               chain.addLastValidator(new MaxValidatorHandler(max.value()));
           }
        Min min = field.getAnnotation(Min.class);
           if (min != null) {
               chain.addLastValidator(new MinValidatorHandler(min.value()));
           }
        Length length = field.getAnnotation(Length.class);
           if (length != null) {
               chain.addLastValidator(new LengthValidatorHandler(length.value()));
           }
        return chain;
    }


    public void validate(Object bean) throws Exception {
        Class<?> beanClass = bean.getClass();
       for (Field field : beanClass.getDeclaredFields()) {
          field.setAccessible(true);
          ValidatorChain chain = bulidValidatorChain(field);
          chain.validate(field.get(bean));
       }
    }
}