package ru.academits.List.LV.list.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public int getSize() {
        return size;
    }

    public T getFirstElement() {
        return getByIndex(0);
    }

    public void addByIndex(int index, T value) {
        if (index == 0) {
            addToTop(value);

            return;
        }

        int currentIndex = 0;
        ListItem<T> temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                ListItem<T> newElement = new ListItem<T>(value, temp.getNext());
                temp.setNext(newElement);
                size++;

                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public void addToTop(T value) {
        head = new ListItem<T>(value, head);

        size++;
    }

    public void setByIndex(int index, T element){

            //checkElementIndex(index);



    }

    public T getByIndex(int index) {
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

    public T removeFirstElement(){
        T temp = head.getData();
        head = head.getNext();

        size --;

        return temp;
    }

    private static class ListItem<T> {
        T data;
        ListItem<T> next;

        private ListItem(T data) {
            this.data = data;
        }

        private ListItem(T data, ListItem<T> next) {
            this.data = data;
            this.next = next;
        }

        T getData() {
            if (data == null) {
                throw new NullPointerException("Data is empty");
            }

            return data;
        }

        void setValue(T data) {
            this.data = data;
        }

        ListItem<T> getNext() {
            return next;
        }

        void setNext(ListItem<T> next) {
            this.next = next;
        }
    }
}


//private boolean isElementIndex(int index) {
//    return index >= 0 && index < size;
//}

// private boolean isPositionIndex(int index) {
//     return index >= 0 && index <= size;
// }
//
// private void checkElementIndex(int index) {
//     if (!isElementIndex(index))
//         throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
// }
//
// private void checkPositionIndex(int index) {
//     if (!isPositionIndex(index))
//         throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
// }