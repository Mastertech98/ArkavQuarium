#include "AquariumObject.hpp"

AquariumObject::AquariumObject(Aquarium& _aquarium, float _speed, Vector2 _position) : aquarium(_aquarium), speed(_speed) {
    position = _position;
}

Aquarium& AquariumObject::getAquarium() const {
    return aquarium;
}

float AquariumObject::getSpeed() const {
    return speed;
}

Vector2 AquariumObject::getPosition() const {
    return position;
}

void AquariumObject::setPosition(Vector2 _position) {
    position = _position;
}

void AquariumObject::tick() {
    move();
}