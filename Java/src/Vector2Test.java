import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Vector2Test {

  @org.junit.Test
  public void normalizedTest() {
    Vector2 abnormal = new Vector2(3, 4);
    Vector2 normal = abnormal.normalized();

    assertEquals(
        Math.atan2(abnormal.ordinate, abnormal.abscissa),
        Math.atan2(normal.ordinate, normal.abscissa), 0.001);
    assertEquals(normal.distance(Vector2.zero), 1, 0.001);
  }

  @org.junit.Test
  public void distanceTest() {
    Vector2 vector5 = new Vector2(3, 4);
    assertEquals(vector5.distance(Vector2.zero), 5, 0.001);
  }

  @org.junit.Test
  public void randomPositionTest() {
    Vector2 position = Vector2.randomPosition(Vector2.zero, new Vector2(3, 4));
    assertTrue(
        position.abscissa <= 3 && position.abscissa >= 0
          && position.ordinate <= 4 && position.ordinate >= 0);
  }

  @org.junit.Test
  public void randomDirectionTest() {
    Vector2 direction = Vector2.randomDirection(0, 180);
    assertTrue(direction.abscissa >= 0);
    assertEquals(direction.distance(Vector2.zero), 1, 0.001);
  }

  @org.junit.Test
  public void addTest() {
    Vector2 add = new Vector2(3, 4).add(new Vector2(3, 4));
    assertEquals(add.abscissa, 6, 0.001);
    assertEquals(add.ordinate, 8, 0.001);
  }

  @org.junit.Test
  public void subtractTest() {
    Vector2 subtract = new Vector2(3, 4).subtract(new Vector2(3, 4));
    assertEquals(subtract.abscissa, 0, 0.001);
    assertEquals(subtract.ordinate, 0, 0.001);
  }

  @org.junit.Test
  public void multiplyTest() {
    Vector2 multiply = new Vector2(3, 4).multiply(5);
    assertEquals(multiply.abscissa, 15, 0.001);
    assertEquals(multiply.ordinate, 20, 0.001);
  }

  @org.junit.Test
  public void divideTest() {
    Vector2 divide = new Vector2(3, 4).divide(5);
    assertEquals(divide.abscissa, 0.6, 0.001);
    assertEquals(divide.ordinate, 0.8, 0.001);
  }

  @org.junit.Test
  public void toStringTest() {
    assertEquals(new Vector2(3, 4).toString(), "(3, 4)");
  }

  @org.junit.Test
  public void equalsTest() {
    assertTrue(new Vector2(3, 4).equals(new Vector2(3, 4)));
  }
}