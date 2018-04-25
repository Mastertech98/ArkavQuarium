public class Food extends AquariumObject implements IDestructible {
  /**
   * Food's price.
   */
  public static final int price = 5;

  /**
   * Constructor: instantiate food on top of aquarium.
   * @param aquarium object aquarium which will be added by food and will be initialized
   * @param abscissa food's horizontal position
   */
  public Food(Aquarium aquarium, double abscissa) {
    super(aquarium, 2, new Vector2(abscissa, 0));
  }

  /**
   * Move this food to the bottom and destruct itself on touching aquarium's floor.
   */
  public void move() {
    setPosition(getPosition().add(Vector2.down.multiply(getSpeed())));
  }

  /**
   * Do one game time unit.
   * Destruct upon touching aquarium floor
   */
  public void tick() {
    move();
    if (getPosition().ordinate >= getAquarium().getSizeY()) {
      destruct();
    }
  }

  /**
   * Destruct this food.
   */
  public void destruct() {
    getAquarium().remove(this);
  }
}