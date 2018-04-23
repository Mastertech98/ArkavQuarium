public abstract class AquariumObject{
    private Aquarium aquarium;
    private final float speed;
    private Vector2 position;

    public AquariumObject(Aquarium _aquarium, float _speed, Vector2 _position){
        aquarium = _aquarium;
        speed = _speed;
        position = _position;
    }

    public Aquarium getAquarium(){
        return aquarium;
    }

    public float getSpeed(){
        return speed;
    }

    public Vector2 getPosition(){
        return position;
    }

    public void setPosition(Vector2 _position){
        position = _position;
    }

    public abstract void move();

    public void tick(){
        move();
    }
}