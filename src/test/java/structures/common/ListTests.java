package structures.common;

import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.Example;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.NotEmpty;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import structures.interfaces.List;
import com.google.common.reflect.TypeToken;

abstract public class ListTests<L extends List<Integer>> {

  @Example
  @Label("set at random index")
  void empty() {
    checkEmpty(create());
  }

  @Property
  @Label("set at random index")
  void set(
      @ForAll @NotEmpty java.util.List<Integer> list,
      @ForAll int element
  ) {
    L target = copy(list);
    int index = new Random().nextInt(list.size());
    target.set(index, element);
    assertTrue(target.get(index) == element);
  }

  @Property
  @Label("get all elements")
  void get(@ForAll @NotEmpty java.util.List<Integer> list) {
    L target = copy(list);
    java.util.List<Integer> indices = IntStream.range(0, list.size()).boxed().collect(Collectors.toList());
    Collections.shuffle(indices);
    for(int index : indices) {
      assertEquals(list.get(index), target.get(index));
    }
  }

  @Property
  @Label("indexOf all elements")
  void indexOf(@ForAll @NotEmpty java.util.List<Integer> list) {
    L target = copy(list);
    for(int element : list) {
      assertEquals(list.indexOf(element), target.indexOf(element));
    }
  }

  @Property
  @Label("remove in random order")
  void remove(@ForAll @NotEmpty java.util.List<Integer> list) {
    L target = copy(list);
    java.util.List<Integer> indices = IntStream.range(0, list.size()).boxed().collect(Collectors.toList());
    Collections.shuffle(indices);
    for(int index : indices) {
      assertFalse(target.isEmpty());
      assertTrue(target.remove(list.get(index)));
    }
    assertTrue(target.isEmpty());
  }

  @Property
  @Label("remove nonexistent element")
  void removeNonExistent(
      @ForAll @NotEmpty java.util.List<@IntRange(max = 1000) Integer> list,
      @ForAll @IntRange(min=1001) int element
  ) {
    L target = copy(list);
    assertFalse(target.remove(element));
    assertTrue(! target.isEmpty());
  }

  @Property
  @Label("clear a list")
  void clear(@ForAll @Size(max = 100) java.util.List<Integer> list) {
    L target = copy(list);
    target.clear();
    checkEmpty(target);
  }

  @Property
  @Label("get throws IndexOutOfBoundsException if index is greater than list size")
  void getThrowsIndexOutOfBoundsException(@ForAll java.util.List<Integer> list) {
    L target = copy(list);
    assertThrows(IndexOutOfBoundsException.class, () -> target.get(list.size()));
  }

  @Property
  @Label("set throws IndexOutOfBoundsException if index is greater than size")
  void setThrowsIndexOutOfBoundsException(
      @ForAll java.util.List<Integer> list,
      @ForAll int element
  ) {
    L target = copy(list);
    assertThrows(IndexOutOfBoundsException.class, () -> target.set(list.size(), element));
  }

  @Property
  @Label("get throws IndexOutOfBoundsException if index is greater than size")
  void getThrowsIndexOutOfBoundsExceptionOnNegativeIndex(
      @ForAll java.util.List<Integer> list,
      @ForAll @IntRange(min = -100, max = -1) int index
  ) {
    L target = copy(list);
    assertThrows(IndexOutOfBoundsException.class, () -> target.get(index));
  }

  @Property
  @Label("set throws IndexOutOfBoundsException if index is negative")
  void setThrowsIndexOutOfBoundsExceptionOnNegativeIndex(
      @ForAll java.util.List<Integer> list,
      @ForAll int element,
      @ForAll @IntRange(min = -100, max = -1) int index
  ) {
    L target = copy(list);
    assertThrows(IndexOutOfBoundsException.class, () -> target.set(index, element));
  }

  @SuppressWarnings({"unchecked", "UnstableApiUsage"})
  private L create() {
    try {
      TypeToken<L> type = new TypeToken<>(getClass()) { };
      return (L) type.getRawType().getConstructor().newInstance();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)  {
      throw new IllegalArgumentException("Unable to instantiate a list of this type!");
    }
  }

  private L copy(java.util.List<Integer> list) throws IllegalArgumentException {
    L target = create();
    for(int element: list) {
      target.add(element);
    }
    return target;
  }

  private void checkEmpty(List<Integer> target) {
    assertTrue(target.isEmpty());
    assertThrows(IndexOutOfBoundsException.class, () -> target.set(0, 0));
    assertThrows(IndexOutOfBoundsException.class, () -> target.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> target.get(0));
    assertEquals(-1, target.indexOf(0));
    assertEquals(0, target.size());
  }
}