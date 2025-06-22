package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.event.RegisterEvent;

@RestController
public class LoginController {

   @Autowired
    private ApplicationContext context;

    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Autowired
    private ApplicationEventPublisher  applicationEventPublisher;

    @GetMapping("register/user")
    public String register(String user) {
        System.out.println("用户注册：" + user);
        applicationEventPublisher.publishEvent(new RegisterEvent(user));
       return "ok";
    }
}