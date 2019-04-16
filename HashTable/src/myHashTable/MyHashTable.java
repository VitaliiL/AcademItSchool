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

    @SuppressWarnings("all")
    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            throw new IllegalArgumentException("Hash table is empty.");
        }

        int i = getIndex(o);
        return table[i] != null && table[i].contains(o);
    }

    //todo
    @Override
    public Iterator<E> iterator() {
        return null;
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
            throw new NullPointerException("Hash code from null. Check data to add.");
        }

        return Math.abs(o.hashCode() % table.length);
    }

    @SuppressWarnings("all")
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
