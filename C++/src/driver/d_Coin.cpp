#include "../Coin.hpp"
#include "../Aquarium.hpp"
#include <iostream>
#include <cstdlib>

using namespace std;

void printvector(Vector2 vectest){
	cout << "x : " << vectest.x << endl;
	cout << "y : " << vectest.y << endl;
}

int main(int argc, char** argv){
	Aquarium aqtest(50,50,100,10);
	Vector2 vectest1(atoi(argv[1]),atoi(argv[2]));
	Vector2 vectest2(49,49);

	Coin test1(aqtest,vectest1,atoi(argv[3]));
	Coin test2(aqtest,vectest2,10);

	if(test1 == test1){
		cout << "Same object." << endl;
	} else { 
		cout << "Different object." << endl;
	}
	cout << endl;

	cout << endl;
	cout << "value test1: " << test1.getValue() << endl;
	cout << "value test2: " << test2.getValue() << endl;
	cout << endl;

	printvector(test1.getPosition());
	test1.move();
	cout << "position Coin test1 after move" << endl;
	printvector(test1.getPosition());
	cout << endl;
	printvector(test2.getPosition());
	test2.move();
	cout << "position Coin test1 after move" << endl;
	printvector(test2.getPosition());
	cout << endl;

	//aqtest.add(test1);
	//aqtest.add(test2);
	//aqtest.getCoins().getFirst()->destruct();

	test1.take(); cout << "test1.take()" << endl;
	cout << "Current aqtest money: " << aqtest.getMoney() << endl;
	test2.take(); cout << "test2.take()" << endl;
	cout << "Current aqtest money: " << aqtest.getMoney() << endl;

	return 0;
}