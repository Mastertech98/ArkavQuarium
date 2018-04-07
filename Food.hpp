#ifndef FOOD_HPP
#define FOOD_HPP

#include "AquariumObject.hpp"
#include "IDestructible.hpp"

class Food : public AquariumObject, public IDestructible {
    public:
        Food(Aquarium& _aquarium, float x);

        bool operator==(const Food& other) const;

        void move();

        void destruct();
};

#endif