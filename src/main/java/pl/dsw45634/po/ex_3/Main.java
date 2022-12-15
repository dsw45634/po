package pl.dsw45634.po.ex_3;

class Main {

  public static void main(String[] args) {

    Pair<String> pS = new Pair<>("left", "right");
    Pair<Integer> pI = new Pair<>(57, 23);
    Pair<Double> pD = new Pair<>(65.21, 99.92);

    System.out.println(pS);
    System.out.println(pI);
    System.out.println(pD);

    pS.swap();
    pI.swap();
    pD.swap();

    System.out.println(pS);
    System.out.println(pI);
    System.out.println(pD);

    System.out.println("===== max =====");
    System.out.println(pS.max());
    System.out.println(pI.max());
    System.out.println(pD.max());

  }

}
