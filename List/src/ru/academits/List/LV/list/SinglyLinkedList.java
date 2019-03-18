package ru.academits.List.LV.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

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
        checkEmptyList();
        return head.getData();
    }

    public void addByIndex(T data, int index) {
        checkElementIndex(index);

        if (index == 0) {
            addToTop(data);
            return;
        }

        ListItem<T> temp = getItemByIndex(index - 1);

        if (index == size) {
            temp.setNext(new ListItem<>(data, null));
        } else {
            temp.setNext(new ListItem<>(data, temp.getNext()));
            size++;
        }
    }

    public void addToTop(T data) {
        head = new ListItem<>(data, head);
        size++;
    }

    public T setByIndex(int index, T data) {
        checkElementIndex(index);

        ListItem<T> temp = getItemByIndex(index);
        T oldTemp = temp.getData();
        temp.setValue(data);

        return oldTemp;
    }

    public T getByIndex(int index) {
        return getItemByIndex(index).getData();
    }

    public void removeByIndex(int index) {
        checkElementIndex(index);

        if (index == 0) {
            removeFirstElement();
            return;
        }

        ListItem<T> temp = getItemByIndex(index - 1);
        ListItem<T> temp1 = temp.getNext();
        temp.setNext(temp1.getNext());
        size--;
    }

    public T removeFirstElement() {
        checkEmptyList();

        T temp = head.getData();
        head = head.getNext();
        size--;

        return temp;
    }

    public boolean removeNodeByData(T data) {
        int counter = 0;

        for (ListItem<T> temp = head; temp != null; temp = temp.getNext(), counter++) {
            if (Objects.equals(temp.getData(), data)) {
                removeByIndex(counter);
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
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        if (head == null) {
            return newList;
        }

        newList.head = new ListItem<>(head.getData());
        ListItem<T> copyResult = newList.head;

        for (ListItem<T> originItem = head.getNext(); originItem != null; originItem = originItem.getNext()) {
            ListItem<T> temp = new ListItem<>(originItem.getData());

            copyResult.setNext(temp);
            copyResult = temp;
        }

        newList.size = this.getSize();
        return newList;
    }

    private void checkElementIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Check index. Index out of bounds.");
        }
    }

    private void checkEmptyList() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    //counter by index
    private ListItem<T> getItemByIndex(int index) {
        checkElementIndex(index);

        ListItem<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }
}


