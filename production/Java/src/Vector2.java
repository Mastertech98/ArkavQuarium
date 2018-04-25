import java.lang.Math;

public class Vector2 {
  public final double abscissa;
  public final double ordinate;

  /**
     * Default constructor
     */
  public Vector2() {
    abscissa = 0;
    ordinate = 0;
  }

  /**
     * Constructor: x = _x, y = _y
     * @param abscissa position in horizontal
     * @param ordinate position in vertical
     */
  public Vector2(double abscissa, double ordinate) {
    this.abscissa = abscissa;
    this.ordinate = ordinate;
  }

  /**
     * Get value of vector2 converted into unit vector
     * @return this vector2 with magnitude of 1
     */
  public Vector2 normalized() {
    return divide(distance(Vector2.zero));
  }

  /**
     * Get Distance between 2 vector2
     * @param other the other vector2 comparison besides this vector2
     * @return this vector2 distance to other vector2
     */
  public double distance(Vector2 other) {
    double dx = abscissa - other.abscissa;
    double dy = ordinate - other.ordinate;
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
     * Get random position with range x and y
     * @param abscissa horizontal range
     * @param ordinate vertical range
     * @return random position
     */
  public static Vector2 randomPosition(double abscissa, double ordinate) {
    return new Vector2(Math.random() * abscissa, Math.random() * ordinate);
  }

  /**
     * Get random position between 2 vector2
     * @param min minimum range of x and y
     * @param max maximum range of x and y
     * @return random position
     */
  public static Vector2 randomPosition(Vector2 min, Vector2 max) {
    Vector2 d = max.subtract(min);
    return new Vector2(
      Math.random() * d.abscissa + min.abscissa, Math.random() * d.ordinate + min.ordinate);
  }

  /**
     * Get random direction
     * @return random direction
     */
  public static Vector2 randomDirection() {
    double r = Math.random() * 2 * Math.PI;
    return new Vector2(Math.cos(r), Math.sin((r)));
  }

  /**
     * Get random position of min to max in radiant
     * @param min minimum angle
     * @param max maximum angle
     * @return random direction
     */
  public static Vector2 randomDirection(double min, double max) {
    double r = Math.random() * (max - min) + min;
    return new Vector2(Math.cos(r), Math.sin((r)));
  }

  /**
     * Add this vector2 with argument
     * @param other the other vector2 which will be added
     * @return sum of 2 vector2
     */
  public Vector2 add(Vector2 other) {
    return new Vector2(abscissa + other.abscissa, ordinate + other.ordinate);
  }

  /**
     * Subtract this vector2 with argument
     * @param other the other vector2 which will be subtracted
     * @return subtract of 2 vector2
     */
  public Vector2 subtract(Vector2 other) {
    return new Vector2(abscissa - other.abscissa, ordinate - other.ordinate);
  }

  /**
     * Multiply this vector2 with argument
     * @param k constant which will be multiplied
     * @return multiplied vector2
     */
  public Vector2 multiply(double k) {
    return new Vector2(abscissa * k, ordinate * k);
  }

  /**
     * Divide this vector 2 with argument
     * @param k constant which will be divided
     * @return divided vector2
     */
  public Vector2 divide(double k) {
    return new Vector2(abscissa / k, ordinate / k);
  }

  /**
     * Get vector2 in well-formatted string
     * @return string formatted vector2
     */
  public String toString() {
    return "(" + String.valueOf(abscissa) + ", " + String.valueOf(ordinate) + ")";
  }

  /**
     * Get value comparison between 2 vector2
     * @param other other vector2 beside this vector2
     * @return true if and only if this x equals to other x and this y equals to other y
     */
  public boolean equals(Vector2 other) {
    return abscissa == other.abscissa && ordinate == other.ordinate;
  }

  public static final Vector2 zero = new Vector2();
  public static final Vector2 up = new Vector2(0, -1);
  public static final Vector2 down = new Vector2(0, 1);
  public static final Vector2 right = new Vector2(1, 0);
  public static final Vector2 left = new Vector2(-1, 0);
}
