package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.event.RandomEvent;

@SpringBootApplication
@ComponentScan(basePackages = {"spring"})
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        context.publishEvent(new RandomEvent("初始化成功"));
    }
    }