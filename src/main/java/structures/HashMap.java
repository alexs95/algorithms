package structures;

import structures.interfaces.Map;
import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {
  private int minimumSize = 1024;
  private int loadFactor = 10;

  private List<Pair<K, V>>[] entries;
  private int size;

  public HashMap() {
    initialize(minimumSize);
  }

  private int hash(K element) {
    return element.hashCode() & (entries.length - 1);
  }

  @Override
  public V put(K key, V value) {
    List<Pair<K, V>> entry = entries[hash(key)];

    for (Pair<K, V> element : entry) {
      if (element.getKey().equals(key)) {
        V prev = element.getValue();
        element.setValue(value);
        return prev;
      }
    }

    entry.add(new Pair<>(key, value));
    size++;

    if (size >= loadFactor * entries.length) {
      resize(size * loadFactor);
    }

    return null;
  }

  @Override
  public V get(K key) {
    for (Pair<K, V> element : entries[hash(key)]) {
      if (element.getKey().equals(key))
        return element.getValue();
    }

    return null;
  }

  @Override
  public V remove(K key) {
    List<Pair<K, V>> entry = entries[hash(key)];
    for (Pair<K, V> element : entry) {
      if (element.getKey().equals(key)) {
        entry.remove(element);
        size--;

        int reducedSize = entries.length / 4;
        if (size / loadFactor < reducedSize && reducedSize > minimumSize) {
          resize(reducedSize);
        }

        return element.getValue();
      }
    }
    return null;
  }

  @Override
  public boolean contains(K key) {
    return get(key) != null;
  }

  public ArrayList<K> keys() {
    ArrayList<K> keys = new ArrayList<>();
    for (List<Pair<K, V>> entry : entries) {
      for (Pair<K, V> element : entry) {
        keys.add(element.getKey());
      }
    }
    return keys;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    initialize(minimumSize);
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder("{\n");
    for (List<Pair<K, V>> entry : entries) {
      if (!entry.isEmpty()) {
        for (Pair<K, V> element : entry) {
          output.append("  " + element.getKey() + ": " + element.getValue() + "\n");
        }
      }
    }
    output.append("}");

    return output.toString();
  }

  private void initialize(int length) {
    entries = new ArrayList[length];
    for (int i = 0; i < entries.length; i++ ) {
      entries[i] = new ArrayList<>();
    }
    this.size = 0;
  }

  private void resize(int length) {
    List<Pair<K, V>>[] cache = this.entries;
    initialize(length);

    for (List<Pair<K, V>> entry : cache) {
      for (Pair<K, V> element : entry) {
        this.put(element.getKey(), element.getValue());
      }
    }
  }
}