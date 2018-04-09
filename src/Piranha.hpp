#ifndef PIRANHA_HPP
#define PIRANHA_HPP

#include "Fish.hpp"
#include "Guppy.hpp"

class Piranha : public Fish {
    public:
        Piranha(Aquarium& _aquarium);

        bool operator==(const Piranha& other) const;

        Vector2 eat();

        void destruct();

        static const int price;
    
    private:
        Guppy* findGuppy() const;
};

#endif