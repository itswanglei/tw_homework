package main.java.company.common;

public class Entry<K, V> {
    private final K key;
    private final V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
