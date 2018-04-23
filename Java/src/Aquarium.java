public class Aquarium{
    //Aquarium(int _sizeX, int _sizeY, int _money, int _eggPrice) : sizeX(_sizeX), sizeY(_sizeY) {

    private final int sizeX;
    private final int sizeY;
    private int gameTime;
    private LinkedList<Guppy> guppies;
    private LinkedList<Piranha> piranhas;
    private LinkedList<Snail> snails;
    private LinkedList<Food> foods;
    private LinkedList<Coin> coins;

    private int money;
    private int egg;
    private int eggPrice;
    
    public Aquarium(int _sizeX, int _sizeY, int _money, int _eggPrice){
        
        setGameTime(0);
        add(Snail(this));
        setMoney(_money);
        setEgg(0);
        setEggPrice(_eggPrice);
        sizeX = _sizeX;
        sizeY = _sizeY;
    }

    public int getSizeX(){
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    public int getGameTime(){
        return gameTime;
    }

    public LinkedList<Guppy> getGuppies(){
        return guppies;
    }

    public LinkedList<Piranha> getPiranhas(){
        return piranhas;
    }

    public LinkedList<Snail> getSnails(){
        return snails;
    }

    public LinkedList<Food> getFoods(){
        return foods;
    }

    public LinkedList<Coin> getCoins(){
        return coins;
    }

    public int getMoney(){
        return money;
    }

    public int getEgg(){
        return egg;
    }

    public int getEggPrice(){
        return eggPrice;
    }

    public void setGameTime(int _gameTime){
        gameTime = _gameTime;
    }

    public void setMoney(int _money){
        money = _money;
    }

    public void setEgg(int _egg){
        egg = _egg;
    }

    public void setEggPrice(int _eggPrice){
        eggPrice = _eggPrice;
    }

    public void add(Guppy guppy){
        guppies.add(guppy);
    }

    public void add(Piranha piranha){
        piranhas.add(piranha);
    }

    public void add(Snail snail){
        snails.add(snail);
    }

    public void add(Food food){
        foods.add(food);
    }

    public void add(Coin coin){
        coins.add(coin);
    }

    public void remove(Guppy guppy) {
        guppies.remove(guppy);
    }
    public void remove(Pirana piranha) {
        piranhas.remove(piranha);
    }
    public void remove(Snail  snail) {
        snails.remove(snail);
    }
    public void remove(Food food) {
        foods.remove(food);
    }
    public void remove(Coin coin) {
        coins.remove(coin);
    } 
    public void tick() {
        setGameTime(getGameTime() + 1);
    
        for (ElementList<Guppy> o = getGuppies().getFirst(),next = 0; o != 0; o = next) {
            next = o.next;
            o.data.tick();
        }
        for (ElementList<Piranha> o = getPiranhas().getFirst(),next = 0; o != 0; o = next) {
            next = o.next;
            o.data.tick();
        }
        for (ElementList<Snail> o = getSnails().getFirst(),next = 0; o != 0; o = next) {
            next = o.next;
            o.data.tick();
        }
        for (ElementList<Food> o = getFoods().getFirst(), next = 0; o != 0; o = next) {
            next = o.next;
            o.data.tick();
        }
        for (ElementList<Coin> o = getCoins().getFirst(), next = 0; o != 0; o = next) {
            next = o.next;
            o.data.tick();
        }
    }
}