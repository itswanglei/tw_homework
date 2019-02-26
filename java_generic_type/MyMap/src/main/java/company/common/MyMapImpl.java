package main.java.company.common;

public class MyMapImpl<K, V> implements MyMap {
    private K[] keys;
    private V[] values;
    private int initialCapacity;
    private int capacity;
    private double loadFactor;

    public MyMapImpl() {
        this.initialCapacity = 16;
        this.capacity = this.initialCapacity;
        this.loadFactor = 0.75;
        this.keys = (K[]) new Object[this.capacity];
        this.values = (V[]) new Object[this.capacity];
    }

    public MyMapImpl(int initialCapacity, double loadFactor) {
        this.initialCapacity = initialCapacity;
        this.capacity = this.initialCapacity;
        this.loadFactor = loadFactor;
        this.keys = (K[]) new Object[this.capacity];
        this.values = (V[]) new Object[this.capacity];
    }

    @Override
    public int size() {
        int count = 0;
        for (K key : this.keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    private void expandCapacity() {
        if (this.capacity * this.loadFactor == this.size()) {
            this.capacity += this.initialCapacity;
            K[] clonedKeys = (K[]) new Object[this.capacity];
            V[] clonedValues = (V[]) new Object[this.capacity];
            for (int i = 0; i < this.size(); i++) {
                clonedKeys[i] = this.keys[i];
                clonedValues[i] = this.values[i];
            }
            this.keys = clonedKeys;
            this.values = clonedValues;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return null != this.get(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < this.size(); i++) {
            if (value == this.values[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < this.size(); i++) {
            if (key == this.keys[i]) {
                return this.values[i];
            }
        }
        return null;
    }

    @Override
    public boolean put(Object key, Object value) {
        if (this.containsKey(key)) {
            return false;
        }
        int elementsNumber = this.size();
        this.keys[elementsNumber] = (K) key;
        this.values[elementsNumber] = (V) value;
        this.expandCapacity();
        return true;
    }

    @Override
    public V remove(Object key) {
        V removedValue;
        for (int i = 0; i < this.size(); i++) {
            if (key == this.keys[i]) {
                this.keys[i] = null;
                removedValue = this.values[i];
                this.values[i] = null;
                for (int j = i; j < this.size(); j++) {
                    this.keys[j] = this.keys[j + 1];
                    this.values[j] = this.values[j + 1];
                }
                return removedValue;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.keys[i] = null;
            this.values[i] = null;
        }
    }

    @Override
    public V replace(Object key, Object values) {
        V replacedValue;
        for (int i = 0; i < this.size(); i++) {
            if (key == this.keys[i]) {
                replacedValue = this.values[i];
                this.values[i] = (V) values;
                return replacedValue;
            }
        }
        return null;
    }

    @Override
    public Entry[] entrySet() {
        Entry[] entries = new Entry[this.size()];
        for (int i = 0; i < this.size(); i++) {
            entries[i] = new Entry<>(this.keys[i], this.values[i]);
        }
        return entries;
    }

    @Override
    public boolean isEmpty() {
        return 0 == this.size();
    }

    @Override
    public String toString() {
        String[] entryStringArray = new String[this.size()];
        Entry[] entries = this.entrySet();
        for (int i = 0; i < this.size(); i++) {
            entryStringArray[i] = entries[i].toString();
        }
        return "[" + String.join(", ", entryStringArray) + "]";
    }

    public K[] getKeys() {
        return this.keys;
    }

    public V[] getValues() {
        return this.values;
    }
}
