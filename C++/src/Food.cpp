#include "Food.hpp"
#include "Aquarium.hpp"

const int Food::price = 5;

Food::Food(Aquarium& _aquarium, float x) : AquariumObject(_aquarium, 2, Vector2(x, 0)) {
    
}

bool Food::operator==(const Food& other) const {
    return this == &other;
}

void Food::move() {
    setPosition(getPosition() + Vector2::down * getSpeed());
}

void Food::destruct() {
    getAquarium().remove(*this);
}

void Food::tick() {
    move();
    if (getPosition().y >= getAquarium().getSizeY()) {
        destruct();
    }
}
