#include "../Aquarium.hpp"
#include <iostream>
#include <sstream> 
using namespace std;

template <typename T>
void print(LinkedList<T>* element) {
    if (!element.isEmpty()) {
        ElementList<T>* e;
        int i = 1;
        for (e = element.getFirst(); e->next != 0; e = e->next){
        	std::cout << e->data << std::endl;
        	i++;
        };
    }
}

int main(){
	//membuat aquarium bernama aqua
	Aquarium aqua(10, 20,1000,100);

	//Test method getSizeX()
	cout << "TEST getSizeX()" << endl;
	if(aqua.getSizeX() == 10){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 10"<< endl;
	}

	//Test method getSizeY()
	cout << "TEST getSizeY()" << endl;
	if(aqua.getSizeY() == 20){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 20"<< endl;
	}

	//Test method getGameTime()
	cout << "TEST getGameTime()" << endl;
	if(aqua.getGameTime() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 0"<< endl;
	}

	//Test method getGuppies()
	cout << "TEST getGuppies() dan add()" << endl;
	aqua.add(Guppy(aqua));
	if(aqua.getGuppies().getFirst() != 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected not NULL"<< endl;
	}

	//Test method getPiranhas()
	cout << "TEST getPiranhas() dan add()" << endl;
	aqua.add(Piranha(aqua));
	if(aqua.getPiranhas().getFirst() != 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected not NULL"<< endl;
	}

	//Test method getSnails()
	cout << "TEST getSnails() dan add()" << endl;
	aqua.add(Snail(aqua));
	if(aqua.getSnails().getFirst() != 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected not NULL"<< endl;
	}

	//Test method getFoods()
	cout << "TEST getFoods() dan add()" << endl;
	aqua.add(Food(aqua,10));
	if(aqua.getFoods().getFirst() != 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected not NULL"<< endl;
	}

	//Test method getCoins()
	cout << "TEST getCoins() dan add()" << endl;
	aqua.add(Coin(aqua,Vector2(0,0),5));
	if(aqua.getCoins().getFirst() != 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected not NULL"<< endl;
	}

	//Test method getGuppies()
	cout << "TEST getGuppies() dan remove()" << endl;
	aqua.remove(aqua.getGuppies().getFirst()->data);
	if(aqua.getGuppies().getFirst() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected NULL"<< endl;
	}

	//Test method getPiranhas()
	cout << "TEST getPiranhas() dan remove()" << endl;
	aqua.remove(aqua.getPiranhas().getFirst() ->data);
	if(aqua.getPiranhas().getFirst() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected NULL"<< endl;
	}

	//Test method getSnails()
	cout << "TEST getSnails() dan remove()" << endl;
	aqua.remove(aqua.getSnails().getFirst() -> data);
	if(aqua.getSnails().getFirst() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected NULL"<< endl;
	}

	//Test method getFoods()
	cout << "TEST getFoods() dan remove()" << endl;
	aqua.remove(aqua.getFoods().getFirst() ->data);
	if(aqua.getFoods().getFirst() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected NULL"<< endl;
	}

	//Test method getCoins()
	cout << "TEST getCoins() dan remove()" << endl;
	aqua.remove(aqua.getCoins().getFirst()->data);
	if(aqua.getCoins().getFirst() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected NULL"<< endl;
	}

	//Test method getMoney()
	cout << "TEST getMoney()" << endl;
	if(aqua.getMoney() == 1000){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 1000"<< endl;
	}

	//Test method getEgg()
	cout << "TEST getEgg()" << endl;
	if(aqua.getEgg() == 0){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 0"<< endl;
	}

	//Test method getEggPrice()
	cout << "TEST getEggPrice()" << endl;
	if(aqua.getEggPrice() == 100){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 100"<< endl;
	}

	//Test method setGameTime(_gameTime)
	cout << "TEST setGameTime(_gameTime)" << endl;
	aqua.setGameTime(20);
	if(aqua.getGameTime() == 20){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 20"<< endl;
	}

	//Test method setMoney(_money)
	cout << "TEST setMoney(_money)" << endl;
	aqua.setMoney(1500);
	if(aqua.getMoney() == 1500){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 1500"<< endl;
	}

	//Test method setEgg(_egg)
	cout << "TEST setEgg(_egg)" << endl;
	aqua.setEgg(1);
	if(aqua.getEgg() == 1){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 1"<< endl;
	}

	//Test method setEggPrice(_eggPrice)
	cout << "TEST setEggPrice(_eggPrice)" << endl;
	aqua.setEggPrice(150);
	if(aqua.getEggPrice() == 150){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 150"<< endl;
	}

	//Test method tick()
	cout << "TEST tick()" << endl;
	aqua.tick();
	if(aqua.getGameTime() == 21){
		cout << "SUCCESS!!!" << endl;
	} else {
		cout << "FAILED!!!";
		cout << "Expected 20"<< endl;
	}
}


