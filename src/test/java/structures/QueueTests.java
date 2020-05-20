package structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTests {
  Queue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new Queue<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
  }

  @Test
  void add() {
    assertEquals(1, queue.peek());
    assertEquals(1, queue.remove());
    assertEquals(2, queue.remove());
    queue.add(4);
    assertEquals(3, queue.remove());
    assertEquals(4, queue.remove());
  }

  @Test
  void clear() {
    queue.clear();
    assertTrue(queue.isEmpty());
    assertEquals(0, queue.size());
  }

  @Test
  void search() {
    assertEquals(-1, queue.search(4));
    assertEquals(1, queue.search(2));
  }
}