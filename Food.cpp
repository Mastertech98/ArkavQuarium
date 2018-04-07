#include "Food.hpp"
#include "Aquarium.hpp"

Food::Food(Aquarium& _aquarium, float x) : AquariumObject(_aquarium, 2, Vector2(x, 0)) {
    
}

bool Food::operator==(const Food& other) const {
    return this == &other;
}

void Food::move() {
    setPosition(getPosition() + Vector2::down * getSpeed());
    if (getPosition().y >= getAquarium().getSizeY()) {
        destruct();
    }
}

void Food::destruct() {
    getAquarium().remove(*this);
}