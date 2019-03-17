package ru.academits.List.LV.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    //constructor is empty for using by default.
    public SinglyLinkedList() {
    }

    private SinglyLinkedList(T data) {
        this.head = new ListItem<>(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            sb.append(temp.getData());

            if (temp.getNext() != null) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }

        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public T getFirstElement() {
        checkList();
        return head.getData();
    }

    public void addByIndex(T data, int index) {
        checkElementIndex(index);

        if (index == 0) {
            addToTop(data);
            return;
        }

        ListItem<T> temp = getDataByIndex(index - 1);
        temp.setNext(new ListItem<>(data, temp.getNext()));
        size++;
    }

    public void addToTop(T data) {
        head = new ListItem<>(data, head);
        size++;
    }

    public T setByIndex(int index, T data) {
        checkElementIndex(index);

        ListItem<T> temp = getDataByIndex(index);
        T oldTemp = temp.getData();
        temp.setValue(data);

        return oldTemp;
    }

    public T getByIndex(int index) {
        return getDataByIndex(index).getData();
    }

    public void removeByIndex(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.getNext();
            checkList();
            size--;
            return;
        }

        ListItem<T> temp = getDataByIndex(index - 1);
        ListItem<T> temp1 = temp.getNext();
        temp.setNext(temp1.getNext());
        size--;
    }

    public T removeFirstElement() {
        checkList();

        T temp = head.getData();
        head = head.getNext();
        size--;

        return temp;
    }

    public boolean removeNodeByData(T data) {
        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (temp.getNext() != null && Objects.equals(temp.getNext().getData(), data)) {
                temp.setNext(temp.getNext().getNext());
                size--;

                return true;
            }
        }
        
        return false;
    }

    public void reverse() {
        ListItem<T> temp1 = null;
        ListItem<T> temp2;

        for (ListItem<T> temp3 = head; temp3 != null; temp3 = temp2) {
            temp2 = temp3.getNext();

            if (temp3 == head) {
                temp3.setNext(null);
                temp1 = temp3;
            } else {
                temp3.setNext(temp1);
                temp1 = temp3;
            }

            head = temp1;
        }
    }

    public SinglyLinkedList<T> copyList() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>(head.getData());
        ListItem<T> temp1 = newList.head;

        for (ListItem<T> temp2 = head.getNext(); temp2 != null; temp2 = temp2.getNext()) {
            ListItem<T> temp3 = new ListItem<>(temp2.getData());

            temp1.setNext(temp3);
            temp1 = temp3;
        }

        newList.size = this.getSize();
        return newList;
    }

    private void checkElementIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Check index. Index out of bounds.");
        }
    }

    private void checkList() {
        if (head == null || size == 0) {
            throw new NoSuchElementException("List is empty");
        }
    }

    //counter by index
    private ListItem<T> getDataByIndex(int index) {
        checkElementIndex(index);

        ListItem<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }
}


