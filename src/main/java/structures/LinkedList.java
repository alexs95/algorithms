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
  public boolean add(T element) {
    Node<T> node = new Node<>(element);

    if (head == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    size++;

    return true;
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
  public boolean contains(T element) {
    Node<T> node = head;
    while (node != null) {
      if (node.value.equals(element)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
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
    }
  }
}