import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class FoodTest {
  private Aquarium aqtest1 = new Aquarium(50, 50, 100, 10);
  private Aquarium aqtest2 = new Aquarium(60, 60, 100, 10);

  private Food food = new Food(aqtest1, 2.5);
  private Vector2 pos = new Vector2(20, 20);

  @Test
  public void isMove() throws Exception {
    food.setPosition(pos);
    Vector2 a = food.getPosition();

    food.move();

    Vector2 b = food.getPosition();
    assertNotEquals("Food is not moving", b, a);
  }

  @Test
  public void isTick() throws Exception {
    Vector2 pos2 = new Vector2(20, 60);
    food.setPosition(pos2);

    food.tick();
    assertEquals(-1, aqtest1.getFoods().find(food));

  }

  @Test
  public void isDestruct() throws Exception {
    aqtest1.add(food);

    food.destruct();
    assertEquals(-1, aqtest1.getFoods().find(food));
  }
}
