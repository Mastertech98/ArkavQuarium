public class Snail extends Creature {

  /**
	 * Constructor: instantiate snail on the bottom middle of the aquarium, speed of 3, and eatRadius of 50
	 * @param aquarium object aquarium which will be added by piranha and will be initialized
	 */
  public Snail(Aquarium aquarium) {
    super(aquarium, 3, new Vector2((double) aquarium.getSizeX() / 2, aquarium.getSizeY()), 50);
  }

  /**
     * Reference comparison
     * @param other other snail to compare
     * @return true if and only if argument represent this snail
     */
  public boolean equals(final Snail other) {
    return this == other;
  }

  /**
     * Move horizontally
     */
  public void move() {
    Vector2 coinPosition = eat();
    if (coinPosition != null) {
      double foodX = coinPosition.abscissa;
      double snailX = getPosition().abscissa;
      Vector2 direction = new Vector2(Double.compare(foodX, snailX), 0);
      setPosition(getPosition().add(direction.multiply(getSpeed())));
      setIsMovingRight(direction.abscissa >= 0);
    }
  }

  /**
     * Find coin in the aquarium
     * @return coin's position
     */
  public Vector2 eat() {
    Coin coin = findCoin();
    if (coin != null) {
      Vector2 coinPosition = coin.getPosition();
      for (ElementList<Coin> e = getAquarium().getCoins().getFirst(); e != null; e = e.getNext()) {
        if (getPosition().distance(e.getData().getPosition()) <= getEatRadius()) {
          e.getData().take();
        }
      }
      return coinPosition;
    } else {
      return null;
    }
  }

  /**
     * Get coin which will be get by snail
     * @return coin's data
     */
  private Coin findCoin() {
    LinkedList<Coin> coins = getAquarium().getCoins();
    if (coins.isEmpty()) {
      return null;
    } else {
      class Priority {
        boolean onFloor;
        double distance;
      }

      double aquariumSizeY = getAquarium().getSizeY();
      ElementList<Coin> coin = coins.getFirst();
      Vector2 coinPosition = coin.getData().getPosition();

      Priority coinPriority = new Priority();
      if (coinPosition.ordinate == aquariumSizeY) {
        coinPriority.onFloor = true;
        coinPriority.distance = Math.abs(coinPosition.abscissa - getPosition().abscissa);
      } else {
        coinPriority.onFloor = false;
        coinPriority.distance = aquariumSizeY - coinPosition.ordinate;
      }

      for (ElementList<Coin> e = coin.getNext(); e != null; e = e.getNext()) {
        Vector2 elementPosition = e.getData().getPosition();

        if (coinPriority.onFloor) {
          if (elementPosition.ordinate == aquariumSizeY) {
            double elementDistance = Math.abs(elementPosition.abscissa - getPosition().abscissa);
            if (elementDistance < coinPriority.distance) {
              coin = e;
              coinPriority.distance = elementDistance;
            }
          }
        } else {
          if (elementPosition.ordinate == aquariumSizeY) {
            coin = e;
            coinPriority.onFloor = true;
            coinPriority.distance = Math.abs(elementPosition.abscissa - getPosition().abscissa);
          } else {
            double elementDistance = aquariumSizeY - elementPosition.ordinate;
            if (elementDistance < coinPriority.distance) {
              coin = e;
              coinPriority.distance = elementDistance;
            }
          }
        }
      }
      return coin.getData();
    }
  }
}
