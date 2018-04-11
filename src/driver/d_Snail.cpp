#include "../Snail.hpp"
#include "../Aquarium.hpp"
#include "../Coin.hpp"
#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc, char** argv){
	Aquarium aqtest1(50,50,100,10);
	Aquarium aqtest2(atoi(argv[1]), atoi(argv[2]), atoi(argv[3]), atoi(argv[4]));

	//constructor test
	Snail test1(aqtest1);
	cout << "Snail test1 is created with absis of " << test1.getPosition().x << endl;
	Snail test2(aqtest2);
	cout << "Snail test2 is created with absis of " << test2.getPosition().x << endl;


	//operator== test
	if(test1 == test1){
		cout << "Same object." << endl;
	} else { 
		cout << "Different object." << endl;
	}
	cout << endl;

	
	//move() test, including eat() and findFood()

	//print Snail's current position
	int a = test1.getPosition().x;
	cout << "Snail position before move : " << a << endl;
	//input Coin's absis
	int coinx;
	cout << "To test move() function, please put absis of Coin you want to create : "; cin >> coinx;
	//creating Coin
	Vector2 vectest2(coinx,49);
	Coin testcoin(aqtest1,vectest2,10);
	aqtest1.add(testcoin);
	cout << "Coin is placed in absis of " << coinx << endl;
	//try to move the Snail
	test1.move();
	//print Snail's position after move
	int b = test1.getPosition().x;
	cout << "Snail position after move : " << b << endl;
	if(a == b){
		cout << "Snail didn't move." << endl;
	} else {
		cout << "Snail did move." << endl;
	}


	return 0;
}