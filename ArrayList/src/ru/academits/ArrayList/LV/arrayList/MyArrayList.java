package ru.academits.ArrayList.LV.arrayList;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private Object[] items;
    private int capacity;

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(items, capacity));
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity isn't corrected" + capacity);
        }

        items = new Object[capacity];
    }

    public MyArrayList() {
        items = new Object[10];
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
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
    public boolean addAll(int index, Collection<? extends E> c) {
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

    @SuppressWarnings("unchecked")
    private E getItem(int index) {
        return (E) items[index];
    }

    @Override
    public E get(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        return getItem(index);
    }

    @Override
    public E set(int index, E element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        E item = getItem(index);
        this.items[index] = element;

        return item;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public int getCapacity() {
        return items.length;
    }

    @Override
    public void add(int index, E element) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        if (items.length <= capacity) {
            increaseCapacity();
        }

        items[index] = element;
        capacity++;
    }

    @Override
    public E remove(int index) {
        E item = getItem(index);

        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        if (index < capacity - 1) {
            System.arraycopy(items, index + 1, items, index, capacity - index - 1);
        }
        --capacity;

        return item;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
