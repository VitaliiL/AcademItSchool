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
            throw new IllegalArgumentException("Hash table is empty.");
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

    public int getCapacity() {
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
            throw new IllegalArgumentException("Hash table is empty.");
        }

        int i = getIndex(o);
        return table[i] != null && table[i].contains(o);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(table, table.length);
    }

    @SuppressWarnings("all")
    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(table, size, a.getClass());
        }

        System.arraycopy(table, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    int getIndex(Object o) {
        if (o == null) {
            throw new NullPointerException("Object is null. Check data to add.");
        }

        return Math.abs(o.hashCode() % table.length);
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

        if (contains(o)) {
            table[i].remove(o);
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
        if (c == null) {
            throw new NullPointerException("Argument is null. Check data.");
        }

        if (c.size() == 0) {
            return false;
        }

        for (E element : c) {
            add(element);
        }

        return true;
    }

    @SuppressWarnings("all")
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Argument is null. Check data.");
        }

        boolean modified = false;
        int newSize = 0;

        for (ArrayList<E> e : table) {
            if (e != null) {
                e.removeAll(c);
                newSize += e.size();
            }
        }

        if (size != newSize) {
            size = newSize;
            modified = true;
        }

        modCount = modCount + (size - newSize);

        return modified;
    }

    @SuppressWarnings("all")
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Argument is null. Check data.");
        }

        boolean modified = false;
        int newSize = 0;

        for (ArrayList<E> e : table) {
            if (e != null) {
                e.retainAll(c);
                newSize += e.size();
            }
        }

        if (size != newSize) {
            size = newSize;
            modified = true;
        }

        modCount = modCount + (size - newSize);

        return modified;
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
        private int currentHash = 0;
        private int currentIndex = -1;
        private int modCountForIterator = modCount;
        private int counter = 0;

        private MyIterator() {
            while (table[currentHash] == null) {
                currentHash++;
            }
        }

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

            if (currentIndex < table[currentHash].size() - 1) {
                ++currentIndex;
            } else {
                currentHash++;

                while (table[currentHash] == null) {
                    currentHash++;
                }
                currentIndex = 0;
            }
            counter++;

            return table[currentHash].get(currentIndex);
        }
    }
}