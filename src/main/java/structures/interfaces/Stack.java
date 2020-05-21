package structures.interfaces;

/**
 * Last in, first out (LIFO).
 */
public interface Stack<T> {

  /**
   * Pushes element on top of the stack.
   *
   * @param element argument.
   * @return the element pushed.
   */
  public T push(T element);

  /**
   * Retrieves and removes element on top of the stack.
   *
   * @return element on top of the stack, or null.
   */
  public T pop();

  /**
   * Return the element on top of the stack without removing it.
   *
   * @return element on top of the stack, or null.
   */
  public T peek();

  /**
   * Returns true if the stack contains element.
   *
   * @param element to search for.
   * @return true if the stack contains element.
   */
  public boolean contains(T element);

  /**
   * Removes all elements from the stack.
   */
  public void clear();

  /**
   * Returns the number of elements in the stack.
   *
   * @return the number of elements in the stack.
   */
  public int size();

  /**
   * Tests if there are any elements in the stack.
   *
   * @return true if the stack does not contain any elements.
   */
  public boolean isEmpty();
}
