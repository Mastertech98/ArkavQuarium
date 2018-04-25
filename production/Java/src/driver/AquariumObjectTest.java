import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AquariumObjectTest {
  private Aquarium aqtest1 = new Aquarium(50, 50, 100, 10);
  private Aquarium aqtest2 = new Aquarium(60, 60, 100, 10);

  private Guppy guppy = new Guppy(aqtest1);

  @Test
  public void getAquarium() throws Exception {
    assertEquals(aqtest1, guppy.getAquarium());
  }

  @Test
  public void getSpeed() throws Exception {
    assertEquals(5, guppy.getSpeed(), 0);
  }

  @Test
  public void getPosition() throws Exception {
    assertTrue(guppy.getPosition().abscissa <= guppy.getAquarium().getSizeX());
    assertTrue(guppy.getPosition().ordinate <= guppy.getAquarium().getSizeY());
  }

  @Test
  public void setPosition() throws Exception {
    Vector2 pos = new Vector2(3.3, 4.4);
    guppy.setPosition(pos);
    assertEquals(3.3, guppy.getPosition().abscissa, 0);
    assertEquals(4.4, guppy.getPosition().ordinate, 0);
  }

  @Test
  public void tick() throws Exception {

    Vector2 a = guppy.getPosition();

    guppy.tick();

    Vector2 b = guppy.getPosition();
    assertNotEquals("Guppy is not moving", b, a);
  }
}
