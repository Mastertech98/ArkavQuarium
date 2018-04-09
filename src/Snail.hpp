#ifndef SNAIL_HPP
#define SNAIL_HPP

#include "Fish.hpp"
#include "Coin.hpp"

class Snail : public Creature {
    public:
        Snail(Aquarium& _aquarium);

        bool operator==(const Snail& other) const ;

        void move();

        Vector2 eat();
    
    private:
        Coin* findCoin() const;
};

#endif