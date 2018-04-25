public class Coin extends AquariumObject implements IDestructible {
  /**
   * Coin's value.
   */
  private final int value;

  /**
   * Constructor.
   * @param aquarium aquarium which will be added by coin
   * @param position position of coin
   * @param value value of this coin
   */
  public Coin(Aquarium aquarium, Vector2 position, int value) {
    super(aquarium, 1, position);
    this.value = value;
  }

  /**
     * Reference comparison.
     * @param other other coin to compare
     * @return true if and only if argument represent this object
     */
  public boolean isEqual(final Coin other) {
    return this == other;
  }

  /**
   * Get value of coin.
   * @return coin's value
   */
  public int getValue() {
    return value;
  }

  /**
   * Move this coin to the bottom.
   */
  public void move() {
    if (getPosition().ordinate < getAquarium().getSizeY()) {
      if (getPosition().ordinate + getSpeed() < getAquarium().getSizeY()) {
        setPosition(getPosition().add(Vector2.down.multiply(getSpeed())));
      } else {
        setPosition(new Vector2(getPosition().abscissa, getAquarium().getSizeY()));
      }
    }
  }

  /**
   * Remove this coin from aquarium.
   */
  public void destruct() {
    getAquarium().remove(this);
  }

  /**
   * Increase money by value.
   */
  public void take() {
    getAquarium().setMoney(getAquarium().getMoney() + getValue());
    destruct();
  }

}