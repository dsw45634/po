package pl.dsw45634.po.ex_3;

class Pair<T extends Comparable<T>> {

  private T left;
  private T right;

  public Pair(T left, T right) {
    this.left = left;
    this.right = right;
  }

  public T getLeft() {
    return left;
  }

  public void setLeft(T left) {
    this.left = left;
  }

  public T getRight() {
    return right;
  }

  public void setRight(T right) {
    this.right = right;
  }

  public void swap() {
    T leftValue = this.left;
    this.left = this.right;
    this.right = leftValue;
  }

  public T max() {
    return left.compareTo(right) < 0 ? right : left;
  }

  @Override
  public String toString() {
    return "Pair:\nleft: " + this.left + "\nright: " + this.right + "\n";
  }
}
