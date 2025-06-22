package demo;

public interface Event {
    long timestamp();

    Object source();
}