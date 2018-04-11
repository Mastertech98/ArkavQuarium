#ifndef GUPPY_HPP
#define GUPPY_HPP

#include "Fish.hpp"
#include "Food.hpp"

class Guppy : public Fish {
    public:
        /// Constructor: instantiate guppy at speed of 5 and eatRadius of 50
        Guppy(Aquarium& _aquarium);

        /// Reference comparison
        bool operator==(const Guppy& other) const;

        /// Return coin drop period
        int getCoinDropPeriod() const;
        /// Return the number of this guppy's eaten food
        int getEatenFood() const;
        /// Return the last time this guppy drops coin
        int getLastCoinDrop() const;
        /// Return the growth stage of this guppy based on this guppy's eaten food
        int getGrowthStage() const;

        /// Set the number of this guppy's eaten food
        void setEatenFood(int _eatenFood);
        /// Set the last time this guppy drops coin
        void setLastCoinDrop(int _lastCoinDrop);

        /// Find food in the aquarium
        Vector2 eat();

        /// Remove this guppy from aquarium
        void destruct();

        /// Do one game time unit: drops coin on coin drop period
        void tick();

        static const int price;

    private:
        const int coinDropPeriod;
        int eatenFood;
        int lastCoinDrop;
        Food* findFood();
};

#endif