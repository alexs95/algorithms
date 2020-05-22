package structures.interfaces;

public interface Map<K, V> {

  /**
   * Returns the value for which this key is mapped, or null if the map contains no mapping.
   *
   * @param key to retrieve value for.
   * @return the value mapped to key, or null.
   */
  public V get(K key);

  /**
   * Associates the specified value with this key in the map.
   *
   * @param key to be inserted.
   * @param value to be associated with the key.
   * @return the previous value mapped to key, or null.
   */
  public V put(K key, V value);

  /**
   * Removes the key-value pair for the specified key.
   *
   * @param key of the pair to remove from the map.
   * @return the value that was mapped to key, or null.
   */
  public V remove(K key);

  /**
   * Returns true if the map contains a value for the given key.
   *
   * @param key to search for.
   * @return true if this map contains a value for the given key.
   */
  public boolean contains(K key);

  /**
   * Removes all mappings from the map.
   */
  public void clear();

  /**
   * Returns the number of key-value pairs in the map.
   *
   * @return the number of key-value pairs.
   */
  public int size();

  /**
   * Tests if there are any key-value pairs in the list.
   *
   * @return true if the map contains no key-value pairs.
   */
  public boolean isEmpty();
}