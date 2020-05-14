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
   * Removes and returns the element on top of the stack.
   *
   * @return element on top of the stack.
   */
  public T pop();

  /**
   * Look at the element on top of the stack without removing it.
   *
   * @return element on top of the stack.
   */
  public T peek();

  /**
   * Removes all elements from the stack.
   */
  public void clear();

  /**
   * Returns the position of element in the stack, or -1 if not present.
   *
   * @param element to search for in the stack.
   * @return the 1-based position from the top of the stack.
   */
  public int search(T element);

  /**
   * Returns the number of elements in the stack.
   *
   * @return the number of elements in the stack.
   */

  /**
   * Returns the number of elements in this stack.
   *
   * @return the number of elements in this stack.
   */
  public int size();

  /**
   * Tests if there are any elements in the stack.
   *
   * @return true if the stack does not contain any elements.
   */
  public boolean isEmpty();
}
