public abstract class Creature extends AquariumObject {
  private final float eatRadius;
  private boolean isMovingRight;

  public Creature(Aquarium _aquarium, float _speed, Vector2 _position, float _eatRadius) {
    super(_aquarium, _speed, _position);
    eatRadius = _eatRadius;
    isMovingRight = true;
  }

  public float getEatRadius() {
    return eatRadius;
  }

  public boolean getIsMovingRight() {
    return isMovingRight;
  }

  public void setIsMovingRight(boolean _isMovingRight) {
    isMovingRight = _isMovingRight;
  }

  public abstract Vector2 eat();
}