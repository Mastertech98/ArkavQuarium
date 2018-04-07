#include "Snail.hpp"
#include "Aquarium.hpp"

Snail::Snail(Aquarium& _aquarium) : Creature(_aquarium, 3, Vector2((double)_aquarium.getSizeX() / 2, _aquarium.getSizeY()), 3) {
    
}

bool Snail::operator==(const Snail& other) const {
    return this == &other;
}

void Snail::move() {
    Vector2 coinPosition = eat();
    if (coinPosition != Vector2::null) {
        double fX = coinPosition.x;
        double sX = getPosition().x;
        Vector2 direction = Vector2(fX == sX ? 0 : fX > sX ? 1 : -1, 0);
        setPosition(getPosition() + direction * getSpeed());
        setIsMovingRight(direction.x >= 0);
    } 
}

Vector2 Snail::eat() {
    Coin* coin = findCoin();
    if (coin) {
        Vector2 coinPosition = coin->getPosition();
        if (getPosition().distance(coinPosition) <= getEatRadius()) {
            getAquarium().setMoney(getAquarium().getMoney() + coin->getValue());
            coin->destruct();

            return Vector2::null;
        } else {
            return coinPosition;
        }
    } else {
        return Vector2::null;
    }
}

Coin* Snail::findCoin() const {
    LinkedList<Coin>& coins = getAquarium().getCoins();
    if (coins.isEmpty()) {
        return 0;
    } else {
        double aquariumSizeY = getAquarium().getSizeY();
        ElementList<Coin>* coin = coins.getFirst();
        double coinDistance = aquariumSizeY - coin->data.getPosition().y;
        for (ElementList<Coin>* e = coin->next; e != 0; e = e->next) {
            double eDistance = aquariumSizeY - coin->data.getPosition().y;
            if (eDistance < coinDistance) {
                coin = e;
                coinDistance = eDistance;
            }
        }
        return &coin->data;
    }
}