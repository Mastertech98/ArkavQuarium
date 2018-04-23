public class Creature extends AquariumObject{
	public Creature(Aquarium _aquarium, float _speed, Vector2 _position, float _eatRadius){
		isMovingRight = true;
	}
	
	public float getEatRadius(){
		return eatRadius;
	}	

	public boolean getIsMovingRight(){
		return isMovingRight;
	}

	public void setIsMovingRight(boolean _isMovingRight){
		isMovingRight = _isMovingRight;
	}

	private final float eatRadius;
	private boolean isMovingRight;
}