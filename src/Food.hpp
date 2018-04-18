#ifndef FOOD_HPP
#define FOOD_HPP

#include "AquariumObject.hpp"
#include "IDestructible.hpp"

class Food : public AquariumObject, public IDestructible {
    public:
        /// Constructor: instantiate food on top of aquarium
        Food(Aquarium& _aquarium, float x);

        /// Reference comparison
        bool operator==(const Food& other) const;

        /// Move this food to the bottom and destruct itself on touching aquarium's floor
        void move();

        /// Remove this food from aquarium
        void destruct();
    
        /// Do one game time unit: destruct upon touching aquarium floor
        void tick();

        static const int price;
};

#endif
