import static org.junit.Assert.*;

import org.junit.Test;

import driver.Aquarium;
import driver.Vector2;

public class AquariumTest {
	private Aquarium aqtest = new Aquarium(50,50,100,10);
	private Aquarium aqtest2 = new Aquarium(50,50,100,10);
	private Vector2 vectest = new Vector2(48,48);
	private Guppy guppytest = new Guppy(aqtest);
	private Piranha piranhatest = new Piranha(aqtest);
	private Snail snailtest = new Snail(aqtest);
	private Coin cointest = new Coin(aqtest,vectest,10);
	private Food foodtest = new Food(aqtest,2);
	
	@Test
	public void getSizeXTest() {
		assertEquals(50,aqtest.getSizeX(),0);
	}
	
	@Test
	public void getSizeYTest() {
		assertEquals(50,aqtest.getSizeY(),0);
	}

	@Test
	public void getGameTimeTest() {
		assertEquals(0,aqtest.getGameTime(),0);
	}
	
	@Test
	public void linkedListGetterTest() {
		assertNotNull(aqtest.getGuppies());
		assertNotNull(aqtest.getPiranhas());
		assertNotNull(aqtest.getSnails());
		assertNotNull(aqtest.getFoods());
		assertNotNull(aqtest.getCoins());
	}
	
	@Test
	public void getMoneyTest() {
		assertEquals(100,aqtest.getMoney(),0);
	}
	
	@Test
	public void getEggTest() {
		assertEquals(0,aqtest.getEgg(),0);
	}
	
	@Test
	public void getEggPriceTest() {
		assertEquals(10,aqtest.getEggPrice());
	}
	
	@Test
	public void setGameTimeTest() {
		aqtest.setGameTime(192);
		assertEquals(192,aqtest.getGameTime(),0);
	}
	
	@Test
	public void setMoneyTest() {
		aqtest.setMoney(168);
		assertEquals(168,aqtest.getMoney(),0);
	}
	
	@Test
	public void setEggTest() {
		aqtest.setEgg(11);
		assertEquals(11,aqtest.getEgg(),0);
	}
	
	@Test
	public void setEggPriceTest() {
		aqtest.setEggPrice(19216811);
		assertEquals(19216811,aqtest.getEggPrice());
	}
	
	@Test
	public void linkedListAdderTest() {
		aqtest.add(guppytest);
		aqtest.add(piranhatest);
		aqtest.add(snailtest);
		aqtest.add(cointest);
		aqtest.add(foodtest);
		assertNotNull(aqtest.getGuppies().getFirst());
		assertNotNull(aqtest.getPiranhas().getFirst());
		assertNotNull(aqtest.getSnails().getFirst());
		assertNotNull(aqtest.getFoods().getFirst());
		assertNotNull(aqtest.getCoins().getFirst());
	}
	
	@Test
	public void linkedListRemoverTest() {
		aqtest2.add(guppytest);
		aqtest2.remove(guppytest);
		aqtest2.add(piranhatest);
		aqtest2.remove(piranhatest);
		aqtest2.remove(aqtest2.getSnails().getFirst().getData());
		aqtest2.add(cointest);
		aqtest2.remove(cointest);
		aqtest2.add(foodtest);
		aqtest2.remove(foodtest);
		assertNull(aqtest2.getGuppies().getFirst());
		assertNull(aqtest2.getPiranhas().getFirst());
		assertNull(aqtest2.getSnails().getFirst());
		assertNull(aqtest2.getFoods().getFirst());
		assertNull(aqtest2.getCoins().getFirst());
	}
	
	@Test
	public void tickTest() {
		int curGameTime = aqtest.getGameTime();
		aqtest.tick();
		assertEquals(curGameTime+1,aqtest.getGameTime(),0);
	}
	
}
