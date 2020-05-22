package structures;

import structures.interfaces.List;

public class LinkedList<T> implements List<T> {
  private int size;
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    size = 0;
    head = null;
    tail = null;
  }

  @Override
  public T get(int index) {
    if (index >= size) throw new IndexOutOfBoundsException(index);

    Node<T> node = head;
    int current = 0;

    while (node != null) {
      if (index == current) {
        return node.value;
      }
      node = node.next;
      current++;
    }

    return null;
  }

  @Override
  public T set(int index, T element) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);

    int target = 0;
    Node<T> node = head;
    while(target != index) {
      node = node.next;
    }
    T prev = node.value;
    node.value = element;

    return prev;
  }

  @Override
  public void add(T element) {
    Node<T> node = new Node<>(element);

    if (head == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    size++;
  }

  @Override
  public boolean remove(T element) {
    Node<T> prev = head;
    Node<T> node = prev;

    if(prev != null && prev.value.equals(element)) {
      head = node.next;
      size--;
      return true;
    }
    while(node != null) {
      prev = node;
      node = node.next;
      if (node.value.equals(element)) {
        prev.next = node.next;
        size--;
        return true;
      }
    }

    return false;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public int indexOf(T element) {
    int index = 0;
    Node<T> node = head;
    while (node != null) {
      if (node.value.equals(element)) {
        return index;
      }
      node = node.next;
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

    Node<T> node = head;
    while (node != null) {
      output.append(node.value).append(" -> ");
      node = node.next;
    }

    output.append("null");
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
