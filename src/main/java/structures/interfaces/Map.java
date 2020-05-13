package structures.interfaces;

public interface Map<K, V> {
  /**
   * Associates the specified value with this key in the map.
   *
   * @param key to be inserted.
   * @param value to be associated with the key.
   * @return the previous value mapped to key, or null.
   */
  public V put(K key, V value);

  /**
   * Returns the value for which this key is mapped, or null if the map contains no mapping.
   *
   * @param key to retrieve value for.
   * @return the value mapped to key, or null.
   */
  public V get(K key);

  /**
   * Removes the value mapping for the specified key.
   *
   * @param key to remove from the map.
   * @return the value that was mapped to key, or null.
   */
  public V remove(K key);

  /**
   * Returns true if the map contains a mapping for the key.
   *
   * @param key to locate in the map.
   * @return true if this map contains a mapping for the key.
   */
  public boolean contains(K key);

  /**
   * Returns true if this map contains no key-value mappings.
   *
   * @return true if this map contains no key-value mappings.
   */
  public boolean isEmpty();

  /**
   * Returns the number of key-value pairs in the map.
   *
   * @return the number of key-value pairs.
   */
  public int size();

  /**
   * Removes all mappings from the map.
   */
  public void clear();
}