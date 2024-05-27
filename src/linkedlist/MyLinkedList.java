package linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

/*
add(Object value) додає елемент в кінець
remove(int index) видаляє елемент із вказаним індексом
clear() очищає колекцію
size() повертає розмір колекції
get(int index) повертає елемент за індексом
 */
public class MyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, Node<T> next, T value) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        if (head == null) {
            head = tail = new Node<>(null, null, value);
        } else {
            Node<T> node = new Node<>(tail, null, value);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        return getFromIndex(index).value;
    }

    private Node<T> getFromIndex(int index) {
        Objects.checkIndex(index, size);
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void remove(int index) {
        Node<T> toRemove = getFromIndex(index);
        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next;
        }
        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else {
            tail = toRemove.prev;
        }
        size--;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node<T> tmp = head;
        while (tmp != null) {
            sj.add(tmp.value.toString());
            tmp = tmp.next;
        }
        return sj.toString();
    }
}
