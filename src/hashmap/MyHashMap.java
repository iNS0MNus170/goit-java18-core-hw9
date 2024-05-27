package hashmap;

import java.util.StringJoiner;

/*
put(Object key, Object value) додає пару ключ + значення
remove(Object key) видаляє пару за ключем
clear() очищає колекцію
size() повертає розмір колекції
get(Object key) повертає значення (Object value) за ключем
 */
public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] table;
    private int size;
    private int threshold;

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.table = new Node[INITIAL_CAPACITY];
        this.threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
        this.size = 0;
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode() & (table.length - 1);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            Node<K, V> current = table[hash];
            while (true) {
                if (current.key == null || current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
        size++;
        if (size >= threshold) {
            resize();
        }
    }

    public void remove(K key) {
        int hash = hash(key);
        Node<K, V> current = table[hash];
        Node<K, V> prev = null;
        while (current != null) {
            if (current.key == null || current.key.equals(key)) {
                if (prev == null) {
                    table[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
        threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> current = table[hash];
        while (current != null) {
            if (current.key == null || current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        threshold = (int) (table.length * LOAD_FACTOR);
        size = 0;

        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (Node<K, V> node : table) {
            while (node != null) {
                sj.add(node.key + "=" + node.value);
                node = node.next;
            }
        }
        return sj.toString();
    }
}