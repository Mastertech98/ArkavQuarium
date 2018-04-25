public class Guppy extends Fish {
  public static final int price = 10;

  private final int coinDropPeriod;
  private int eatenFood;
  private int lastCoinDrop;

  public Guppy(Aquarium _aquarium) {
    super(_aquarium, 5, 50);
    coinDropPeriod = 100;
    setEatenFood(0);
    setLastCoinDrop(getAquarium().getGameTime());
  }

  public int getCoinDropPeriod() {
    return coinDropPeriod;
  }

  public int getEatenFood() {
    return eatenFood;
  }

  public int getLastCoinDrop() {
    return lastCoinDrop;
  }

  public int getGrowthStage() {
    if (getEatenFood() > 4) {
      return 3;
    }

    if (getEatenFood() > 1) {
      return 2;
    }

    return 1;
  }

  public void setEatenFood(int _eatenFood) {
    eatenFood = _eatenFood;
  }

  public void setLastCoinDrop(int _lastCoinDrop) {
    lastCoinDrop = _lastCoinDrop;
  }

  public Vector2 eat() {
    Food food = findFood();
    if (food != null) {
      Vector2 foodPosition = food.getPosition();
      if (getPosition().distance(foodPosition) <= getEatRadius()) {
        setEatenFood(getEatenFood() + 1);
        food.destruct();

        int gameTime = getAquarium().getGameTime();
        setLastMealTime(gameTime);
        setLastMoveTime(gameTime);

        return null;
      } else {
        return foodPosition;
      }
    } else {
      return null;
    }
  }

  public void destruct() {
    getAquarium().remove(this);
  }

  public void tick() {
    int gameTime = getAquarium().getGameTime();

    if (gameTime >= getLastCoinDrop() + getCoinDropPeriod()) {
      dropCoin(2 * getGrowthStage());
      setLastCoinDrop(gameTime);
    }

    super.tick();
  }

  private Food findFood() {
    LinkedList<Food> foods = getAquarium().getFoods();
    if (foods.isEmpty()) {
      return null;
    } else {
      Vector2 guppyPosition = getPosition();
      ElementList<Food> food = foods.getFirst();
      double foodDistance = guppyPosition.distance(food.getData().getPosition());
      for (ElementList<Food> e = food.getNext(); e != null; e = e.getNext()) {
        double eDistance = guppyPosition.distance(e.getData().getPosition());
        if (eDistance < foodDistance) {
          food = e;
          foodDistance = eDistance;
        }
      }
      return food.getData();
    }
  }
}