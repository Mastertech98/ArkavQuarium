public class Snail extends Creature {

  public Snail(Aquarium aquarium) {
    super(aquarium, 3, new Vector2((double) aquarium.getSizeX() / 2, aquarium.getSizeY()), 50);
  }

  public boolean equals(final Snail other) {
    return this == other;
  }

  public void move() {
    Vector2 coinPosition = eat();
    if (coinPosition != null) {
      double foodX = coinPosition.x;
      double snailX = getPosition().x;
      Vector2 direction = new Vector2(Double.compare(foodX, snailX), 0);
      setPosition(getPosition().add(direction.multiply(getSpeed())));
      setIsMovingRight(direction.x >= 0);
    }
  }

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
      if (coinPosition.y == aquariumSizeY) {
        coinPriority.onFloor = true;
        coinPriority.distance = Math.abs(coinPosition.x - getPosition().x);
      } else {
        coinPriority.onFloor = false;
        coinPriority.distance = aquariumSizeY - coinPosition.y;
      }

      for (ElementList<Coin> e = coin.getNext(); e != null; e = e.getNext()) {
        Vector2 elementPosition = e.getData().getPosition();

        if (coinPriority.onFloor) {
          if (elementPosition.y == aquariumSizeY) {
            double elementDistance = Math.abs(elementPosition.x - getPosition().x);
            if (elementDistance < coinPriority.distance) {
              coin = e;
              coinPriority.distance = elementDistance;
            }
          }
        } else {
          if (elementPosition.y == aquariumSizeY) {
            coin = e;
            coinPriority.onFloor = true;
            coinPriority.distance = Math.abs(elementPosition.x - getPosition().x);
          } else {
            double elementDistance = aquariumSizeY - elementPosition.y;
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
