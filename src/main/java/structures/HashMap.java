package structures;

import structures.interfaces.Map;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {
  private int minimumSize = 1024;
  private int loadFactor = 10;

  private Node<K, V>[] entries;
  private int size;

  public HashMap() {
    initialize(minimumSize);
  }

  // private int hash(K key) {
  //   int code = key.hashCode();
  //   return code ^ code >>> 16;
  // }

  private int hash(K key) {
    return key.hashCode() % (entries.length - 1);
  }

  @Override
  public V put(K key, V value) {
    Node<K, V> curr = entries[hash(key)];
    Node<K, V> tail = curr;

    if (curr != null) {
      while(curr != null) {
        if (curr.key.equals(key)) {
          V prev = curr.value;
          curr.value = value;
          return prev;
        }
        tail = curr;
        curr = curr.next;
      }

      tail.next = new Node<>(key, value);
    } else {
      entries[hash(key)] = new Node<>(key, value);
    }
    size++;

    if (size >= loadFactor * entries.length) {
      resize(size * loadFactor);
    }

    return null;
  }

  @Override
  public V get(K key) {
    Node<K, V> element = entries[hash(key)];

    while(element != null) {
      if (element.key.equals(key)) return element.value;
      element = element.next;
    }

    return null;
  }

  @Override
  public V remove(K key) {
    Node<K, V> prev = entries[hash(key)];
    Node<K, V> curr = prev.next;

    if (prev.key.equals(key)) {
      prev.next = curr != null ? curr.next : null;
      size--;
    }

    while(curr != null) {
      if (curr.key.equals(key)) {
        prev.next = curr.next;
        size--;

        int reducedSize = entries.length / 4;
        if (size / loadFactor < reducedSize && reducedSize > minimumSize) {
          resize(reducedSize);
        }

        return curr.value;
      }

      prev = curr;
      curr = curr.next;
    }

    return null;
  }

  @Override
  public boolean contains(K key) {
    return get(key) != null;
  }

  public ArrayList<K> keys() {
    ArrayList<K> keys = new ArrayList<>();

    for (Node<K, V> element : entries) {
      while(element != null) {
        keys.add(element.key);
        element = element.next;
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

  // @Override
  // public String toString() {
  //   StringBuilder output = new StringBuilder("{\n");
  //   for (List<Node<K, V>> entry : entries) {
  //     if (!entry.isEmpty()) {
  //       for (Node<K, V> element : entry) {
  //         output.append("  " + element.key + ": " + element.value + "\n");
  //       }
  //     }
  //   }
  //   output.append("}");

  //   return output.toString();
  // }

  @SuppressWarnings("unchecked")
  private void initialize(int length) {
    entries = (Node<K, V>[]) Array.newInstance(Node.class, length);
    this.size = 0;
  }

  private void resize(int length) {
    Node<K, V>[] prev = this.entries;
    initialize(length);

    for (Node<K, V> entry : prev) {
      Node<K, V> element = entry;
      while(element != null) {
        this.put(element.key, element.value);
        element = element.next;
      }
    }
  }

  private static class Node<K, V> {
    private Node<K, V> next;
    private K key;
    private V value;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }
}