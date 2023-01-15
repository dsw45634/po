package pl.dsw45634.po.ex_8;

class StackFullException extends RuntimeException {

  public StackFullException() {
    super("The stack is full");
  }
}
