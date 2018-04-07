#ifndef AQUARIUMOBJECT_HPP
#define AQUARIUMOBJECT_HPP

#include "Vector2.hpp"

#include <iostream>

class Aquarium;

class AquariumObject {
    public:
        AquariumObject(Aquarium& _aquarium, float _speed, Vector2 _position);

        Aquarium& getAquarium() const ;
        
        float getSpeed() const;

        Vector2 getPosition() const;
        void setPosition(Vector2 _position);

        virtual void move() = 0;
        virtual void tick();

    private:
        Aquarium& aquarium;
        const float speed;
        Vector2 position; 
};

#endif