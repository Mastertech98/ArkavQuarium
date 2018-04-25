import static org.junit.Assert.*;

import org.junit.Test;

public class CoinTest {
	private Aquarium aqtest = new Aquarium(50,50,100,10);
	private Vector2 vectest = new Vector2(48,48);
	private Coin test1 = new Coin(aqtest,vectest,10);
	private Coin test2 = new Coin(aqtest,vectest,10);
	
	@Test
	public void getValueTest() {
		//getValue
		assertEquals(10,test1.getValue(),0);
	}
	
	@Test
	public void isEqualTest() {
		//isEqual
		assertTrue(test1.isEqual(test1));	
	}
	
	@Test
	public void destructTest() {
		aqtest.add(test2);
		test2.destruct();
		assertEquals(-1, aqtest.getCoins().find(test2));
	}
	
	@Test
	public void takeTest() {
		Aquarium aqtest = new Aquarium(50,50,100,10);
		Vector2 vectest = new Vector2(48,48);
		Coin test1 = new Coin(aqtest,vectest,10);
		int curMoney = aqtest.getMoney();
		int coinVal = test1.getValue();
		test1.take();
		assertEquals(curMoney+coinVal,test1.getAquarium().getMoney());
		//destruct()
		assertEquals(-1, aqtest.getCoins().find(test1));
	}
}
