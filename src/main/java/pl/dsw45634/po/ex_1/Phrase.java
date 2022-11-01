package pl.dsw45634.po.ex_1;

enum Phrase {

  N(Direction.N_S), S(Direction.N_S), W(Direction.W_E), E(Direction.W_E);

  final Direction direction;

  Phrase(Direction direction) {
    this.direction = direction;
  }

  private enum Direction {
    N_S, W_E
  }
}
