import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {
  private LinkedList<Coin> test1 = new LinkedList<Coin>();
  private Aquarium aqtest = new Aquarium(50,50,100,10);
  private Vector2 vectest = new Vector2(48,48);
  private Coin cointest = new Coin(aqtest,vectest,10);
  private Coin cointest2 = new Coin(aqtest,vectest,10);

  @Test
  public void isEmptyTest() {
    assertTrue(test1.isEmpty());
  }

  @Test
  public void addTest() {
    test1.add(cointest);
    assertEquals(cointest, test1.get(0));
  }

  @Test
  public void getFirstTest() {
    test1.add(cointest);
    assertEquals(cointest, test1.getFirst().getData());
  }

  @Test
  public void findTest() {
    test1.add(cointest2);
    assertEquals(0, test1.find(cointest2));
  }

  @Test
  public void removeTest() {
    test1.add(cointest);
    test1.add(cointest2);
    test1.remove(cointest);
    assertEquals(0, test1.find(cointest2));
    assertEquals(-1, test1.find(cointest));
  }

  @Test
  public void getTest() {
    test1.add(cointest);
    test1.add(cointest2);
    assertEquals(cointest2, test1.get(1));
    assertEquals(cointest, test1.get(0));
  }

}
