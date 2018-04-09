#include "Snail.hpp"
#include "Aquarium.hpp"

Snail::Snail(Aquarium& _aquarium) : Creature(_aquarium, 3, Vector2((double)_aquarium.getSizeX() / 2, _aquarium.getSizeY()), 50) {
    
}

bool Snail::operator==(const Snail& other) const {
    return this == &other;
}

void Snail::move() {
    Vector2 coinPosition = eat();
    if (coinPosition != Vector2::null) {
        double fX = coinPosition.x;
        double sX = getPosition().x;
        Vector2 direction = Vector2(fabs(fX - sX) < 0.05 * getSpeed() ? 0 : fX > sX ? 1 : -1, 0);
        setPosition(getPosition() + direction * getSpeed());
        setIsMovingRight(direction.x >= 0);
    } 
}

Vector2 Snail::eat() {
    Coin* coin = findCoin();
    if (coin) {
        Vector2 coinPosition = coin->getPosition();
        for (ElementList<Coin>* e = getAquarium().getCoins().getFirst(); e != 0; e = e->next) {
            if (getPosition().distance(e->data.getPosition()) <= getEatRadius()) {
                e->data.take();
            }
        }

        return coinPosition;
    } else {
        return Vector2::null;
    }
}

Coin* Snail::findCoin() const {
    LinkedList<Coin>& coins = getAquarium().getCoins();
    if (coins.isEmpty()) {
        return 0;
    } else {
        struct Priority {
            bool onFloor;
            double distance;
        };
        double aquariumSizeY = getAquarium().getSizeY();
        ElementList<Coin>* coin = coins.getFirst();
        Vector2 coinPosition = coin->data.getPosition();
        
        Priority coinPriority;
        if (coinPosition.y == aquariumSizeY) {
            coinPriority.onFloor = true;
            coinPriority.distance = fabs(coinPosition.x - getPosition().x);
        } else {
            coinPriority.onFloor = false;
            coinPriority.distance = aquariumSizeY - coinPosition.y;
        }

        for (ElementList<Coin>* e = coin->next; e != 0; e = e->next) {
            Vector2 ePosition = e->data.getPosition();

            if (coinPriority.onFloor) {
                if (ePosition.y == aquariumSizeY) {
                    double eDistance = fabs(ePosition.x - getPosition().x);
                    if (eDistance < coinPriority.distance) {
                        coin = e;
                        coinPriority.distance = eDistance;
                    }
                }
            } else {
                if (ePosition.y == aquariumSizeY) {
                    coin = e;
                    coinPriority.onFloor = true;
                    coinPriority.distance = fabs(ePosition.x - getPosition().x);
                } else {
                    double eDistance = aquariumSizeY - ePosition.y;
                    if (eDistance < coinPriority.distance) {
                        coin = e;
                        coinPriority.distance = eDistance;
                    }
                }
            }
        }

        return &coin->data;
    }
}