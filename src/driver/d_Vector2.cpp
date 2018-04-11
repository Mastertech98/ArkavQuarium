#include "../Vector2.hpp"
#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;

int main(int argc, char** argv){
	Vector2 test1;
	cout << "ctor 1" << endl;
	cout << "x : " << test1.x << endl;
	cout << "y : " << test1.y << endl;
	cout << endl;

    Vector2 test2(atoi(argv[1]), atoi(argv[2]));
    cout << "ctor 2" << endl;
	cout << "x : " << test2.x << endl;
	cout << "y : " << test2.y << endl;
	cout << endl;

	Vector2 test999(atoi(argv[3]), atoi(argv[4]));
    Vector2 test3 = test999;
    cout << "ctor 3" << endl;
	cout << "x : " << test3.x << endl;
	cout << "y : " << test3.y << endl;
	cout << endl;

	if(test2 != test3){
		cout << "test2 & test3 are different." << endl;
	} else {
		cout << "test2 & test3 are similar." << endl;
	}
	cout << endl;

	Vector2 test4 = test2 + test3;
	cout << "operator+" << endl;
	cout << "test2.x + test3.x : " << test4.x << endl;
	cout << "test2.y + test3.y : " << test4.y << endl;
	cout << endl;

	Vector2 test5 = test2 - test3;
	cout << "operator-" << endl;
	cout << "test2.x - test3.x : " << test5.x << endl;
	cout << "test2.y - test3.y : " << test5.y << endl;
	cout << endl;

	cout << "test2.distance(test3)" << endl;
	cout << test2.distance(test3) << endl;
	cout << endl;

	cout << "test2.normalized()" << endl;
	Vector2 test6 = test2.normalized();
	cout << "x : " << test6.x << endl;
	cout << "y : " << test6.y << endl;
	cout << endl;

	cout << "Vector2::randomPosition(test2.x,test2.y);" << endl;
	Vector2 test7 = Vector2::randomPosition(test2.x,test2.y);
	cout << "x : " << test7.x << endl;
	cout << "y : " << test7.y << endl;
	cout << endl;

	cout << "Vector2::randomDirection();" << endl;
	Vector2 test8 = Vector2::randomDirection();
	cout << "x : " << test8.x << endl;
	cout << "y : " << test8.y << endl;
	cout << endl;

	return 0;
}