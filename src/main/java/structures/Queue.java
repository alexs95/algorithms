package structures;

public class Queue<T> implements structures.interfaces.Queue<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public Queue() {
    head = null;
    tail = null;
    size = 0;
  }

  public void add(T element) {
    Node<T> node = new Node<>(element);
    if (tail == null) {
      tail = node;
      head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  @Override
  public T peek() {
    return head != null ? head.value : null;
  }

  @Override
  public T remove() {
    if (head != null) {
      T element = head.value;
      head = head.next;
      return element;
    }

    return null;
  }

  @Override
  public void clear() {
    tail = null;
    head = null;
    size = 0;
  }

  @Override
  public boolean contains(T value) {
    if (head == null) return false;

    Node<T> node = head;
    while (node != null) {
      if (node.value.equals(value)) return true;
      node = node.next;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
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
