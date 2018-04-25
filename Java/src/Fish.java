public abstract class Fish extends Creature implements IDestructible {
  /**
   * Save fish's full time
   */
  private final int fullTime;
  /**
   * Save fish's hungry time
   */
  private final int hungryTime;
  /**
   * Save fish's move time
   */
  private final int moveTime;
  /**
   * Save fish's last meal time
   */
  private int lastMealTime;
  /**
   * Save fish's last move time
   */
  private int lastMoveTime;
  /**
   * Save fish's direction
   */
  private Vector2 direction;

  /**
   * Constructor: instantiate fish at random position.
   * @param aquarium object aquarium which will be added by fish and will be initialized
   * @param speed fish speed which will be initialized
   * @param eatRadius fish eat radius which will be initialized
   */
  public Fish(Aquarium aquarium, float speed, float eatRadius) {
    super(
      aquarium, speed, Vector2.randomPosition(aquarium.getSizeX(), aquarium.getSizeY()), eatRadius);

    fullTime = 500;
    hungryTime = 500;
    moveTime = 50;

    int gameTime = getAquarium().getGameTime();
    setLastMealTime(gameTime);
    setLastMoveTime(gameTime);
    direction = Vector2.randomDirection();
  }

  /**
   * Get the duration of this fish full before hungry again.
   * @return the duration of this fish full before hungry again
   */
  public int getFullTime() {
    return fullTime;
  }

  /**
   * Get the duration of this fish hungry before it dies.
   * @return the duration of this fish hungry before it dies
   */
  public int getHungryTime() {
    return hungryTime;
  }

  /**
   * Get the duration of this fish moving before changing direction.
   * @return the duration of this fish moving before changing direction
   */
  public int getMoveTime() {
    return moveTime;
  }

  /**
   * Get the last time this fish eats.
   * @return the last time this fish eats
   */
  public int getLastMealTime() {
    return lastMealTime;
  }

  /**
   * Get the last time this fish moves.
   * @return the last time this fish moves
   */
  public int getLastMoveTime() {
    return lastMoveTime;
  }

  /**
   * Set the last time this fish eats.
   * @param lastMealTime the last time this fish eats
   */
  public void setLastMealTime(int lastMealTime) {
    this.lastMealTime = lastMealTime;
  }

  /**
   * Set the last time this fish moves.
   * @param lastMoveTime the last time this fish moves
   */
  public void setLastMoveTime(int lastMoveTime) {
    this.lastMoveTime = lastMoveTime;
  }

  /**
   * Move towards food if this fish is hungry and food exist, move randomly otherwise.
   */
  public void move() {
    int gameTime = getAquarium().getGameTime();
    if (gameTime >= getLastMealTime() + getFullTime()) {
      Vector2 foodPosition = eat();
      if (foodPosition != null) {
        direction = foodPosition.subtract(getPosition()).normalized();
      } else {
        moveRandomly();
      }
    } else {
      moveRandomly();
    }

    setPosition(getPosition().add(direction.multiply(getSpeed())));
    setIsMovingRight(direction.abscissa >= 0);
  }

  /**
   * Drop coin from this fish.
   * @param value the coin's value
   */
  public void dropCoin(int value) {
    getAquarium().add(new Coin(getAquarium(), getPosition(), value));
  }

  /**
   * Do one game time unit.
   * Dies if gameTime is greater than or equals the last time this fish eats
   * plus the duration of this fish full before hungry again
   * plus the duration of this fish hungry before it dies
   */
  public void tick() {
    super.tick();

    if (getAquarium().getGameTime() >= getLastMealTime() + getFullTime() + getHungryTime()) {
      destruct();
    }
  }

  /**
   * Move fish to new direction.
   */
  private void moveRandomly() {
    if (getAquarium().getGameTime() >= getLastMoveTime() + getMoveTime()) {
      direction = Vector2.randomDirection();
      setLastMoveTime(getAquarium().getGameTime());
    }

    int sizeX = getAquarium().getSizeX();
    int sizeY = getAquarium().getSizeY();
    double positionX = getPosition().abscissa;
    double positionY = getPosition().ordinate;

    int gameTime = getAquarium().getGameTime();

    if (positionX < 0 || positionX > sizeX) {
      direction = new Vector2(direction.abscissa * -1, direction.ordinate);
      setLastMoveTime(gameTime);
    }
    if (positionY < 0 || positionY > sizeY) {
      direction = new Vector2(direction.abscissa, direction.ordinate * -1);
      setLastMoveTime(gameTime);
    }
  }
}