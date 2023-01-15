package pl.dsw45634.po.ex_8;

class Stack {

  private final Integer[] stack;
  private int size;

  public Stack(int maxSize) {
    if (maxSize < 0) {
      throw new IllegalArgumentException("Invalid Argument: " + maxSize);
    }
    this.stack = new Integer[maxSize];
  }

  public void push(int number) {
    if (!(this.stack.length > this.size)) {
      throw new StackFullException();
    }
    this.stack[this.size++] = number;
  }

  public int pop() {
    if (this.size == 0) {
      throw new StackEmptyException();
    }
    return removeLast();
  }

  public void clear() {
    while (this.size != 0) {
      removeLast();
    }
  }

  public int top() {
    if (this.size == 0) {
      throw new StackEmptyException();
    }
    return this.stack[this.size - 1];
  }

  public int size() {
    return this.size;
  }

  private int removeLast() {
    int value = this.stack[size - 1];
    this.stack[size - 1] = null;
    size--;
    return value;
  }
}
