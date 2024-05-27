package stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.StringJoiner;

/*
push(Object value) додає елемент в кінець
remove(int index) видаляє елемент за індексом
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент стеку
pop() повертає перший елемент стеку та видаляє його з колекції
 */
public class MyStack<T> {
    private static final int CAPACITY = 10;
    private T[] elements;
    private int size;

    public MyStack() {
        elements = (T[]) new Object[CAPACITY];
    }

    public void push(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = element;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public void clear() {
        elements = (T[]) new Object[CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T lastElement = elements[size - 1];
        elements[--size] = null;
        return lastElement;
    }

    @Override
    public String toString() {
        if(size==0){
            return"[]";
        }
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(elements[i] == null ? "null" : elements[i].toString());  // Обробляємо значення null коректно
        }
        return sj.toString();
    }

}
