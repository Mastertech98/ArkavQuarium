#include "Guppy.hpp"
#include "Aquarium.hpp"

const int Guppy::price = 10;

Guppy::Guppy(Aquarium& _aquarium) : Fish(_aquarium, 5, 50), coinDropPeriod(10) {
    eatenFood = 0;
    lastCoinDrop = _aquarium.getGameTime();
}

bool Guppy::operator==(const Guppy& other) const {
    return this == &other;
}

int Guppy::getCoinDropPeriod() const {
    return coinDropPeriod;
}
int Guppy::getEatenFood() const {
    return eatenFood;
}
int Guppy::getLastCoinDrop() const {
    return lastCoinDrop;
}
int Guppy::getGrowthStage() const {
    if (eatenFood > 10) {
        return 3;
    }

    if (eatenFood > 5) {
        return 2;
    }

    return 1;
}

void Guppy::setEatenFood(int _eatenFood) {
    eatenFood = _eatenFood;
}
void Guppy::setLastCoinDrop(int _lastCoinDrop) {
    lastCoinDrop = _lastCoinDrop;
}

Vector2 Guppy::eat() {
    Food* food = findFood();
    if (food) {
        Vector2 foodPosition = food->getPosition();
        if (getPosition().distance(foodPosition) <= getEatRadius()) {
            ++eatenFood;
            food->destruct();

            int gameTime = getAquarium().getGameTime();
            setLastMealTime(gameTime);
            setLastMoveTime(gameTime);

            return Vector2::null;
        } else {
            return foodPosition;
        }
    } else {
        return Vector2::null;
    }
}

void Guppy::destruct() {
    std::cout << "Guppy Dead" << std::endl;
    getAquarium().remove(*this);
}

void Guppy::tick() {
    AquariumObject::tick();
    int gameTime = getAquarium().getGameTime();

    if (gameTime >= getLastCoinDrop() + getCoinDropPeriod()) {
        dropCoin(2 * getGrowthStage());
        setLastCoinDrop(gameTime);
    }

    if (gameTime >= getLastMealTime() + getFullTime() + getHungryTime()) {
        destruct();
    }
}

Food* Guppy::findFood() {
    LinkedList<Food>& foods = getAquarium().getFoods();
    if (foods.isEmpty()) {
        return 0;
    } else {
        Vector2 guppyPosition = getPosition();
        ElementList<Food>* food = foods.getFirst();
        double foodDistance = guppyPosition.distance(food->data.getPosition());
        for (ElementList<Food>* e = food->next; e != 0; e = e->next) {
            double eDistance = guppyPosition.distance(e->data.getPosition());
            if (eDistance < foodDistance) {
                food = e;
                foodDistance = eDistance;
            }
        }
        return &food->data;
    }
}