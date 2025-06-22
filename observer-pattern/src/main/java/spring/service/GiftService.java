package spring.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import spring.event.RegisterEvent;

@Service
public class GiftService {

    @EventListener
    public void onRegisterEvent(RegisterEvent registerEvent) {
        String user = registerEvent.getUser();
        System.out.println("给"+ user + "发送礼物");
    }
}