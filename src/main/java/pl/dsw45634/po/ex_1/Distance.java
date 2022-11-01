package pl.dsw45634.po.ex_1;

class Distance {

  private final int meters;

  private Distance(int meters) {
    this.meters = meters;
  }

  int getMeters() {
    return meters;
  }

  static Distance of(String distance) {
    if (distance.contains("km")) {
      distance = distance.replace("km", "");
      int km = Integer.parseInt(distance);
      return new Distance(km * 1000);
    }
    int m = Integer.parseInt(distance);
    return new Distance(m);
  }

  static Distance of(int meters) {
    return new Distance(meters);
  }

  @Override
  public String toString() {
    int m = this.meters % 1000;
    int k = this.meters / 1000;
    return String.format("%dkm %dm", k, m);
  }

  boolean graterThan(Distance distance) {
    return this.meters > distance.meters;
  }

  boolean isEqualTo(Distance distance) {
    return this.meters == distance.meters;
  }

  Distance minus(Distance distance) {
    return of(this.meters - distance.meters);
  }
}
