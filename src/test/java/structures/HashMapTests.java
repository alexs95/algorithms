package structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HashMapTests {
  @Test
  void putAndGet() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("e1", 1);
    assertEquals(1, map.get("e1"));

    map.put("e2", 2);
    assertEquals(2, map.get("e2"));

    map.put("e3", 3);
    assertEquals(3, map.get("e3"));

    assertEquals(3, map.put("e3", 4));
    assertEquals(4, map.get("e3"));
    assertNull(map.get("e5"));
  }

  @Test
  void remove() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("e1", 1);
    map.put("e2", 2);
    map.put("e3", 3);

    map.remove("e1");
    map.remove("e2");
    map.remove("e3");

    assertTrue(map.isEmpty());
  }

  @Test
  void contains() {
    HashMap<String, Integer> map = new HashMap<>();
    assertFalse(map.contains("e1"));
    map.put("e1", 1);
    assertTrue(map.contains("e1"));
    map.put("e2", 1);
    assertTrue(map.contains("e2"));
  }

  @Test
  void keys() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("e1", 1);
    map.put("e2", 2);
    map.put("e3", 3);

    String[] expected = {"e1", "e2", "e3"};
    assertArrayEquals(expected, map.keys().toArray(new String[3]));
  }

  @Test
  void size() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("e1", 1);
    assertEquals(1, map.size());

    map.put("e2", 2);
    assertEquals(2, map.size());

    map.put("e3", 3);
    assertEquals(3, map.size());

    map.put("e3", 4);
    assertEquals(3, map.size());

    map.remove("e3");
    assertEquals(2, map.size());
  }

  @Test
  void clear() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("e1", 1);
    map.put("e2", 2);
    map.put("e3", 3);
    map.clear();

    assertTrue(map.isEmpty());
    assertEquals(0, map.size());
  }
}