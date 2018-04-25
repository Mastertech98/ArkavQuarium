import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ElementListTest {
  private Aquarium aqtest = new Aquarium(50,50,100,10);
  private Vector2 vectest = new Vector2(48,48);
  private Coin cointest = new Coin(aqtest,vectest,10);
  private Coin cointest2 = new Coin(aqtest,vectest,10);
  private ElementList<Coin> elemtest = new ElementList(cointest);
  private ElementList<Coin> elemtest2 = new ElementList(cointest);

  @Test
  public void getDataTest() {
    assertEquals(cointest, elemtest.getData());
  }

  @Test
  public void getNextTest() {
    elemtest.setNext(elemtest2);
    assertEquals(elemtest2, elemtest.getNext());
  }
}
