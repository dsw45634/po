package pl.dsw45634.po.ex_8;

class StackEmptyException extends RuntimeException {

  public StackEmptyException() {
    super("Stack is empty.");
  }
}
