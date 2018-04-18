#ifndef SNAIL_HPP
#define SNAIL_HPP

#include "Fish.hpp"
#include "Coin.hpp"

class Snail : public Creature {
    public:
        /// Constructor: instantiate snail on the bottom middle of the aquarium, speed of 3, and eatRadius of 50
        Snail(Aquarium& _aquarium);

        /// Reference comparison
        bool operator==(const Snail& other) const ;

        /// Move horizontally
        void move();

        /// Find coin in the aquarium
        Vector2 eat();
    
    private:
        Coin* findCoin() const;
};

#endif