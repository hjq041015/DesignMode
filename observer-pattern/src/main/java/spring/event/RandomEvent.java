package spring.event;

import org.springframework.context.ApplicationEvent;

public class RandomEvent extends ApplicationEvent {

    public RandomEvent(Object source) {
        super(source);
    }
}