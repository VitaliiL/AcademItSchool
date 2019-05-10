package myHashTable;

import java.util.*;

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
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (ArrayList<E> element : table) {
            if (element != null) {
                sb.append(element).append(", ");
            }
        }
        sb.setLength(sb.length() - 2);

        return sb.append("}").toString();
    }

     int getCapacity() {
        return table.length;
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
        if (size == 0) {
            return false;
        }

        int i = getIndex(o);
        return table[i] != null && table[i].contains(o);
    }

    @Override
    public Object[] toArray() {
        if (size == 0) {
            return new Object[0];
        }

        Object[] array = new Object[size];
        int i = 0;

        for (E element : this) {
            array[i] = element;
            i++;
        }

        return array;
    }

    @SuppressWarnings("all")
    @Override
    public <E> E[] toArray(E[] a) {
        if (a == null) {
            throw new NullPointerException("Argument is null. Check data.");
        }

        if (a.length < size) {
            return (E[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    int getIndex(Object o) {
        return Math.abs(Objects.hashCode(o) % table.length);
    }

    @Override
    public boolean add(E e) {
        int i = getIndex(e);

        if (table[i] == null) {
            table[i] = new ArrayList<>();
        }

        table[i].add(e);
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = getIndex(o);

        if (table[i] == null) {
            return false;
        }

        if (table[i].remove(o)) {
            size--;
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

    @SuppressWarnings("all")
    @Override
    public boolean addAll(Collection<? extends E> c) {
        checkArgumentNull(c);

        if (c.size() == 0) {
            return false;
        }

        for (E element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkArgumentNull(c);

        int newSize = 0;

        for (ArrayList<E> e : table) {
            if (e != null) {
                e.removeAll(c);
                newSize += e.size();
            }
        }

        if (size != newSize) {
            size = newSize;
            modCount++;

            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        checkArgumentNull(c);

        int newSize = 0;

        for (ArrayList<E> e : table) {
            if (e != null) {
                e.retainAll(c);
                newSize += e.size();
            }
        }

        if (size != newSize) {
            size = newSize;
            modCount++;

            return true;
        }

        return false;
    }

    private static void checkArgumentNull(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Argument is null. Check data.");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }

        size = 0;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int currentHashIndex = 0;
        private int currentIndex = -1;
        private int counter = 0;
        private int modCountForIterator = modCount;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element.");
            }

            if (modCount != modCountForIterator) {
                throw new ConcurrentModificationException("Collection was changed.");
            }

            while (true) {
                if (table[currentHashIndex] == null) {
                    currentHashIndex++;
                    continue;
                }

                if (currentIndex < table[currentHashIndex].size() - 1) {
                    currentIndex++;
                    counter++;

                    return table[currentHashIndex].get(currentIndex);
                } else {
                    currentHashIndex++;
                    currentIndex = -1;
                }
            }
        }
    }
}