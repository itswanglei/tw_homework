package main.java.company.common;

public class MyMap<K, V> {
    private K[] keys;
    private V[] values;

    public MyMap() {
        this.keys = (K[]) new Object[16];
        this.values = (V[]) new Object[16];
    }

    public int size() {
        int count = 0;
        for (K key : this.keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    public boolean containsKey(K key) {
        if (null != this.get(key)) {
            return true;
        }
        return false;
    }

    public V get(K key) {
        for (int i = 0; i < this.size(); i++) {
            if (key == this.keys[i]) {
                return this.values[i];
            }
        }
        return null;
    }

    public boolean put(K key, V value) {
        if (this.containsKey(key)) {
            return false;
        }
        int elementsNumber = this.size();
        this.keys[elementsNumber] = key;
        this.values[elementsNumber] = value;
        return true;
    }

    public boolean remove(K key) {
        for (int i = 0; i < this.size(); i++) {
            if (key == this.keys[i]) {
                this.keys[i] = null;
                this.values[i] = null;
                for (int j = i; j < this.size(); j++) {
                    this.keys[j] = this.keys[j + 1];
                    this.values[j] = this.values[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public void printMyMap() {
        System.out.print("[");
        for (int i = 0; i < this.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(this.keys[i] + "=" + this.values[i]);
        }
        System.out.println("]");
    }

}
