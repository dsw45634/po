package pl.dsw45634.po.ex_4;

class Enclosure<T extends Animal<?>> {

  private final T[] animals;
  private int size;

  @SuppressWarnings("unchecked")
  public Enclosure() {
    this.animals = (T[]) new Object[Integer.MAX_VALUE];
  }

  public void add(T animal) {
    this.animals[this.size++] = animal;
  }

  public void remove(T animal) {
    for (int i = 0; i < this.size; i++) {
      if (animals[i].equals(animal)) {
        if (i == this.size - 1) {
          animals[i] = null;
        } else {
          animals[i] = animals[this.size - 1];
          animals[this.size - 1] = null;
        }
        size--;
      }
    }
  }

  public int size() {
    return this.size;
  }

}
