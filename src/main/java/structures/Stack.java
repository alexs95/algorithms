package structures;

public class Stack<T> implements structures.interfaces.Stack<T> {
  private Node<T> top;
  private int size;

  public Stack() {
    top = null;
    size = 0;
  }

  @Override
  public T push(T element) {
    Node<T> node = new Node<>(element);
    node.next = top;
    top = node;
    size++;

    return element;
  }

  @Override
  public T pop() {
    if (top == null) return null;

    Node<T> node = top;
    top = node.next;
    size--;

    return node.value;
  }

  @Override
  public T peek() {
    return top != null ? top.value : null;
  }

  @Override
  public void clear() {
    top = null;
    size = 0;
  }

  @Override
  public int search(T element) {
    if (top == null) return -1;

    Node<T> node = top;
    int index = 0;
    while (node != null) {
      if (node.value.equals(element)) return index;
      node = node.next;
      index++;
    }

    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    Node<T> node = top;
    while (node != null) {
      output.append(node.value).append(" <- ");
      node = node.next;
    }

    return output.toString();
  }

  private static class Node<T> {
    private T value;
    private Node<T> next;

    private Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
}
