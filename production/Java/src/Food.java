public class Food extends AquariumObject implements IDestructible {
  public static final int price = 5;

  public Food(Aquarium aquarium, double abscissa) {
    super(aquarium, 2, new Vector2(abscissa, 0));
  }

  public void move() {
    setPosition(getPosition().add(Vector2.down.multiply(getSpeed())));
  }

  public void tick() {
    move();
    if (getPosition().ordinate >= getAquarium().getSizeY()) {
      destruct();
    }
  }

  public void destruct() {
    getAquarium().remove(this);
  }
}