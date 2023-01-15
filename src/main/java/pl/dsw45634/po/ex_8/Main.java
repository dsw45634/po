package pl.dsw45634.po.ex_8;

class Main {

  public static void main(String[] args) {

    Stack stackFirst = new Stack(5);
    Stack stackSecond = new Stack(5);

    System.out.println("=========================\n");

    try {
      System.out.println("Stack stack = new Stack(-4);");
      Stack stack = new Stack(-4);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }

    System.out.println("=========================\n");

    for (int i = 0; i < 6; i++) {
      int random = (int) (Math.random() * 60);
      try {
        System.out.printf("stackFirst.push(%d);\n", random);
        stackFirst.push(random);
        System.out.printf("stackFirst.size(): %d\n", stackFirst.size());
      } catch (StackFullException e) {
        System.err.println(e.getMessage());
      }
    }

    System.out.println("=========================\n");

    try {
      System.out.printf("stackFirst.top(): %d\n", stackFirst.top());
      System.out.printf("stackFirst.top(): %d\n", stackFirst.top());
    } catch (StackEmptyException e) {
      System.err.println(e.getMessage());
    }

    System.out.println("=========================\n");

    for (int i = 0; i < 6; i++) {
      try {
        System.out.printf("%d. stackFirst.pop(): %d\n", i, stackFirst.pop());
      } catch (StackEmptyException e) {
        System.err.println(e.getMessage());
      }
    }

    System.out.println("=========================\n");

    for (int i = 0; i < 5; i++) {
      int random = (int) (Math.random() * 60);
      try {
        stackSecond.push(random);
        System.out.printf("stackSecond.push(%d):\n", random);
      } catch (StackFullException e) {
        System.err.println(e.getMessage());
      }
    }

    System.out.println("=========================\n");

    System.out.printf("stackFirst.size(): %d\n", stackFirst.size());
    System.out.printf("stackSecond.size(): %d\n", stackSecond.size());

    System.out.println("=========================\n");

    System.out.println("stackSecond.clear():");
    stackSecond.clear();
    System.out.printf("stackSecond.size(): %d\n", stackSecond.size());

    System.out.println("=========================\n");

  }
}
