#ifndef COIN_HPP
#define COIN_HPP

#include "AquariumObject.hpp"
#include "IDestructible.hpp"

class Coin : public AquariumObject, public IDestructible {
    public:
        Coin(Aquarium& _aquarium, Vector2 _position, int _value);

        bool operator==(const Coin& other) const;
        
        int getValue() const;

        void move();

        void destruct();

    private:
        const int value;
};

#endif