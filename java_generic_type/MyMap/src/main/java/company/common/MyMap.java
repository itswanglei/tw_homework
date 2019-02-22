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
        for (K key : keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    public boolean put(K key, V value) {
        for (int i = 0; i < this.keys.length; i++) {
            if (this.keys[i] == key) {
                return false;
            }
            if (this.keys[i] == null) {
                this.keys[i] = key;
                this.values[i] = value;
                return true;
            }
        }
        return false;
    }

    public void printMyMap() {
        System.out.print("[");
        for (int i = 0; i < this.keys.length; i++) {
            if (keys[i] != null) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(keys[i] + "=" + values[i]);
            }
        }
        System.out.println("]");
    }

}
