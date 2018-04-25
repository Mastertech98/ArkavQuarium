public abstract class Creature extends AquariumObject {
  private final float eatRadius;
  private boolean isMovingRight;

  public Creature(Aquarium aquarium, float speed, Vector2 position, float eatRadius) {
    super(aquarium, speed, position);
    this.eatRadius = eatRadius;
    isMovingRight = true;
  }

  public float getEatRadius() {
    return eatRadius;
  }

  public boolean getIsMovingRight() {
    return isMovingRight;
  }

  public void setIsMovingRight(boolean isMovingRight) {
    this.isMovingRight = isMovingRight;
  }

  public abstract Vector2 eat();
}