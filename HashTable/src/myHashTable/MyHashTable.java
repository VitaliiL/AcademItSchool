package myHashTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyHashTable<E> implements Collection<E> {
    private ArrayList<E>[] table;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int modCount;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        table = new ArrayList[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity isn't correct " + capacity);
        }

        table = new ArrayList[capacity];
    }

    @Override
    public int size() {
        return table.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
