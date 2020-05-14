package structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTests {
  LinkedList<Integer> list;

  @BeforeEach
  void before() {
    list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(3);
  }

  @Test
  void add() {
    assertEquals(4, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(3, list.get(3));
  }

  @Test
  void remove() {
    list.remove(1);
    list.remove(2);
    assertEquals(2, list.size());
    list.remove(3);
    list.remove(3);
    assertEquals(0, list.size());

    list.remove(1);
  }

  @Test
  void clear() {
    list.clear();
    assertEquals(0, list.size());
  }

  @Test
  void contains() {
    assertTrue(list.contains(1));
    assertTrue(list.contains(2));
    assertTrue(list.contains(3));
    assertFalse(list.contains(4));

    list.remove(1);
    assertFalse(list.contains(1));

    list.clear();
    assertFalse(list.contains(2));

    list.add(1);
    assertTrue(list.contains(1));
  }

  @Test
  void get() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(100));
  }
}