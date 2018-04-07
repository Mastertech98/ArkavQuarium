#include "Coin.hpp"
#include "Aquarium.hpp"

Coin::Coin(Aquarium& _aquarium, Vector2 _position, int _value) : AquariumObject(_aquarium, 1, _position), value(_value) {
    
}

bool Coin::operator==(const Coin& other) const {
    return this == &other;
}
        
int Coin::getValue() const {
    return value;
}

void Coin::move() {
    if (getPosition().y < getAquarium().getSizeY()) {
        if (getPosition().y + getSpeed() < getAquarium().getSizeY())
            setPosition(getPosition() + Vector2::down * getSpeed());
        else {
            setPosition(Vector2(getPosition().x, getAquarium().getSizeY()));
        }
    }
}

void Coin::destruct() {
    getAquarium().remove(*this);
}