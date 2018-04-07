#ifndef CREATURE_HPP
#define CREATURE_HPP

#include "AquariumObject.hpp"

class Creature : public AquariumObject {
    public:
        Creature(Aquarium& _aquarium, float _speed, Vector2 _position, float _eatRadius);

        float getEatRadius() const;
        bool getIsMovingRight() const;

        void setIsMovingRight(bool _isMovingRight);

        virtual Vector2 eat() = 0;

    private:
        const float eatRadius;
        bool isMovingRight;
};

#endif