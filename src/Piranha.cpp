#include "Piranha.hpp"
#include "Aquarium.hpp"

const int Piranha::price = 20;

Piranha::Piranha(Aquarium& _aquarium) : Fish(_aquarium, 7, 75) {
    
}

bool Piranha::operator==(const Piranha& other) const {
    return this == &other;
}

Vector2 Piranha::eat() {
    Guppy* guppy = findGuppy();
    if (guppy) {
        Vector2 guppyPosition = guppy->getPosition();
        if (getPosition().distance(guppyPosition) <= getEatRadius()) {
            dropCoin(Guppy::price * (guppy->getGrowthStage() + 1));
            guppy->destruct();

            int gameTime = getAquarium().getGameTime();
            setLastMealTime(gameTime);
            setLastMoveTime(gameTime);
            
            return Vector2::null;
        } else {
            return guppyPosition;
        }
    } else {
        return Vector2::null;
    }
}

void Piranha::destruct() {
    getAquarium().remove(*this);
}

Guppy* Piranha::findGuppy() const {
    LinkedList<Guppy>& guppies = getAquarium().getGuppies();
    if (guppies.isEmpty()) {
        return 0;
    } else {
        Vector2 piranhaPosition = getPosition();
        ElementList<Guppy>* guppy = guppies.getFirst();
        double guppyDistance = piranhaPosition.distance(guppy->data.getPosition());
        for (ElementList<Guppy>* e = guppy->next; e != 0; e = e->next) {
            double eDistance = piranhaPosition.distance(e->data.getPosition());
            if (eDistance < guppyDistance) {
                guppy = e;
                guppyDistance = eDistance;
            }
        }
        return &guppy->data;
    }
}