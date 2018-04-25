import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class GuppyTest {

  private Aquarium aqtest1 = new Aquarium(50, 50, 100, 10);
  private Aquarium aqtest2 = new Aquarium(60, 60, 100, 10);

  private Guppy guppy = new Guppy(aqtest1);

  @Test
  public void isGetCoinDropPeriod() throws Exception {
    assertEquals(100, guppy.getCoinDropPeriod());
  }

  @Test
  public void isGetEatenFood() throws Exception {
    assertEquals(0, guppy.getEatenFood());
  }

  @Test
  public void isGetLastCoinDrop() throws Exception {
    assertEquals(guppy.getAquarium().getGameTime(), guppy.getLastCoinDrop());
  }

  @Test
  public void isGetGrowthStage() throws Exception {
    assertEquals(1, guppy.getGrowthStage());
    guppy.setEatenFood(2);
    assertEquals(2, guppy.getGrowthStage());
    guppy.setEatenFood(5);
    assertEquals(3, guppy.getGrowthStage());
  }

  @Test
  public void isSetEatenFood() throws Exception {
    guppy.setEatenFood(10);
    assertEquals(10, guppy.getEatenFood());
  }

  @Test
  public void isSetLastCoinDrop() throws Exception {
    guppy.setLastCoinDrop(100);
    assertEquals(100, guppy.getLastCoinDrop());
  }

  @Test
  public void isEat() throws Exception {
    Food food = new Food(aqtest1, 1000);
    aqtest1.add(food);
    aqtest1.add(guppy);
    assertEquals("Guppy not going to eat",
        food.getPosition(), aqtest1.getGuppies().getFirst().getData().eat());
  }

  @Test
  public void isDestruct() throws Exception {
    aqtest1.add(guppy);

    guppy.destruct();
    assertEquals(-1, aqtest1.getGuppies().find(guppy));
  }

  @Test
  public void isTick() throws Exception {
    aqtest1.setGameTime(500);

    guppy.tick();
    Coin coin = guppy.getAquarium().getCoins().getFirst().getData();
    assertNotEquals(-1, aqtest1.getCoins().find(coin));
  }
}
