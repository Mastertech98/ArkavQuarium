public class Guppy extends Fish {
  public static final int price = 10;

  private final int coinDropPeriod;
  private int eatenFood;
  private int lastCoinDrop;

  /**
   * Constructor: instantiate guppy at speed of 5 and eatRadius of 50.
   * @param aquarium object aquarium which will be added by guppy and will be initialized
   */
  public Guppy(Aquarium aquarium) {
    super(aquarium, 5, 50);
    coinDropPeriod = 100;
    setEatenFood(0);
    setLastCoinDrop(getAquarium().getGameTime());
  }

  /**
   * Get coin drop period.
   * @return coin drop period
   */
  public int getCoinDropPeriod() {
    return coinDropPeriod;
  }

  /**
   * Get the number of this guppy's eaten food.
   * @return the number of this guppy's eaten food
   */
  public int getEatenFood() {
    return eatenFood;
  }

  /**
   * Get the last time this guppy drops coin.
   * @return the last time this guppy drops coin
   */
  public int getLastCoinDrop() {
    return lastCoinDrop;
  }

  /**
   * Get the growth stage of this guppy based on this guppy's eaten food.
   * @return the growth stage of this guppy based on this guppy's eaten food
   */
  public int getGrowthStage() {
    if (getEatenFood() > 4) {
      return 3;
    }

    if (getEatenFood() > 1) {
      return 2;
    }

    return 1;
  }

  /**
   * The number of this guppy's eaten food.
   * @param eatenFood the number of this guppy's eaten food
   */
  public void setEatenFood(int eatenFood) {
    this.eatenFood = eatenFood;
  }

  /**
   * the last time this guppy drops coin.
   * @param lastCoinDrop the last time this guppy drops coin
   */
  public void setLastCoinDrop(int lastCoinDrop) {
    this.lastCoinDrop = lastCoinDrop;
  }

  /**
   * Find food in the aquarium.
   * @return food position
   */
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

  /**
   * Remove this guppy from aquarium.
   */
  public void destruct() {
    getAquarium().remove(this);
  }

  /**
   * Do one game time unit.
   * Drops coin on coin drop period
   */
  public void tick() {
    int gameTime = getAquarium().getGameTime();

    if (gameTime >= getLastCoinDrop() + getCoinDropPeriod()) {
      dropCoin(2 * getGrowthStage());
      setLastCoinDrop(gameTime);
    }

    super.tick();
  }

  /**
   * Get food which will be eaten by guppy.
   * @return food's data
   */
  private Food findFood() {
    LinkedList<Food> foods = getAquarium().getFoods();
    if (foods.isEmpty()) {
      return null;
    } else {
      Vector2 guppyPosition = getPosition();
      ElementList<Food> food = foods.getFirst();
      double foodDistance = guppyPosition.distance(food.getData().getPosition());
      for (ElementList<Food> e = food.getNext(); e != null; e = e.getNext()) {
        double elementDistance = guppyPosition.distance(e.getData().getPosition());
        if (elementDistance < foodDistance) {
          food = e;
          foodDistance = elementDistance;
        }
      }
      return food.getData();
    }
  }
}