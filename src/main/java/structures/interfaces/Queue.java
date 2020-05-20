package structures.interfaces;

/**
 * First in, first out (FIFO).
 */
public interface Queue<T> {

  /**
   * Inserts element at the head of the queue.
   *
   * @param element to insert into queue.
   */
  public void add(T element);

  /**
   * Look at the element at the head of the queue without removing it.
   *
   * @return element at the head of the queue, or null.
   */
  public T peek();

  /**
   * Retrieves and removes the head of the queue.
   *
   * @return element at the head of the queue, or null.
   */
  public T remove();

  /**
   * Removes all elements from the queue.
   */
  public void clear();

  /**
   * Returns the index of element in the queue, or -1 if not present.
   *
   * @param element to search for in the stack.
   * @return the index from the top of the stack.
   */
  public int search(T element);

  /**
   * Get the size of the queue.
   *
   * @return size of the queue.
   */
  public int size();

  /**
   * Tests if there are any elements in the queue.
   *
   * @return true if the queue does not contain any elements.
   */
  public boolean isEmpty();
}
