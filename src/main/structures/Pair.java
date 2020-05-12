package structures;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        } else {
            if (o instanceof Pair) {
                Pair<?, ?> e = (Pair) o;
                return Objects.equals(this.key, e.getKey()) && Objects.equals(this.value, e.getValue());
            }

            return false;
        }
    }
}
