#ifndef GUPPY_HPP
#define GUPPY_HPP

#include "Fish.hpp"
#include "Food.hpp"

class Guppy : public Fish {
    public:
        Guppy(Aquarium& _aquarium);

        bool operator==(const Guppy& other) const;

        int getCoinDropPeriod() const;
        int getEatenFood() const;
        int getLastCoinDrop() const;
        int getGrowthStage() const;

        void setEatenFood(int _eatenFood);
        void setLastCoinDrop(int _lastCoinDrop);

        Vector2 eat();

        void destruct();

        void tick();

        static const int price;

    private:
        const int coinDropPeriod;
        int eatenFood;
        int lastCoinDrop;
        Food* findFood();
};

#endif