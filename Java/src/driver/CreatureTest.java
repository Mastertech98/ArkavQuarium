import static org.junit.Assert.*;

import org.junit.Test;

public class CreatureTest {
	private Aquarium aqtest = new Aquarium(50,50,100,10);
	private Snail snailtest = new Snail(aqtest);

	@Test
	public void getEatRadiusTest() {
		assertEquals(50,snailtest.getEatRadius(),0);
	}
	
	@Test
	public void getIsMovingRightTest() {
		assertTrue(snailtest.getIsMovingRight());
	}
	
	@Test
	public void setIsMovingRightTest() {
		snailtest.setIsMovingRight(false);
		assertFalse(snailtest.getIsMovingRight());
	}
}
