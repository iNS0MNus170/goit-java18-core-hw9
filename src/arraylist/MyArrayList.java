package arraylist;

import java.util.Arrays;

/*
add(Object value) додає елемент в кінець
remove(int index) видаляє елемент із вказаним індексом
clear() очищає колекцію
size() повертає розмір колекції
get(int index) повертає елемент за індексом
 */
public class MyArrayList<T> {
    private T[] elements;
    private static final int DEFAULT_LENGTH = 10;
    private int size;

    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_LENGTH];
    }

    private void checkSizeAndIndex(int size, int index) {
        if (size == 0) {
            throw new IllegalStateException("список порожній");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("невірний індекс, в списку доступні індекси від 0 до " + (size - 1));
        }
    }

    public void add(T e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = e;
    }

    public void remove(int index) {
        checkSizeAndIndex(size, index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public void clear() {
        elements = (T[]) new Object[DEFAULT_LENGTH];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkSizeAndIndex(size, index);
        return elements[index];
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == (size - 1)) {
                sb.append(elements[i]).append("]");
                continue;
            }
            sb.append(elements[i]).append(", ");
        }
        return sb.toString();
    }
}
