#ifndef FISH_HPP
#define FISH_HPP

#include "Creature.hpp"
#include "IDestructible.hpp"

class Fish : public Creature, public IDestructible {
    public:
        Fish(Aquarium& _aquarium, float _speed, float _eatRadius);

        int getFullTime() const;
        int getHungryTime() const;
        int getMoveTime() const;
        int getLastMealTime() const;
        int getLastMoveTime() const;

        void setLastMealTime(int _lastMealTime);
        void setLastMoveTime(int _lastMoveTime);

        void move();

        void dropCoin(int value);

    private:
        void moveRandomly();
        const int fullTime;
        const int hungryTime;
        const int moveTime;
        int lastMealTime;
        int lastMoveTime;
        Vector2 direction;
};

#endif