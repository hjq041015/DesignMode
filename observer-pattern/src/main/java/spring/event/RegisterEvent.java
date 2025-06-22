package spring.event;

import org.springframework.context.ApplicationEvent;

public class RegisterEvent extends ApplicationEvent {

    public RegisterEvent(String user) {
        super(user);
    }

    public String getUser() {
        return getSource().toString();
    }
}