package structures;

import structures.interfaces.Map;
import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K,V> {
    private List<Pair<K, V>>[] array = null;
    private int size = 0;

    public HashMap(int size) {
        this.array = new ArrayList[size];
    }

    public V put(K key, V value) {
        return null;
    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(K key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public void clear() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}