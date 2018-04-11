#include "../Guppy.hpp"
#include "../Aquarium.hpp"
#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc, char** argv){
	Aquarium aqtest1(50,50,100,10);
	Aquarium aqtest2(atoi(argv[1]), atoi(argv[2]), atoi(argv[3]), atoi(argv[4]));

	Piranha test1(aqtest1);
	Piranha test2(aqtest2);

	if(test1 == test1){
		cout << "Same object." << endl;
	} else { 
		cout << "Different object." << endl;
	}
	cout << endl;

	Guppy guppy(aqtest1);
	guppy.setPosition(Vector2(1000, 1000));
	aqtest1.add(guppy);
	aqtest1.add(test1);
	Piranha* piranha = &aqtest1.getPiranhas().getFirst()->data;
	if (guppy.getPosition() == piranha->eat()){ 
		cout << "Piranha is trying to eat." << endl;
	} else {
		cout << "Piranha isn't trying to eat." << endl;
	}

	return 0;
}