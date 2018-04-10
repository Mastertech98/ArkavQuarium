#ifndef PIRANHA_HPP
#define PIRANHA_HPP

#include "Fish.hpp"
#include "Guppy.hpp"

class Piranha : public Fish {
    public:
        // Constructor: instantiate piranha at speed of 7 and eatRadius of 75
        Piranha(Aquarium& _aquarium);

        // Reference comparison
        bool operator==(const Piranha& other) const;

        // Find guppies in the aquarium
        Vector2 eat();

        // Remove this piranha from aquarium
        void destruct();

        static const int price;
    
    private:
        Guppy* findGuppy() const;
};

#endif