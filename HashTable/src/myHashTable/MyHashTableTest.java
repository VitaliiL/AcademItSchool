package myHashTable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MyHashTableTest {
    private static final int DEFAULT_CAPACITY = 10;
    private MyHashTable<Integer> table1;
    private MyHashTable<Integer> table2;
    private MyHashTable<Integer> table3;

    @Before
    public void createNewTableAndSetSizeViaConstructor() {
        table1 = new MyHashTable<>();
        table2 = new MyHashTable<>(20);

        table3 = new MyHashTable<>();
        table3.add(1);
        table3.add(2);
        table3.add(3);
    }

    @Test
    public void firstConstructorTest() {
        assertEquals(table1.getCapacity(), 10);
    }

    @Test
    public void first2ConstructorTest() {
        assertNotNull(table1);
    }

    @Test
    public void secondConstructorTest() {
        assertEquals(table2.getCapacity(), 20);
    }

    @Test
    public void second2ConstructorTest() {
        assertNotNull(table2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void capacityExceptionTest() {
        table2 = new MyHashTable<>(0);
    }

    @Test
    public void sizeTest() {
        table1.add(3);
        table1.add(33);

        assertEquals(table1.size(), 2);
    }

    @Test
    public void isEmptyTest() {
        assertEquals(0, table1.size());
        assertTrue(table1.isEmpty());
    }

    @Test
    public void trueContainsTest() {
        assertTrue(table3.contains(3));
    }

    @Test
    public void falseContainsTest() {
        assertFalse(table3.contains(4));
    }

    @Test
    public void containsNullTest() {
        table3.add(null);
        assertTrue(table3.contains(null));
    }

    @Test
    public void toArrayTest() {
        table1.add(0);
        table1.add(1);
        table1.add(2);
        table1.add(null);

        Object[] hashToArray = table1.toArray();

        assertEquals(4, table1.size());
        assertEquals(0, hashToArray[0]);
        assertNull(hashToArray[1]);
        assertEquals(1, hashToArray[2]);
        assertEquals(2, hashToArray[3]);
    }

    @Test
    public void toArray() {
        assertEquals(0, table1.toArray().length);
    }

    @Test
    public void addViaContainsTest() {
        table1.add(2);

        assertTrue(table1.contains(2));
    }

    @Test
    public void addTest() {
        table1.add(2);

        assertEquals(table1.getIndex(2), 2);
    }

    @Test
    public void addTestNull() {
        table1.add(null);
        table1.add(null);

        assertEquals(2, table1.size());
    }

    @Test
    public void removeTest() {
        table3.remove(3);

        assertEquals(2, table3.size());
        assertFalse(table3.contains(3));
    }

    @Test
    public void removeNotExistingObjectTest() {
        assertFalse(table3.remove(4));
        assertEquals(3, table3.size());
        assertFalse(table3.contains(4));

    }

    @Test
    public void removeNullTest() {
        table3.add(null);
        assertTrue(table3.remove(null));
    }

    @Test
    public void containsAllTrueTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);

        assertTrue(table3.containsAll(list));
    }

    @Test
    public void containsAllFalseTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        assertFalse(table3.containsAll(list));
    }

    @Test
    public void addAllTrueTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        assertTrue(table3.addAll(list));
        assertEquals(5, table3.size());
    }

    @SuppressWarnings("all")
    @Test
    public void addAllFalseTest() {
        ArrayList<Integer> list = new ArrayList<>();

        assertFalse(table3.addAll(list));
        assertEquals(3, table3.size());
    }

    @Test(expected = NullPointerException.class)
    public void addAllExceptionTest() {
        table3.addAll(null);
    }

    @Test
    public void removeAllTrueTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);

        assertTrue(table3.removeAll(list));
        assertEquals(1, table3.size());
    }

    @Test
    public void removeAllFalseTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        assertFalse(table3.removeAll(list));
        assertEquals(3, table3.size());
    }

    @Test(expected = NullPointerException.class)
    public void removeAllExceptionTest() {
        table3.removeAll(null);
    }

    @Test
    public void retainAllTrueTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        assertTrue(table3.retainAll(list));
        assertEquals(2, table3.size());
        assertFalse(table3.contains(3));
    }

    @Test
    public void retainAllTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        table3.retainAll(list);
        assertEquals(0, table3.size());
    }

    @Test(expected = NullPointerException.class)
    public void retainAllExceptionTest() {
        table3.retainAll(null);
    }

    @Test
    public void clear() {
        table3.clear();
        assertEquals(0, table3.size());
    }

    @Test
    public void iteratorTest() {
        table1.add(1);
        table1.add(2);
        table1.add(3);

        Iterator<Integer> iterator = table1.iterator();
        StringBuilder sb = new StringBuilder();

        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(",");
        }
        sb.setLength(sb.length() - 1);

        Assert.assertEquals(sb.toString(), "1,2,3");
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNoSuchElementExceptionTest() {
        table1.add(5);

        Iterator<Integer> iterator = table1.iterator();
        iterator.next();
        iterator.next();
    }
}