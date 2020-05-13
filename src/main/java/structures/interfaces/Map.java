package structures.interfaces;

public interface Map<K, V> {
  /**
   * Associates the specified value with the specified key in this map.
   *
   * @param key   to be inserted.
   * @param value to be inserted.
   * @return previous value mapped to key, or null.
   */
  public V put(K key, V value);

  /**
   * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
   *
   * @param key to retrieve value for.
   * @return value mapped to key or null.
   */
  public V get(K key);

  /**
   * Removes the mapping for the specified key.
   *
   * @param key to remove from the map.
   * @return value mapped to key, or null.
   */
  public V remove(K key);

  /**
   * Returns true if this map contains a mapping for the specified key.
   *
   * @param key to locate in the map.
   * @return true if this map contains a mapping for the specified key.
   */
  public boolean contains(K key);

  /**
   * Returns true if this map contains no key-value mappings.
   *
   * @return true if this map contains no key-value mappings.
   */
  public boolean isEmpty();

  /**
   * Number of key-value pairs in the hash map.
   *
   * @return number of key-value pairs.
   */
  public int size();

  /**
   * Clear the map.
   */
  public void clear();
}