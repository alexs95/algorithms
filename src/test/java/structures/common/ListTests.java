package structures.common;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.interfaces.List;

public abstract class ListTests<T extends List<Integer>> {
  public T empty;
  public T one;
  public T two;
  public T five;

  @BeforeEach
  void before() {
    one.add(0);

    two.add(0);
    two.add(1);

    five.add(0);
    five.add(1);
    five.add(2);
    five.add(3);
    five.add(4);
  }

  @Test
  @DisplayName("set first element in list")
  void setFirst() {
    assertEquals(0, one.set(0, 100));
    assertEquals(100, one.get(0));
    assertEquals(1, one.size());

    assertEquals(0, two.set(0, 100));
    assertEquals(100, two.get(0));
    assertEquals(2, two.size());

    assertEquals(0, five.set(0, 100));
    assertEquals(100, five.get(0));
    assertEquals(5, five.size());
  }

  @Test
  @DisplayName("set last element in list")
  void setLast() {
    assertEquals(1, two.set(1, 100));
    assertEquals(100, two.get(1));

    assertEquals(4, five.set(4, 100));
    assertEquals(100, five.get(4));
  }

  @Test
  @DisplayName("set random element in list")
  void setRandom() {
    assertEquals(2, five.set(2, 100));
    assertEquals(100, five.get(2));
  }

  @Test
  @DisplayName("remove all elements in the order they were added")
  void removeAll() {
    assertTrue(one.remove(0));
    assertEquals(0, one.size());
    assertTrue(one.isEmpty());

    assertTrue(two.remove(0));
    assertEquals(-1, two.indexOf(0));
    assertTrue(two.remove(1));
    assertEquals(-1, two.indexOf(1));
    assertEquals(0, two.size());
    assertTrue(two.isEmpty());

    assertTrue(five.remove(0));
    assertEquals(-1, five.indexOf(0));
    assertTrue(five.remove(1));
    assertEquals(-1, five.indexOf(1));
    assertTrue(five.remove(2));
    assertEquals(-1, five.indexOf(2));
    assertTrue(five.remove(3));
    assertEquals(-1, five.indexOf(3));
    assertTrue(five.remove(4));
    assertEquals(-1, five.indexOf(4));
    assertEquals(0, five.size());
    assertTrue(five.isEmpty());
  }

  @Test
  @DisplayName("remove all elements in the inverse order they were added")
  void removeAllInverseOrder() {
    assertTrue(two.remove(1));
    assertEquals(-1, empty.indexOf(1));
    assertTrue(two.remove(0));
    assertEquals(-1, empty.indexOf(0));
    assertEquals(-1, two.indexOf(4));
    assertEquals(0, two.size());
    assertTrue(two.isEmpty());

    assertTrue(five.remove(4));
    assertEquals(-1, five.indexOf(4));
    assertTrue(five.remove(3));
    assertEquals(-1, five.indexOf(3));
    assertTrue(five.remove(1));
    assertEquals(-1, five.indexOf(1));
    assertTrue(five.remove(2));
    assertEquals(-1, five.indexOf(2));
    assertTrue(five.remove(0));
    assertEquals(-1, five.indexOf(0));
    assertEquals(-1, five.indexOf(4));
    assertEquals(0, five.size());
    assertTrue(five.isEmpty());
  }

  @Test
  @DisplayName("remove all elements in random order")
  void removeInRandomOrder() {
    assertTrue(five.remove(3));
    assertEquals(-1, five.indexOf(3));
    assertTrue(five.remove(1));
    assertEquals(-1, five.indexOf(1));
    assertTrue(five.remove(4));
    assertEquals(-1, five.indexOf(4));
    assertTrue(five.remove(0));
    assertEquals(-1, five.indexOf(0));
    assertTrue(five.remove(2));
    assertEquals(-1, five.indexOf(2));
    assertTrue(five.isEmpty());
    assertEquals(0, five.size());
  }

  @Test
  @DisplayName("remove a nonexistent element")
  void removeNonExistent() {
    assertFalse(empty.remove(0));
    assertFalse(one.remove(100));
    assertEquals(1, one.size());
    assertFalse(two.remove(100));
    assertEquals(2, two.size());
    assertFalse(five.remove(100));
    assertEquals(5, five.size());
  }

  @Test
  @DisplayName("clear empties the list")
  void clear() {
    empty.clear();
    assertEquals(0, empty.size());
    assertTrue(empty.isEmpty());

    one.clear();
    assertEquals(0, one.size());
    assertTrue(one.isEmpty());
    assertEquals(-1, one.indexOf(0));

    two.clear();
    assertEquals(0, two.size());
    assertTrue(two.isEmpty());
    assertEquals(-1, two.indexOf(0));

    five.clear();
    assertEquals(0, five.size());
    assertTrue(five.isEmpty());
    assertEquals(-1, five.indexOf(0));
  }

  @Test
  @DisplayName("get throws IndexOutOfBoundsException if index is greater than list size")
  void getThrowsIndexOutOfBoundsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> empty.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> one.get(1));
    assertThrows(IndexOutOfBoundsException.class, () -> two.get(2));
    assertThrows(IndexOutOfBoundsException.class, () -> five.get(5));
  }

  @Test
  @DisplayName("set throws IndexOutOfBoundsException if index is greater than list size")
  void setThrowsIndexOutOfBoundsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> empty.set(0, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> one.set(1, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> two.set(2, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> five.set(5, 100));
  }

  @Test
  @DisplayName("get throws IndexOutOfBoundsException if index is negative")
  void getThrowsIndexOutOfBoundsExceptionOnNegativeIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> empty.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> one.get(1));
    assertThrows(IndexOutOfBoundsException.class, () -> two.get(2));
    assertThrows(IndexOutOfBoundsException.class, () -> five.get(5));
  }

  @Test
  @DisplayName("set throws IndexOutOfBoundsException if index is negative")
  void setThrowsIndexOutOfBoundsExceptionOnNegativeIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> empty.set(0, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> one.set(1, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> two.set(2, 100));
    assertThrows(IndexOutOfBoundsException.class, () -> five.set(5, 100));
  }
}