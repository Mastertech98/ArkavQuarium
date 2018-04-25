import java.lang.*;

public class Snail extends Creature {

  public Snail(Aquarium _aquarium) {
    super(_aquarium, 3, new Vector2((double) _aquarium.getSizeX() / 2, _aquarium.getSizeY()), 50);
  }

  public boolean equals(final Snail other) {
    return this == other;
  }

  public void move() {
    Vector2 coinPosition = eat();
    if (coinPosition != null) {
      double fX = coinPosition.x;
      double sX = getPosition().x;
      Vector2 direction = new Vector2(Math.abs(fX - sX) < 0.05 * getSpeed() ? 0 : fX > sX ? 1 : -1, 0);
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
        Vector2 ePosition = e.getData().getPosition();

        if (coinPriority.onFloor) {
          if (ePosition.y == aquariumSizeY) {
            double eDistance = Math.abs(ePosition.x - getPosition().x);
            if (eDistance < coinPriority.distance) {
              coin = e;
              coinPriority.distance = eDistance;
            }
          }
        } else {
          if (ePosition.y == aquariumSizeY) {
            coin = e;
            coinPriority.onFloor = true;
            coinPriority.distance = Math.abs(ePosition.x - getPosition().x);
          } else {
            double eDistance = aquariumSizeY - ePosition.y;
            if (eDistance < coinPriority.distance) {
              coin = e;
              coinPriority.distance = eDistance;
            }
          }
        }
      }
      return coin.getData();
    }
  }
}
