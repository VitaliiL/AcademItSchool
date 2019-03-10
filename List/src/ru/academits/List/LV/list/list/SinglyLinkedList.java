package ru.academits.List.LV.list.list;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    @Override
    public String toString() {
        Object[] result = new Object[size];

        int idx = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            result[idx++] = temp.getData();
            temp = temp.getNext();

        }

        return Arrays.toString(result);
    }

    private void checkElementIndex(int index) {
        if (index < 0 && index >= size)
            throw new IndexOutOfBoundsException("Check index. Index out of bounds.");
    }

    public int getSize() {
        return size;
    }

    public T getFirstElement() {
        return getByIndex(0);
    }

    public void addByIndex(int index, T data) {
        checkElementIndex(index);

        if (index == 0) {
            addToTop(data);

            return;
        }

        int currentIndex = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                ListItem<T> newList = new ListItem<>(data, temp.getNext());
                temp.setNext(newList);
                size++;

                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public void addToTop(T data) {
        head = new ListItem<>(data, head);

        size++;
    }

    public void setByIndex(int index, T data) {
        checkElementIndex(index);

        int currentIndex = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                ListItem<T> newList = temp.getNext();
                newList.setValue(data);

                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public T getByIndex(int index) {
        checkElementIndex(index);

        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        int currentIndex = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getData();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException("The index isn't correct");
    }

    public void removeByIndex(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.getNext();
            size--;

            return;
        }

        int currentIndex = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;

                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public T removeFirstElement() {
        T temp = head.getData();
        head = head.getNext();

        size--;

        return temp;
    }

    public boolean removeNodeByData(T data) {
        ListItem<T> temp = head;
        boolean isCheck = false;

        while (temp != null) {
            if (temp.getNext() != null && Objects.equals(temp.getNext().getData(), data)) {
                temp.setNext(temp.getNext().getNext());
                size--;
                isCheck = true;
            } else {
                temp = temp.getNext();
            }
        }

        if (!isCheck) {
            throw new IllegalArgumentException("The data isn't existing in the list.");
        }

        return true;
    }

    private static class ListItem<T> {
        T data;
        ListItem<T> next;

        private ListItem(T data, ListItem<T> next) {
            this.data = data;
            this.next = next;
        }

        private T getData() {
            if (data == null) {
                throw new NullPointerException("Data is empty");
            }

            return data;
        }

        private void setValue(T data) {
            this.data = data;
        }

        private ListItem<T> getNext() {
            return next;
        }

        private void setNext(ListItem<T> next) {
            this.next = next;
        }
    }
}


