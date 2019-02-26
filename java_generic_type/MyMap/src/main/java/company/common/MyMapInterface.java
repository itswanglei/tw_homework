package main.java.company.common;

public interface MyMapInterface<K, V> {
    public int size();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public V get(K key);

    public boolean put(K key, V value);

    public V remove(K key);

    public void clear();

    public V replace(K key, V value);

    public Entry[] entrySet();
}
