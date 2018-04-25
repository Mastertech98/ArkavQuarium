public abstract class Creature extends AquariumObject {
  private final float eatRadius;
  private boolean isMovingRight;

  /**
	 * Constructor
	 * @param aquarium aquarium which will be added by creature
	 * @param speed speed of creature
	 * @param position position of creature
	 * @param eatRadius eat radius of creature
	 */
  public Creature(Aquarium aquarium, float speed, Vector2 position, float eatRadius) {
    super(aquarium, speed, position);
    this.eatRadius = eatRadius;
    isMovingRight = true;
  }

  /**
     * Get eat radius
     * @return eat radius
     */
  public float getEatRadius() {
    return eatRadius;
  }

  /**
     * Get horizontal movement direction
     * @return x movement direction
     */
  public boolean getIsMovingRight() {
    return isMovingRight;
  }

  /**
     * Set horizontal movement direction
     * @param isMovingRight a new x movement direction
     */
  public void setIsMovingRight(boolean isMovingRight) {
    this.isMovingRight = isMovingRight;
  }

  /**
     * Abstract function of eat
     * @return target position which will be eaten
     */
  public abstract Vector2 eat();
}