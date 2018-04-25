public abstract class AquariumObject {
  private final Aquarium aquarium;
  private final float speed;
  private Vector2 position;

  public AquariumObject(Aquarium aquarium, float speed, Vector2 position) {
    this.aquarium = aquarium;
    this.speed = speed;
    this.position = position;
  }

  public Aquarium getAquarium() {
    return aquarium;
  }

  public float getSpeed() {
    return speed;
  }

  public Vector2 getPosition() {
    return position;
  }

  public void setPosition(Vector2 position) {
    this.position = position;
  }

  public abstract void move();

  public void tick() {
    move();
  }
}