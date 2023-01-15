package pl.dsw45634.po.ex_6;

class Factorial {

  static long factorialOf(long number) {
    if (number < 0) {
      throw new FactorialException();
    }
    return number <= 1 ? 1 : number * factorialOf(--number);
  }

  public static void main(String[] args) {

    for (int i = 20; i > -2; i--) {
      try {
        System.out.println(i + "! = " + factorialOf(i));
      } catch (FactorialException e) {
        System.err.println("Invalid number: " + i);
      }
    }
  }

}
