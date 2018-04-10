#ifndef AQUARIUMOBJECT_HPP
#define AQUARIUMOBJECT_HPP

#include "Vector2.hpp"

#include <iostream>

class Aquarium;

class AquariumObject {
    public:
        // Constructor
        AquariumObject(Aquarium& _aquarium, float _speed, Vector2 _position);

        // Return reference to aquarium of this AquariumObject
        Aquarium& getAquarium() const;
        // Return speed
        float getSpeed() const;
        // Return position
        Vector2 getPosition() const;

        // Set position
        void setPosition(Vector2 _position);

        // Abstract function of move
        virtual void move() = 0;
        // Do one game time unit: moves
        virtual void tick();

    private:
        Aquarium& aquarium;
        const float speed;
        Vector2 position; 
};

#endif