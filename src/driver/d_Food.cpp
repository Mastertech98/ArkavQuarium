#include "../Food.hpp"
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

	//ctor test
	Food test1(aqtest,atoi(argv[1]));
	Food test2(aqtest,8);

	//operator== test
	if(test1 == test1){
		cout << "Same object." << endl;
	} else { 
		cout << "Different object." << endl;
	}
	cout << endl;

	//move() test
	printvector(test1.getPosition());
	test1.move();
	cout << "position Food test1 after move" << endl;
	printvector(test1.getPosition());
	cout << endl;
	printvector(test2.getPosition());
	
	//move() at maximum coordinate test
	for(int z = 0; z < 26; z++){
		test2.move();
	}
	cout << "position Food test2 after 26 moves" << endl;
	printvector(test2.getPosition());
	cout << endl;
	/*
	test2.move();
	cout << "position Food test2 after being destructed and then trying to move" << endl;
	printvector(test2.getPosition());
	*/
	
	return 0;
}