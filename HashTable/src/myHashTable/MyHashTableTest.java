package myHashTable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test(expected = NullPointerException.class)
    public void hashCodeFromNullRest() {
        table1.add(null);
    }

    @Test
    public void sizeTest() {
        table1.add(3);
        table1.add(33);

        assertEquals(table1.size(), 2);
    }

    @Test
    public void isEmptyTest() {
        assertEquals(table1.size(), 0);
    }

    @Test
    public void trueContainsTest() {
        table1.add(3);

        assertTrue(table1.contains(3));
    }

    @Test
    public void falseContainsTest() {
        table1.add(3);

        assertFalse(table1.contains(4));
    }

    @Test(expected = NullPointerException.class)
    public void containsNpeExceptionTest() {
        table2.add(null);
        assertTrue(table2.contains(null));
    }

    @SuppressWarnings("all")
    @Test(expected = IllegalArgumentException.class)
    public void false2ContainsTest() {
        MyHashTable<Integer> table3 = new MyHashTable<>();

        assertTrue(table3.contains(3));
    }

    @Test
    public void iterator() {
    }

    @Test
    public void toArray() {
        table1.add(0);
        table1.add(1);
        table1.add(2);
        table1.add(3);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        Object[] hashToArray = table1.toArray();

        Assert.assertEquals(list, hashToArray[0]);
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

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        table1.add(null);
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

    @Test(expected = NullPointerException.class)
    public void removeNullTest() {
        table3.remove(null);
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void clear() {
    }
}