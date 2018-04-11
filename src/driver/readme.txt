################ HOW TO RUN DRIVERS ###################


VECTOR2 DRIVER:

d_Vector2 <x1> <y1> <x2> <y2>

			where params are for Vector2 test2's & test3's constructor parameters.

command example:

make -f MakeVector
d_Vector2 10 -10 -20 -30
d_Vector2 10 20 10 20


///////////////////////////////////////////////////////////////////////////////////////////////////


GUPPY DRIVER:

d_Guppy <sizeX> <sizeY> <money> <eggPrice>

			where params are for Guppy test2's Aquarium constructor parameters.

command example:
make -f MakeGuppy
d_Guppy 50 50 100 30

///////////////////////////////////////////////////////////////////////////////////////////////////


PIRANHA DRIVER:

d_Piranha <sizeX> <sizeY> <money> <eggPrice>

			where params are for Piranha test2's Aquarium constructor parameters.

command example:
make -f MakePiranha
d_Piranha 50 50 100 30

///////////////////////////////////////////////////////////////////////////////////////////////////


SNAIL DRIVER:

d_Snail <sizeX> <sizeY> <money> <eggPrice>

			where params are for Snail test2's Aquarium constructor parameters.
			Snail will be created in x = (sizeX)/2

command example:

make -f MakeSnail
d_Snail 50 50 100 30


///////////////////////////////////////////////////////////////////////////////////////////////////


COIN DRIVER:

d_Coin <X> <Y> <value>

			where params are for Coin's spawn coordinates & value

command example:

make -f MakeCoin
d_Coin 20 30 5


///////////////////////////////////////////////////////////////////////////////////////////////////


FOOD DRIVER:

d_Food <X>

			where param is for Food's spawn absis

command example:

make -f MakeFood
d_Food 40