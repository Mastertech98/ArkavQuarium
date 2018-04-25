import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PiranhaTest {
  private Aquarium aqtest1 = new Aquarium(50, 50, 100, 10);
  private Aquarium aqtest2 = new Aquarium(60, 60, 100, 10);

  private Piranha test1 = new Piranha(aqtest1);
  private Piranha test2 = new Piranha(aqtest2);

  private Guppy guppy = new Guppy(aqtest1);

  @Test
  public void isEat() throws Exception {
    guppy.setPosition(new Vector2(1000, 1000));
    aqtest1.add(guppy);
    aqtest1.add(test1);
    assertEquals("Piranha not going to eat",
        guppy.getPosition(), aqtest1.getPiranhas().getFirst().getData().eat());
  }

  @Test
  public void isDestruct() throws Exception {
    aqtest1.add(test1);

    test1.destruct();
    assertEquals(-1, aqtest1.getPiranhas().find(test1));
  }
}
