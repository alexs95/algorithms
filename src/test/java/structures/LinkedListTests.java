package structures;

import structures.common.ListTests;

class LinkedListTests extends ListTests<LinkedList<Integer>> {
  public LinkedListTests() {
    this.empty = new LinkedList<>();
    this.one = new LinkedList<>();
    this.two = new LinkedList<>();
    this.five = new LinkedList<>();
  }
}