package insight;


import insight.annotation.Length;
import insight.annotation.Max;
import insight.annotation.Min;

public class User {
    @Length(4)
    private final String name;

    @Max(100)
    @Min(1)
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}