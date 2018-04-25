import java.lang.Math;

public class Vector2 {
  public final double abscissa;
  public final double ordinate;

  public Vector2() {
    abscissa = 0;
    ordinate = 0;
  }

  public Vector2(double abscissa, double ordinate) {
    this.abscissa = abscissa;
    this.ordinate = ordinate;
  }

  public Vector2 normalized() {
    return divide(distance(Vector2.zero));
  }

  public double distance(Vector2 other) {
    double dx = abscissa - other.abscissa;
    double dy = ordinate - other.ordinate;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public static Vector2 randomPosition(double abscissa, double ordinate) {
    return new Vector2(Math.random() * abscissa, Math.random() * ordinate);
  }

  public static Vector2 randomPosition(Vector2 min, Vector2 max) {
    Vector2 d = max.subtract(min);
    return new Vector2(
      Math.random() * d.abscissa + min.abscissa, Math.random() * d.ordinate + min.ordinate);
  }

  public static Vector2 randomDirection() {
    double r = Math.random() * 2 * Math.PI;
    return new Vector2(Math.cos(r), Math.sin((r)));
  }

  public static Vector2 randomDirection(double min, double max) {
    double r = Math.random() * (max - min) + min;
    return new Vector2(Math.cos(r), Math.sin((r)));
  }

  public Vector2 add(Vector2 other) {
    return new Vector2(abscissa + other.abscissa, ordinate + other.ordinate);
  }

  public Vector2 subtract(Vector2 other) {
    return new Vector2(abscissa - other.abscissa, ordinate - other.ordinate);
  }

  public Vector2 multiply(double k) {
    return new Vector2(abscissa * k, ordinate * k);
  }

  public Vector2 divide(double k) {
    return new Vector2(abscissa / k, ordinate / k);
  }

  public String toString() {
    return "(" + String.valueOf(abscissa) + ", " + String.valueOf(ordinate) + ")";
  }

  public boolean equals(Vector2 other) {
    return abscissa == other.abscissa && ordinate == other.ordinate;
  }

  public static final Vector2 zero = new Vector2();
  public static final Vector2 up = new Vector2(0, -1);
  public static final Vector2 down = new Vector2(0, 1);
  public static final Vector2 right = new Vector2(1, 0);
  public static final Vector2 left = new Vector2(-1, 0);
}
