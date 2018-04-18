#ifndef FISH_HPP
#define FISH_HPP

#include "Creature.hpp"
#include "IDestructible.hpp"

class Fish : public Creature, public IDestructible {
    public:
        /// Constructor: instantiate fish at random position
        Fish(Aquarium& _aquarium, float _speed, float _eatRadius);

        /// Return the duration of this fish full before hungry again
        int getFullTime() const;
        /// Return the duration of this fish hungry before it dies
        int getHungryTime() const;
        /// Return the duration of this fish moving before changing direction
        int getMoveTime() const;
        /// Return the last time this fish eats
        int getLastMealTime() const;
        /// Return the last time this fish moves
        int getLastMoveTime() const;

        /// Set the last time this fish eats
        void setLastMealTime(int _lastMealTime);
        /// Set the last time this fish moves
        void setLastMoveTime(int _lastMoveTime);

        /// Move towards food if this fish is hungry and food exist, move randomly otherwise
        void move();

        /// Drop coin from this fish
        void dropCoin(int value);

        /// Do one game time unit: dies if gameTime is greater than or equals the last time this fish eats plus the duration of this fish full before hungry again plus the duration of this fish hungry before it dies
        virtual void tick();

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