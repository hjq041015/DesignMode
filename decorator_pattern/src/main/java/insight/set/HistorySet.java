package insight.set;

import java.util.*;

/**
 * 装饰器模式实现的历史集合类
 * 核心是在原本对象的基础上,对方法进行增强而不改变原本对象的结构
 */

public class HistorySet<E> implements Set<E> {

    private final Set<E> dalegate;

    public HistorySet(Set<E> hashSet) {
        this.dalegate = hashSet;
    }

    List<E> removedElements = new ArrayList<>();

    @Override
    public int size() {
        return dalegate.size();
    }

    @Override
    public boolean isEmpty() {
        return dalegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return dalegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return dalegate.iterator();
    }

    @Override
    public Object[] toArray() {
        return dalegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return dalegate.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return dalegate.add((e));
    }

    @Override
    public boolean remove(Object o) {
        if (dalegate.remove(o)) {
            removedElements.add((E) o);
            return true;
        }
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return dalegate.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return dalegate.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return dalegate.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return dalegate.removeAll(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return dalegate.toString() + " Removed elements: " + removedElements;

    }
}
