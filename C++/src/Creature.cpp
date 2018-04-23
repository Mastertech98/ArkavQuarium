#include "Creature.hpp"

Creature::Creature(Aquarium& _aquarium, float _speed, Vector2 _position, float _eatRadius) : AquariumObject(_aquarium, _speed, _position), eatRadius(_eatRadius) {
    setIsMovingRight(true);
}

float Creature::getEatRadius() const {
    return eatRadius;
}

bool Creature::getIsMovingRight() const {
    return isMovingRight;
}

void Creature::setIsMovingRight(bool _isMovingRight) {
    isMovingRight = _isMovingRight;
}

