package pl.dsw45634.po.ex_4;

abstract class Animal<T> {

  private T species;

  public Animal(T species) {
    this.species = species;
  }

  public T getSpecies() {
    return species;
  }

  public void setSpecies(T species) {
    this.species = species;
  }
}
