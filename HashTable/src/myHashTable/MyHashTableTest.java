package myHashTable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {
    private MyHashTable<Integer> table1;
    private static final int DEFAULT_CAPACITY = 10;
    private MyHashTable<Integer> table2;
    //private MyHashTable<Integer> table3;

    @Before
    public void createNewTableAndSetSizeViaConstructor() {
        table1 = new MyHashTable<>();
        table2 = new MyHashTable<>(20);
        //table3 = new MyHashTable<>();
    }

    @Test
    public void firstConstructorTest() {
        Assert.assertEquals(table1.getCapacity(), 10);
    }

    @Test
    public void secondConstructorTest() {
        Assert.assertEquals(table2.getCapacity(), 20);
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

        Assert.assertEquals(table1.size(), 2);
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(table1.size(), 0);
    }

    @Test
    public void trueContainsTest() {
        table1.add(3);

        Assert.assertTrue(table1.contains(3));
    }

    @Test
    public void falseContainsTest() {
        table1.add(3);

        Assert.assertFalse(table1.contains(4));
    }

    @Test (expected = NullPointerException.class)
    public void containsNpeExceptionTest() {
        Assert.assertTrue(table2.contains(null));
    }

    @SuppressWarnings("all")
    @Test (expected = IllegalArgumentException.class)
    public void false2ContainsTest() {
        MyHashTable<Integer> table3 = new MyHashTable<>();

        Assert.assertTrue(table3.contains(3));
    }

    @Test
    public void iterator() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void toArray1() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
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