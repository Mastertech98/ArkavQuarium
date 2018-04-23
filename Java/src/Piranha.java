public class Piranha extends Fish {
    public Piranha(Aquarium _aquarium) {
        super(_aquarium, 7, 75);
    }

    public Vector2 eat() {
        Guppy guppy = findGuppy();
        if (guppy != null) {
            Vector2 guppyPosition = guppy.getPosition();
            if (getPosition().distance(guppyPosition) <= getEatRadius()) {
                dropCoin(Guppy.price * (guppy.getGrowthStage() + 1));
                guppy.destruct();

                int gameTime = getAquarium().getGameTime();
                setLastMealTime(gameTime);
                setLastMoveTime(gameTime);
                
                return null;
            } else {
                return guppyPosition;
            }
        } else {
            return null;
        }
    }

    public void destruct() {
        getAquarium().remove(this);
    }

    private Guppy findGuppy() {
        LinkedList<Guppy> guppies = getAquarium().getGuppies();
        if (guppies.isEmpty()) {
            return null;
        } else {
            Vector2 piranhaPosition = getPosition();
            ElementList<Guppy> guppy = guppies.getFirst();
            double guppyDistance = piranhaPosition.distance(guppy.getData().getPosition());
            for (ElementList<Guppy> e = guppy.getNext(); e != null; e = e.getNext()) {
                double eDistance = piranhaPosition.distance(e.getData().getPosition());
                if (eDistance < guppyDistance) {
                    guppy = e;
                    guppyDistance = eDistance;
                }
            }
            return guppy.getData();
        }
    }
}