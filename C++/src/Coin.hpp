#ifndef COIN_HPP
#define COIN_HPP

#include "AquariumObject.hpp"
#include "IDestructible.hpp"

class Coin : public AquariumObject, public IDestructible {
    public:
        /// Constructor
        Coin(Aquarium& _aquarium, Vector2 _position, int _value);

        /// Reference comparison
        bool operator==(const Coin& other) const;
        
        /// Return coin's value
        int getValue() const;

        /// Move this coin to the bottom
        void move();
        /// Remove this coin from aquarium
        void destruct();
        /// Increase money by value
        void take();

    private:
        const int value;
};

#endif