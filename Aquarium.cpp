#include "Aquarium.hpp"

Aquarium::Aquarium(int _sizeX, int _sizeY) : sizeX(_sizeX), sizeY(_sizeY) {
    setGameTime(0);
}

int Aquarium::getSizeX() const {
    return sizeX;
}
int Aquarium::getSizeY() const {
    return sizeY;
}
int Aquarium::getGameTime() const {
    return gameTime;
}
LinkedList<Guppy>& Aquarium::getGuppies() {
    return guppies;
}
LinkedList<Piranha>& Aquarium::getPiranhas() {
    return piranhas;
}
LinkedList<Snail>& Aquarium::getSnails() {
    return snails;
}
LinkedList<Food>& Aquarium::getFoods() {
    return foods;
}
LinkedList<Coin>& Aquarium::getCoins() {
    return coins;
}
int Aquarium::getMoney() const {
    return money;
}
int Aquarium::getEgg() const {
    return egg;
}

void Aquarium::setGameTime(int _gameTime) {
    gameTime = _gameTime;
}
void Aquarium::setMoney(int _money) {
    money = _money;
}
void Aquarium::setEgg(int _egg) {
    egg = _egg;
}

void Aquarium::add(const Guppy& guppy) {
    guppies.add(guppy);
}
void Aquarium::add(const Piranha& piranha) {
    piranhas.add(piranha);
}
void Aquarium::add(const Snail& snail) {
    snails.add(snail);
}
void Aquarium::add(const Food& food) {
    foods.add(food);
}
void Aquarium::add(const Coin& coin) {
    coins.add(coin);
}

void Aquarium::remove(const Guppy& guppy) {
    guppies.remove(guppy);
}
void Aquarium::remove(const Piranha& piranha) {
    piranhas.remove(piranha);
}
void Aquarium::remove(const Snail& snail) {
    snails.remove(snail);
}
void Aquarium::remove(const Food& food) {
    foods.remove(food);
}
void Aquarium::remove(const Coin& coin) {
    coins.remove(coin);
}

void Aquarium::tick() {
    
}