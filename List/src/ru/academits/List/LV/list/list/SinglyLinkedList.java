package ru.academits.List.LV.list.list;

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
        return head.getData();
    }

    private ListItem<T> getHead() {
        return head;
    }

    public void addByIndex(int index, T data) {
        checkElementIndex(index);

        if (index == 0) {
            addToTop(data);
            return;
        }

        int currentIndex = 0;

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (isEqualIndex(currentIndex, index)) {
                ListItem<T> newList = new ListItem<>(data, temp.getNext());
                temp.setNext(newList);
                size++;

                return;
            } else {
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

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (isEqualIndex(currentIndex, index)) {
                ListItem<T> newList = temp.getNext();
                newList.setValue(data);

                return;
            } else {
                currentIndex++;
            }
        }
    }

    public T getByIndex(int index) {
        checkElementIndex(index);
        checkList();

        int currentIndex = 0;

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (currentIndex == index) {
                return temp.getData();
            } else {
                currentIndex++;
            }
        }

        throw new IllegalArgumentException("The index isn't correct");
    }

    public void removeByIndex(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.getNext();
            checkList();
            size--;
            return;
        }

        int currentIndex = 0;

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (isEqualIndex(currentIndex, index)) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {

                currentIndex++;
            }
        }
    }

    public T removeFirstElement() {
        T temp = head.getData();
        head = head.getNext();
        checkList();
        size--;

        return temp;
    }

    public boolean removeNodeByData(T data) {
        boolean isCheck = false;

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext()) {
            if (temp.getNext() != null && Objects.equals(temp.getNext().getData(), data)) {
                temp.setNext(temp.getNext().getNext());
                size--;
                isCheck = true;
            }
        }

        if (!isCheck) {
            throw new IllegalArgumentException("The data isn't existing in the list.");
        }

        return true;
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
        ListItem<T> temp1 = newList.getHead();

        for (ListItem<T> temp2 = head.getNext(); temp2 != null; temp2 = temp2.getNext()) {
            ListItem<T> temp3 = new ListItem<>(temp2.getData());

            temp1.setNext(temp3);
            temp1 = temp3;
        }

        newList.size = this.getSize();
        return newList;
    }

    private void checkElementIndex(int index) {
        if (index < 0 && index >= size)
            throw new IndexOutOfBoundsException("Check index. Index out of bounds.");
    }

    private void checkList() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    private boolean isEqualIndex(int currentIndex, int index) {
        return currentIndex == index - 1;
    }
}


