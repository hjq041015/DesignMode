package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvStation {

    private final Map<Class<? extends Event>, List<EventListener>> listenersMap = new HashMap<>();

    public void subscribe(EventListener listener, Class<? extends Event> eventClass) {
        listenersMap.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(listener);

    }

    public void publish(Event event) {
        Class<? extends Event> eventClass = event.getClass();
        List<EventListener> listeners = listenersMap.get(eventClass);
        if (listeners != null) {
            listeners.forEach(listener ->  listener.onEvent(event));
        }
    }
}