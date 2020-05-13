package structures.interfaces;

public interface List<T> {

  /**
   * Returns the element at index in the list.
   *
   * @param index of the element to return.
   * @return the element at index in the list.
   */
  public T get(int index);

  /**
   * Appends element to the end of the list.
   *
   * @param element to add.
   * @return true if the list changed as a result of this call.
   */
  public boolean add(T element);

  /**
   * Removes the first occurrence of element from the list, if it is present.
   *
   * @param element to be removed from the list.
   * @return true if the list changed as a result of this call.
   */
  public boolean remove(T element);

  /**
   * Removes all elements from the list.
   */
  public void clear();

  /**
   * Returns true if the list contains element.
   *
   * @param element to search for.
   * @return true if the list contains element.
   */
  public boolean contains(T element);

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list.
   */
  public int size();
}

