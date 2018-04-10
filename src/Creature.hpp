#ifndef CREATURE_HPP
#define CREATURE_HPP

#include "AquariumObject.hpp"

class Creature : public AquariumObject {
    public:
        // Constructor
        Creature(Aquarium& _aquarium, float _speed, Vector2 _position, float _eatRadius);

        // Return eat rediu
        float getEatRadius() const;
        // Return x movement direction
        bool getIsMovingRight() const;

        // Set x movement direction
        void setIsMovingRight(bool _isMovingRight);

        // Abstract function of eat
        virtual Vector2 eat() = 0;

    private:
        const float eatRadius;
        bool isMovingRight;
};

#endif