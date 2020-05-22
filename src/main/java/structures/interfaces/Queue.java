package structures.interfaces;

/**
 * First in, first out (FIFO).
 */
public interface Queue<T> {

  /**
   * Adds element to the end of the queue.
   *
   * @param element to insert into queue.
   */
  public void add(T element);

  /**
   * Retrieves and removes element at the start of the queue.
   *
   * @return element at the start of the queue, or null.
   */
  public T remove();

  /**
   * Return the element at the start of the queue without removing it.
   *
   * @return element at the start of the queue, or null.
   */
  public T peek();

  /**
   * Returns true if the queue contains the given element.
   *
   * @param element to search for.
   * @return true if the queue contains element.
   */
  public boolean contains(T element);

  /**
   * Removes all elements from the queue.
   */
  public void clear();

  /**
   * Returns the number of elements in the queue.
   *
   * @return the number of elements in the queue.
   */
  public int size();

  /**
   * Tests if there are any elements in the queue.
   *
   * @return true if the queue does not contain any elements.
   */
  public boolean isEmpty();
}
