package demo;

public abstract class BaseEvent implements Event {

    private final long timestamp;

    protected BaseEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public long timestamp() {
        return timestamp;
    }

    public abstract Object source();
}