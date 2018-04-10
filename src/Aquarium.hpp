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
        // Constuctor: set gameTime to 0, set egg to 0, add snail to game
        Aquarium(int _sizeX, int _sizeY, int _money, int _eggPrice);

        // Return aquarium x size
        int getSizeX() const;
        // Return aquarium y size
        int getSizeY() const;
        // Return game time
        int getGameTime() const;
        // Return reference of list of guppies
        LinkedList<Guppy>& getGuppies();
        // Return reference of list of piranhas
        LinkedList<Piranha>& getPiranhas();
        // Return reference of list of snails
        LinkedList<Snail>& getSnails();
        // Return reference of list of foods
        LinkedList<Food>& getFoods();
        // Return reference of list of coins
        LinkedList<Coin>& getCoins();
        // Return money
        int getMoney() const;
        // Return number of egg bought
        int getEgg() const;
        // Return egg price
        int getEggPrice() const;

        // Set game time
        void setGameTime(int _gameTime);
        // Set money
        void setMoney(int _money);
        // Set number of egg bought
        void setEgg(int _egg);
        // Set egg price
        void setEggPrice(int _eggPrice);
        
        // Add guppy to aquarium
        void add(const Guppy& guppy);
        // Add piranha to aquarium
        void add(const Piranha& piranha);
        // Add snail to aquarium
        void add(const Snail& snail);
        // Add food to aquarium
        void add(const Food& food);
        // Add coin to aquarium
        void add(const Coin& coin);

        // Remove guppy from aquarium
        void remove(const Guppy& guppy);
        // Remove piranha from aquarium
        void remove(const Piranha& piranha);
        // Remove snail from aquarium
        void remove(const Snail& snail);
        // Remove food from aquarium
        void remove(const Food& food);
        // Remove coin from aquarium
        void remove(const Coin& coin);

        // Do one game time unit: increment gameTime, call tick on all AquariumObject
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