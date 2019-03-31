package ru.academits.ArrayList.LV.arrayList;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] items;
    private int size;
    private int modCount;

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(items, size));
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity isn't corrected" + capacity);
        }

        items = new Object[capacity];
    }

    public MyArrayList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @SuppressWarnings("all")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(items, size);
        }

        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E element) {
        if (element != null) {
            items[size] = element;
            size++;

            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            --size;
            modCount++;

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        Object[] array = c.toArray();
        if (items.length < size + array.length) {
            items = Arrays.copyOf(items, items.length + array.length);
        }
        if (size - index > 0) {
            System.arraycopy(items, index, items, index + array.length, size - index);
        }

        System.arraycopy(array, 0, items, index, array.length);
        size += array.length;

        if (array.length != 0) {
            modCount++;
        }

        return array.length != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; ++i) {
            if (c.contains(items[i])) {
                remove(i);
                --i;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; ++i) {
            if (!c.contains(items[i])) {
                remove(i);
                --i;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        if (items.length <= size) {
            increaseCapacity();
        }

        items[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E item = getItem(index);

        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index isn't corrected.");
        }

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        --size;

        return item;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int userSize) {
        if (userSize > items.length) {
            items = Arrays.copyOf(items, userSize);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int mod = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (currentIndex == size) {
                throw new NoSuchElementException("Collection is finished.");
            }

            if (mod != modCount) {
                throw new ConcurrentModificationException("Collection is changed.");
            }

            ++currentIndex;

            return getItem(currentIndex);
        }
    }


    //no need:
    @SuppressWarnings("all")
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @SuppressWarnings("all")
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @SuppressWarnings("all")
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
