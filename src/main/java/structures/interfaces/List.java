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
   * Replaces the element at the given index with the given element.
   *
   * @param index of the element to replace.
   * @param element to be stored at index.
   * @return the previous element at index in the list.
   */
  public T set(int index, T element);

  /**
   * Appends element to the end of the list.
   *
   * @param element to add.
   */
  public void add(T element);

  /**
   * Removes the first occurrence of element from the list, if it is present.
   *
   * @param element to be removed from the list.
   * @return true if the list changed as a result of this call.
   */
  public boolean remove(T element);

  /**
   * Returns true if the list contains element.
   *
   * @param element to search for.
   * @return true if the list contains element.
   */
  public boolean contains(T element);

  /**
   * Returns the index of the first occurrence of element in this list, or -1 if not present.
   *
   * @param element to search for.
   * @return the index of the element, or -1.
   */
  int indexOf(T element);

  /**
   * Removes all elements from the list.
   */
  public void clear();

  /**
   * Returns the number of elements in the list.
   *
   * @return the number of elements in the list.
   */
  public int size();

  /**
   * Tests if there are any elements in the list.
   *
   * @return true if the queue does not contain any elements.
   */
  public boolean isEmpty();
}

