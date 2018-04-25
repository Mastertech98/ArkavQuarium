public class Coin extends AquariumObject implements IDestructible {
  private final int value;

  /// Constructor
  public Coin(Aquarium _aquarium, Vector2 _position, int _value) {
    super(_aquarium, 1, _position);
    value = _value;
  }

  /// Reference comparison
  public boolean isEqual(final Coin other) {
    return this == other;
  }

  /// Return coin's value
  public int getValue() {
    return value;
  }

  /// Move this coin to the bottom
  public void move() {
    if (getPosition().y < getAquarium().getSizeY()) {
      if (getPosition().y + getSpeed() < getAquarium().getSizeY()) {
        setPosition(getPosition().add(Vector2.down.multiply(getSpeed())));
      } else {
        setPosition(new Vector2(getPosition().x, getAquarium().getSizeY()));
      }
    }
  }

  /// Remove this coin from aquarium
  public void destruct() {
    getAquarium().remove(this);
  }

  /// Increase money by value
  public void take() {
    getAquarium().setMoney(getAquarium().getMoney() + getValue());
    destruct();
  }

}