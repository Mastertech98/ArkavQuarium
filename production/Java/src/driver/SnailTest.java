//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import java.lang.String;

import junit.framework.Assert;
import org.junit.Assert.*;
import org.junit.Test;
//import org.junit.runner.RunWith;
import java.util.Scanner;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class SnailTest {
    private Aquarium aqtest1 = new Aquarium(10,20,1000,10);
    private Aquarium aqtest2 = new Aquarium(20,30,1000,10);

    private Snail test1 = new Snail(aqtest1);
    private Snail test2 = new Snail(aqtest2);

    private Vector2 pos = new Vector2(100,100);
    private Coin coin = new Coin(aqtest1, pos, 10);

    private int coinx = 40;
    private Vector2 vectest2 = new Vector2(coinx,49);
    private Coin testcoin = new Coin(aqtest1,vectest2,10);

    @Test
    public void isEquals() throws Exception {
        assertFalse("It should be false", test1.equals(test2));
    }

    @Test
    public void isMove() throws Exception {
        double a = test1.getPosition().abscissa;


        aqtest1.add(testcoin);

        test1.move();

        double b = test1.getPosition().abscissa;

        assertNotEquals("Snail didn't move", b, a); //assertequals buat double ga bsa d pake

    }

    @Test
    public void isEat() throws Exception{
        aqtest1.add(testcoin);
        aqtest1.add(test1);
        assertEquals("Snail not going to eat", testcoin.getPosition(), aqtest1.getSnails().getFirst().getData().eat());
    }

    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Snail.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

}
