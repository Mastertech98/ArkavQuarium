public abstract class AquariumObject {
  /**
   * Reference to aquarium.
   */
  private final Aquarium aquarium;
  /**
   * This object's speed.
   */
  private final float speed;
  /**
   * This object's position.
   */
  private Vector2 position;

  /**
   * Constructor.
   * @param aquarium aquarium which will be added by object
   * @param speed speed of object
   * @param position start position of object
   */
  public AquariumObject(Aquarium aquarium, float speed, Vector2 position) {
    this.aquarium = aquarium;
    this.speed = speed;
    this.position = position;
  }

  /**
   * Get reference to aquarium of this AquariumObject.
   * @return reference to aquarium of this AquariumObject
   */
  public Aquarium getAquarium() {
    return aquarium;
  }

  /**
   * Get object speed.
   * @return speed
   */
  public float getSpeed() {
    return speed;
  }

  /**
   * Get object position.
   * @return position
   */
  public Vector2 getPosition() {
    return position;
  }

  /**
   * Set position of object.
   * @param position a new position of object
   */
  public void setPosition(Vector2 position) {
    this.position = position;
  }

  /**
   * Abstract function to move.
   */
  public abstract void move();

  /**
   * Do one game time unit.
   * Moves
   */
  public void tick() {
    move();
  }
}