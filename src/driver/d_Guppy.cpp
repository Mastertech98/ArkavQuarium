#include "../Guppy.hpp"
#include "../Aquarium.hpp"
#include "../Food.hpp"
#include <iostream>
#include <cstdlib>

using namespace std;


int main(int argc, char** argv){
	Aquarium aqtest1(50,50,100,10);
	Aquarium aqtest2(atoi(argv[1]), atoi(argv[2]), atoi(argv[3]), atoi(argv[4]));

	//ctor test
	Guppy test1(aqtest1);
	Guppy test2(aqtest2);

	//operator== test
	if(test1 == test1){
		cout << "Same object." << endl;
	} else { 
		cout << "Different object." << endl;
	}
	cout << endl;


	//getter test
	cout << "test1.getCoinDropPeriod() : " << test1.getCoinDropPeriod() << endl;
	cout << "test1.getGrowthStage() before set : " << test1.getGrowthStage() << endl;
	cout << "test1.getLastCoinDrop() before set : " << test1.getLastCoinDrop() << endl;
	cout << "test1.getEatenFood() before set : " << test1.getEatenFood() << endl;
	cout << endl;
	cout << "test2.getCoinDropPeriod() : " << test2.getCoinDropPeriod() << endl;
	cout << "test2.getGrowthStage() before set : " << test2.getGrowthStage() << endl;
	cout << "test2.getLastCoinDrop() before set : " << test2.getLastCoinDrop() << endl;
	cout << "test2.getEatenFood() before set : " << test2.getEatenFood() << endl;
	cout << endl;

	
	//setter test
	cout << "setLastCoinDrop for test1 : "; int a; cin >> a; test1.setLastCoinDrop(a);
	cout << "test1.getLastCoinDrop() after set: " << test1.getLastCoinDrop() << endl;
	cout << endl;

	
	cout << "setLastCoinDrop for test2 : "; int b; cin >> b; test2.setLastCoinDrop(b);
	cout << "test2.getLastCoinDrop() after set: " << test2.getLastCoinDrop() << endl;
	cout << endl;

	
	cout << "setEatenFood for test1 : "; int c; cin >> c; test1.setEatenFood(c);
	cout << "test1.getEatenFood() after set : " << test1.getEatenFood() << endl;
	cout << endl;

	
	cout << "setEatenFood for test2 : "; int d; cin >> d; test2.setEatenFood(d);
	cout << "test2.getEatenFood() after set : " << test2.getEatenFood() << endl;
	cout << endl;

	cout << "test1.getGrowthStage() after set : " << test1.getGrowthStage() << endl;
	cout << "test2.getGrowthStage() after set : " << test2.getGrowthStage() << endl;
	cout << endl;
	
	
	int foodx;
	cout << "To test move() function, please put absis of Food you want to create : "; cin >> foodx;
	Food food(aqtest1, foodx);
	aqtest1.add(food);
	aqtest1.add(test1);
	Guppy* guppy = &aqtest1.getGuppies().getFirst()->data;
	if (food.getPosition() == guppy->eat()){ 
		cout << "Guppy is trying to eat." << endl;
	} else {
		cout << "Guppy isn't trying to eat." << endl;
	}


	aqtest1.setGameTime(500);
	test1.tick();
	Coin* test3 = &aqtest1.getCoins().getFirst()->data;
	cout << "Coin value dropped after tick() : " << test3->getValue() << endl;
	cout << endl;

	return 0;
}