public abstract class Fish extends Creature implements IDestructible {
    private final int fullTime;
    private final int hungryTime;
    private final int moveTime;

    private int lastMealTime;
    private int lastMoveTime;

    private Vector2 direction;

    public Fish(Aquarium _aquarium, float _speed, float _eatRadius) {
        super(
            _aquarium, 
            _speed, 
            Vector2.randomPosition(_aquarium.getSizeX(), _aquarium.getSizeY()), 
            _eatRadius
        );

        fullTime = 500;
        hungryTime = 500;
        moveTime = 50;

        int gameTime = getAquarium().getGameTime();
        setLastMealTime(gameTime);
        setLastMoveTime(gameTime);
        direction = Vector2.randomDirection();
    }

    public int getFullTime() {
        return fullTime;
    }
    public int getHungryTime() {
        return hungryTime;
    }
    public int getMoveTime() {
        return moveTime;
    }
    public int getLastMealTime() {
        return lastMealTime;
    }
    public int getLastMoveTime() {
        return lastMoveTime;
    }
    public Vector2 getDirection() {
        return direction;
    }

    public void setLastMealTime(int _lastMealTime) {
        lastMealTime = _lastMealTime;
    }
    public void setLastMoveTime(int _lastMoveTime) {
        lastMoveTime = _lastMoveTime;
    }

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
        setIsMovingRight(direction.x >= 0);
    }

    public void dropCoin(int value) {
        getAquarium().add(new Coin(getAquarium(), getPosition(), value));
    }

    public void tick() {
        super.tick();

        if (getAquarium().getGameTime() >= getLastMealTime() + getFullTime() + getHungryTime()) {
            destruct();
        }
    }
    
    private void moveRandomly() {
        if (getAquarium().getGameTime() >= getLastMoveTime() + getMoveTime()) {
            direction = Vector2.randomDirection();
            setLastMoveTime(getAquarium().getGameTime());
        }
    
        int sizeX = getAquarium().getSizeX();
        int sizeY = getAquarium().getSizeY();
        double positionX = getPosition().x;
        double positionY = getPosition().y;
    
        int gameTime = getAquarium().getGameTime();
    
        if (positionX < 0 || positionX > sizeX) {
            direction = new Vector2(direction.x * -1, direction.y);
            setLastMoveTime(gameTime);
        }
        if (positionY < 0 || positionY > sizeY) {
            direction = new Vector2(direction.x, direction.y * -1);
            setLastMoveTime(gameTime);
        }
    }
}