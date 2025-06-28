package insight;

import insight.validation.Validator;

public class Main {
    public static void main(String[] args) throws Exception {
        User tom = new User("tome",17);
        Validator validator = new Validator();
        validator.validate(tom);
    }
}