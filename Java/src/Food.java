public class Food extends AquariumObject implements IDestructible{
    public static final int price = 5;

    public Food(Aquarium _aquarium, float x){
        super(_aquarium,2,Vector2(x,0));
    }

    public void move(){
        setPosition(getPosition() + Vector2.down * getSpeed());
    }

    @override
    public void tick(){
        move();
        if(getPosition().y>=getAquarium().getSizeY()){
            destruct();
        }
    }
}