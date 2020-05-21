package structures;

import structures.interfaces.List;
import java.util.Arrays;

public class ArrayList<T> implements List<T> {
  private static final int MINIMUM_SIZE = 1024;

  private int size;
  private T[] array;

  @SuppressWarnings("unchecked")
  public ArrayList() {
    array = (T[]) new Object[MINIMUM_SIZE];
  }

  public T get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
    return array[index];
  }

  public T set(int index, T value) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
    T prev = array[index];
    array[index] = value;
    return prev;
  }

  @Override
  public void add(T value) {
    // Double the size of the array if it is full
    if (size >= array.length) resize(array.length << 2);
    array[size] = value;
    size++;
  }

  @Override
  public boolean remove(T element) {
    int index = indexOf(element);
    if (index != -1) {
      remove(index);
      return true;
    }
    return false;
  }

  public T remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

    T element = array[index];
    if (index != --size) {
      // Shift the elements to remove the gap caused by removal
      System.arraycopy(array, index + 1, array, index, size - index);
    }
    array[size] = null;

    // If array is 50% empty, resize it
    int reducedSize = array.length >> 1;
    if (reducedSize >= MINIMUM_SIZE && size < reducedSize) {
      resize(reducedSize);
    }

    return element;
  }

  public boolean contains(T value) {
    for (int index = 0; index < size; index++) {
      T element = array[index];
      if (element.equals(value)) return true;
    }
    return false;
  }

  @Override
  public int indexOf(T element) {
    for (int index = 0; index < size; index++) {
      if (element.equals(array[index])) {
        return index;
      }
    }
    return -1;
  }

  @Override
  public void clear() {
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void resize(int size) {
    array = Arrays.copyOf(array, size);
  }
}
