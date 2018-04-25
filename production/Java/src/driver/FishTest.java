import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class FishTest {
  private Aquarium aqtest1 = new Aquarium(50, 50, 100, 10);
  private Aquarium aqtest2 = new Aquarium(60, 60, 100, 10);

  private Guppy guppy = new Guppy(aqtest1);

  @Test
  public void isGetFullTime() throws Exception {
    assertEquals(500, guppy.getFullTime());

  }

  @Test
  public void isGetHungryTime() throws Exception {
    assertEquals(500, guppy.getHungryTime());
  }

  @Test
  public void isGetMoveTime() throws Exception {
    assertEquals(50, guppy.getMoveTime());
  }

  @Test
  public void getLastMealTime() throws Exception {
    assertEquals(guppy.getAquarium().getGameTime(), guppy.getLastMealTime());
  }

  @Test
  public void getLastMoveTime() throws Exception {
    assertEquals(guppy.getAquarium().getGameTime(), guppy.getLastMoveTime());
  }

  @Test
  public void setLastMealTime() throws Exception {
    guppy.setLastMealTime(1000);
    assertEquals(1000, guppy.getLastMealTime());
  }

  @Test
  public void setLastMoveTime() throws Exception {
    guppy.setLastMoveTime(12000);
    assertEquals(12000, guppy.getLastMoveTime());
  }

  @Test
  public void move() throws Exception {

    Vector2 a = guppy.getPosition();

    guppy.move();

    Vector2 b = guppy.getPosition();
    assertNotEquals("Guppy is not moving", b, a);
  }

  @Test
  public void dropCoin() throws Exception {
    aqtest1.add(guppy);
    guppy.dropCoin(3);
    Coin coin = guppy.getAquarium().getCoins().getFirst().getData();
    assertNotEquals(-1, aqtest1.getCoins().find(coin));
    assertEquals(3, coin.getValue());
  }

  @Test
  public void tick() throws Exception {
    aqtest1.add(guppy);
    assertNotEquals(-1, aqtest1.getGuppies().find(guppy));
    guppy.getAquarium().setGameTime(10000000);
    guppy.tick();
    assertEquals(-1, aqtest1.getGuppies().find(guppy));
  }
}
