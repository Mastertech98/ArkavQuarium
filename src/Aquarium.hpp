#ifndef AQUARIUM_HPP
#define AQUARIUM_HPP

#include "Guppy.hpp"
#include "Piranha.hpp"
#include "Snail.hpp"
#include "Food.hpp"
#include "Coin.hpp"
#include "LinkedList.hpp"

class Aquarium {
    public:
        Aquarium(int _sizeX, int _sizeY, int _money, int _eggPrice);

        int getSizeX() const;
        int getSizeY() const;
        int getGameTime() const;
        LinkedList<Guppy>& getGuppies();
        LinkedList<Piranha>& getPiranhas();
        LinkedList<Snail>& getSnails();
        LinkedList<Food>& getFoods();
        LinkedList<Coin>& getCoins();
        int getMoney() const;
        int getEgg() const;
        int getEggPrice() const;

        void setGameTime(int _gameTime);
        void setMoney(int _money);
        void setEgg(int _egg);
        void setEggPrice(int _eggPrice);
        
        void add(const Guppy& guppy);
        void add(const Piranha& piranha);
        void add(const Snail& snail);
        void add(const Food& food);
        void add(const Coin& coin);

        void remove(const Guppy& guppy);
        void remove(const Piranha& piranha);
        void remove(const Snail& snail);
        void remove(const Food& food);
        void remove(const Coin& coin);

        void tick();

    private:
        const int sizeX, sizeY;
        int gameTime;
        LinkedList<Guppy> guppies;
        LinkedList<Piranha> piranhas;
        LinkedList<Snail> snails;
        LinkedList<Food> foods;
        LinkedList<Coin> coins;

        int money;
        int egg;
        int eggPrice;
};

#endif