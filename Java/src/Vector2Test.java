import static org.junit.Assert.*;

public class Vector2Test {

  @org.junit.Test
  public void normalizedTest() {
    Vector2 abnormal = new Vector2(3, 4);
    Vector2 normal = abnormal.normalized();

    assertEquals(Math.atan2(abnormal.y, abnormal.x), Math.atan2(normal.y, normal.x), 0.001);
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
    assertTrue(position.x <= 3 && position.x >= 0 && position.y <= 4 && position.y >= 0);
  }

  @org.junit.Test
  public void randomDirectionTest() {
    Vector2 direction = Vector2.randomDirection(0, 180);
    assertTrue(direction.x >= 0);
    assertEquals(direction.distance(Vector2.zero), 1, 0.001);
  }

  @org.junit.Test
  public void addTest() {
    Vector2 add = new Vector2(3, 4).add(new Vector2(3, 4));
    assertEquals(add.x, 6, 0.001);
    assertEquals(add.y, 8, 0.001);
  }

  @org.junit.Test
  public void subtractTest() {
    Vector2 subtract = new Vector2(3, 4).subtract(new Vector2(3, 4));
    assertEquals(subtract.x, 0, 0.001);
    assertEquals(subtract.y, 0, 0.001);
  }

  @org.junit.Test
  public void multiplyTest() {
    Vector2 multiply = new Vector2(3, 4).multiply(5);
    assertEquals(multiply.x, 15, 0.001);
    assertEquals(multiply.y, 20, 0.001);
  }

  @org.junit.Test
  public void divideTest() {
    Vector2 divide = new Vector2(3, 4).divide(5);
    assertEquals(divide.x, 0.6, 0.001);
    assertEquals(divide.y, 0.8, 0.001);
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