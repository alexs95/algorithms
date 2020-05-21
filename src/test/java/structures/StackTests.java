package structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTests {
  Stack<Integer> stack;

  @BeforeEach
  void before() {
    stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
  }

  @Test
  void push() {
    assertEquals(3, stack.size());
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.pop());
  }

  @Test
  void pop() {
    assertEquals(3, stack.pop());
    assertEquals(2, stack.size());

    assertEquals(2, stack.pop());
    assertEquals(1, stack.size());

    assertEquals(1, stack.pop());
    assertEquals(0, stack.size());
    assertTrue(stack.isEmpty());
    assertNull(stack.pop());
  }

  @Test
  void peek() {
    assertEquals(3, stack.peek());
    stack.clear();
    assertNull(stack.peek());
    assertTrue(stack.isEmpty());
  }

  @Test
  void contains() {
    assertTrue(stack.contains(3));
    assertTrue(stack.contains(1));
    assertFalse(stack.contains(100));
  }
}