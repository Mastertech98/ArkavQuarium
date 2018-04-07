#include "Fish.hpp"
#include "Aquarium.hpp"

Fish::Fish(Aquarium& _aquarium, float _speed, float _eatRadius) : Creature(_aquarium, _speed, Vector2::randomPosition(_aquarium.getSizeX(), _aquarium.getSizeY()), _eatRadius), fullTime(100), hungryTime(100), moveTime(50) {
    int gameTime = _aquarium.getGameTime();
    setLastMealTime(gameTime);
    setLastMoveTime(gameTime);
    direction = Vector2::randomDirection();
}

int Fish::getFullTime() const {
    return fullTime;
}
int Fish::getHungryTime() const {
    return hungryTime;
}
int Fish::getMoveTime() const {
    return moveTime;
}
int Fish::getLastMealTime() const {
    return lastMealTime;
}
int Fish::getLastMoveTime() const {
    return lastMoveTime;
}

void Fish::setLastMealTime(int _lastMealTime) {
    lastMealTime = _lastMealTime;
}
void Fish::setLastMoveTime(int _lastMoveTime) {
    lastMoveTime = _lastMoveTime;
}

void Fish::move() {
    int gameTime = getAquarium().getGameTime();
    if (gameTime >= getLastMealTime() + getFullTime()) {
        Vector2 foodPosition = eat();
        if (foodPosition != Vector2::null) {
            direction = (foodPosition - getPosition()).normalized();
        } else {
            moveRandomly();
        }
    } else {
        moveRandomly();
    }

    int sizeX = getAquarium().getSizeX();
    int sizeY = getAquarium().getSizeY();
    int positionX = getPosition().x;
    int positionY = getPosition().y;

    if (positionX < 0 || positionX > sizeX) {
        direction = Vector2(direction.x * -1, direction.y);
        setLastMoveTime(gameTime);
    }
    if (positionY < 0 || positionY > sizeY) {
        direction = Vector2(direction.x, direction.y * -1);
        setLastMoveTime(gameTime);
    }
    
    setPosition(getPosition() + direction * getSpeed());
    setIsMovingRight(direction.x >= 0);
}

void Fish::dropCoin(int value) {
    getAquarium().add(Coin(getAquarium(), getPosition(), value));
}

void Fish::moveRandomly() {
    if (getAquarium().getGameTime() >= getLastMoveTime() + getMoveTime()) {
        std::cout << "Random direction" << std::endl;
        direction = Vector2::randomDirection();
        setLastMoveTime(getAquarium().getGameTime());
    }
}