package spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring.event.RandomEvent;

@Component
public class RandomEventListener {


    @EventListener
    public void doRandomEvent(RandomEvent event) {
        System.out.println(event.getSource());
    }

}